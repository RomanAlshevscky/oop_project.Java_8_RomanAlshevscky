package by.epam.training.velocity.command.impl;

import by.epam.training.velocity.bean.Request;
import by.epam.training.velocity.bean.Response;
import by.epam.training.velocity.command.Command;
import by.epam.training.velocity.service.EditItemService;
import by.epam.training.velocity.service.exception.ServiceException;
import by.epam.training.velocity.service.factory.ServiceFactory;

public class DeleteItem implements Command {
    @Override
    public Response execute(Request request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        EditItemService edit = factory.getEditItemService();

        Response response= new Response();
        try {
            edit.deleteItem(request.getParams().get(0));
            response.setErrorStatus(false);
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());
        }

        return response;
    }
}
