package by.epam.training.VeloCity.command.impl;

import by.epam.training.VeloCity.bean.Request;
import by.epam.training.VeloCity.bean.Response;
import by.epam.training.VeloCity.bean.entity.Item;
import by.epam.training.VeloCity.command.Command;
import by.epam.training.VeloCity.service.EditItemService;
import by.epam.training.VeloCity.service.exception.ServiceException;
import by.epam.training.VeloCity.service.factory.ServiceFactory;

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
