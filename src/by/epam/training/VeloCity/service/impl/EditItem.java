package by.epam.training.velocity.service.impl;

import by.epam.training.velocity.bean.entity.Item;
import by.epam.training.velocity.dao.VeloDAO;
import by.epam.training.velocity.dao.exception.DAOException;
import by.epam.training.velocity.dao.factory.DAOFactory;
import by.epam.training.velocity.service.EditItemService;
import by.epam.training.velocity.service.exception.ServiceException;

public class EditItem implements EditItemService{
    @Override
    public void addItem(String categoryName, Item i) throws ServiceException {
        if(categoryName == null || i == null)
            throw new ServiceException();
        try {
            DAOFactory factory = DAOFactory.getInstance();
            VeloDAO dao = factory.getVeloDAO();
            dao.addItem(categoryName, i);
        } catch(DAOException de){
            throw new ServiceException(de.getMessage());
        }
    }

    @Override
    public void deleteItem(String itemName) throws ServiceException {
        if(itemName == null)
            throw new ServiceException();
        try {
            DAOFactory factory = DAOFactory.getInstance();
            VeloDAO dao = factory.getVeloDAO();
            dao.deleteItem(itemName);
        } catch(DAOException de){
            throw new ServiceException(de.getMessage());
        }
    }

    @Override
    public void editItem(String oldName, Item newItem) throws ServiceException {
        if(newItem == null || oldName == null)
            throw new ServiceException();
        try {
            DAOFactory factory = DAOFactory.getInstance();
            VeloDAO dao = factory.getVeloDAO();
            dao.editItem(newItem, oldName);
        } catch(DAOException de){
            throw new ServiceException(de.getMessage());
        }
    }
}
