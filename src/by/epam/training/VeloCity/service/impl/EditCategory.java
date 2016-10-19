package by.epam.training.VeloCity.service.impl;

import by.epam.training.VeloCity.dao.VeloDAO;
import by.epam.training.VeloCity.dao.exception.DAOException;
import by.epam.training.VeloCity.dao.factory.DAOFactory;
import by.epam.training.VeloCity.service.EditCategoryService;
import by.epam.training.VeloCity.service.exception.ServiceException;

public class EditCategory implements EditCategoryService {
    @Override
    public void addCategory(String categoryName) throws ServiceException {
        if(categoryName == null)
            throw new ServiceException();
        try {
            DAOFactory factory = DAOFactory.getInstance();
            VeloDAO dao = factory.getVeloDAO();
            dao.addCategory(categoryName);
        } catch(DAOException de){
            throw new ServiceException(de.getMessage());
        }
    }

    @Override
    public void deleteCategory(String categoryName) throws ServiceException {
        if(categoryName == null)
            throw new ServiceException();
        try {
            DAOFactory factory = DAOFactory.getInstance();
            VeloDAO dao = factory.getVeloDAO();
            dao.deleteCategory(categoryName);
        } catch(DAOException de){
            throw new ServiceException(de.getMessage());
        }
    }

    @Override
    public void editCategory(String newCatName, String oldCatName) throws ServiceException {
        if(newCatName == null || oldCatName == null)
            throw new ServiceException();
        try {
            DAOFactory factory = DAOFactory.getInstance();
            VeloDAO dao = factory.getVeloDAO();
            dao.editCategory(newCatName, oldCatName);
        } catch(DAOException de){
            throw new ServiceException(de.getMessage());
        }
    }

}
