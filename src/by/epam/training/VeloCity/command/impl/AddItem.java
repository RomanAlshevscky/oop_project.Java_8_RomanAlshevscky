package by.epam.training.velocity.command.impl;

import by.epam.training.velocity.bean.Request;
import by.epam.training.velocity.bean.Response;
import by.epam.training.velocity.bean.entity.Item;
import by.epam.training.velocity.command.Command;
import by.epam.training.velocity.service.EditItemService;
import by.epam.training.velocity.service.exception.ServiceException;
import by.epam.training.velocity.service.factory.ServiceFactory;

public class AddItem implements Command {
    @Override
    public Response execute(Request request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        EditItemService edit = factory.getEditItemService();

        Response response= new Response();
        try {
            String name = request.getParams().get(1);
            int price = Integer.parseInt(request.getParams().get(2));
            int count = Integer.parseInt(request.getParams().get(3));

            Item i = new Item(name, price, count);
            edit.addItem(request.getParams().get(0), i);

            response.setErrorStatus(false);
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());
        }

        return response;

    }
}
