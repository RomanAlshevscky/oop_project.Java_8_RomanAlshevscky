package by.epam.training.VeloCity.command.impl;

import by.epam.training.VeloCity.bean.Request;
import by.epam.training.VeloCity.bean.Response;
import by.epam.training.VeloCity.command.Command;
import by.epam.training.VeloCity.service.EditCategoryService;
import by.epam.training.VeloCity.service.exception.ServiceException;
import by.epam.training.VeloCity.service.factory.ServiceFactory;

public class DeleteCategory implements Command {
    @Override
    public Response execute(Request request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        EditCategoryService edit = factory.getEditCategoryService();

        Response response= new Response();
        try {
            edit.deleteCategory(request.getParams().get(0));
            response.setErrorStatus(false);
        } catch (ServiceException e) {
            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());
        }

        return response;
    }
}
