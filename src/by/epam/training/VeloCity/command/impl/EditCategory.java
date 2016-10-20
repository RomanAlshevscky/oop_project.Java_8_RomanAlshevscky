package by.epam.training.velocity.command.impl;

import by.epam.training.velocity.bean.Request;
import by.epam.training.velocity.bean.Response;
import by.epam.training.velocity.command.Command;
import by.epam.training.velocity.service.EditCategoryService;
import by.epam.training.velocity.service.exception.ServiceException;
import by.epam.training.velocity.service.factory.ServiceFactory;

public class EditCategory implements Command{
    @Override
    public Response execute(Request request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        EditCategoryService edit = factory.getEditCategoryService();

        Response response= new Response();
        try {
            edit.editCategory(request.getParams().get(0), request.getParams().get(1));
            response.setErrorStatus(false);
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());
        }

        return response;
    }
}
