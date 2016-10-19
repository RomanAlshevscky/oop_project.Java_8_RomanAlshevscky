package by.epam.training.VeloCity.service;

import by.epam.training.VeloCity.bean.entity.Item;
import by.epam.training.VeloCity.service.exception.ServiceException;

public interface EditItemService {

    void addItem(String categoryName, Item i) throws ServiceException;
    void deleteItem(String itemName) throws ServiceException;
    void editItem(String oldName, Item newItem) throws ServiceException;
}
