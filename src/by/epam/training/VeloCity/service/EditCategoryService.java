package by.epam.training.VeloCity.service;

import by.epam.training.VeloCity.service.exception.ServiceException;

public interface EditCategoryService {
    void addCategory(String categoryName) throws ServiceException;
    void deleteCategory(String categoryName) throws ServiceException;
    void editCategory(String newCatName, String oldCatName) throws ServiceException;
}
