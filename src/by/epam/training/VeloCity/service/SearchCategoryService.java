package by.epam.training.VeloCity.service;

import by.epam.training.VeloCity.service.exception.ServiceException;

import java.util.List;

public interface SearchCategoryService {

    List<String> findAllCategoriesNames() throws ServiceException;

}
