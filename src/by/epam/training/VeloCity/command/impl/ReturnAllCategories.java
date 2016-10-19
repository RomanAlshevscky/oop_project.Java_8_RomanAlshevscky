package by.epam.training.VeloCity.command.impl;

import by.epam.training.VeloCity.bean.Request;
import by.epam.training.VeloCity.bean.Response;
import by.epam.training.VeloCity.command.Command;
import by.epam.training.VeloCity.service.SearchCategoryService;
import by.epam.training.VeloCity.service.exception.ServiceException;
import by.epam.training.VeloCity.service.factory.ServiceFactory;

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
