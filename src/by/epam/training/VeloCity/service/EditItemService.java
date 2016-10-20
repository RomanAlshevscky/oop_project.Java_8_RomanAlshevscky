package by.epam.training.velocity.service;

import by.epam.training.velocity.bean.entity.Item;
import by.epam.training.velocity.service.exception.ServiceException;

public interface EditItemService {

    void addItem(String categoryName, Item i) throws ServiceException;
    void deleteItem(String itemName) throws ServiceException;
    void editItem(String oldName, Item newItem) throws ServiceException;
}
