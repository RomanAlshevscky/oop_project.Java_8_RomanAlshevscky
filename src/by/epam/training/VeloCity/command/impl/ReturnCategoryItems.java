package by.epam.training.VeloCity.command.impl;

import by.epam.training.VeloCity.bean.Request;
import by.epam.training.VeloCity.bean.Response;
import by.epam.training.VeloCity.command.Command;
import by.epam.training.VeloCity.service.SearchItemService;
import by.epam.training.VeloCity.service.exception.ServiceException;
import by.epam.training.VeloCity.service.factory.ServiceFactory;

import java.util.List;

public class ReturnCategoryItems implements Command {
    @Override
    public Response execute(Request request) {
        ServiceFactory factory = ServiceFactory.getInstance();
        SearchItemService searchService = factory.getSearchItemService();

        List<String> categoryItemsNames;
        Response response= new Response();
        try {

            categoryItemsNames = searchService.findCategoryItemsNames(request.getParams().get(0));
            response.setErrorStatus(false);
            response.setResponse(categoryItemsNames);

        } catch (ServiceException e) {

            response.setErrorStatus(true);
            response.setErrorMessage(e.getMessage());

        }

        return response;
    }
}
