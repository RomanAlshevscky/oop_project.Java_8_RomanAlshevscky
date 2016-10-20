package by.epam.training.velocity.command.impl;

import by.epam.training.velocity.bean.Request;
import by.epam.training.velocity.bean.Response;
import by.epam.training.velocity.command.Command;
import by.epam.training.velocity.service.SearchCategoryService;
import by.epam.training.velocity.service.exception.ServiceException;
import by.epam.training.velocity.service.factory.ServiceFactory;

import java.util.List;

public class ReturnAllCategories implements Command {
    @Override
    public Response execute(Request request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        SearchCategoryService searchService = factory.getSearchCategoryService();

        List<String> categoriesNames;
        Response response= new Response();
        try {

            categoriesNames = searchService.findAllCategoriesNames();
            response.setErrorStatus(false);
            response.setResponse(categoriesNames);

        } catch (ServiceException e) {

            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());

        }

        return response;
    }
}
