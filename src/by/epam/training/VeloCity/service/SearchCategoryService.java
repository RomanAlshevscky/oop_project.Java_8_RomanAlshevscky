package by.epam.training.velocity.service;

import by.epam.training.velocity.service.exception.ServiceException;

import java.util.List;

public interface SearchCategoryService {

    List<String> findAllCategoriesNames() throws ServiceException;

}
