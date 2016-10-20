package by.epam.training.velocity.service.impl;

import by.epam.training.velocity.dao.VeloDAO;
import by.epam.training.velocity.dao.exception.DAOException;
import by.epam.training.velocity.dao.factory.DAOFactory;
import by.epam.training.velocity.service.SearchItemService;
import by.epam.training.velocity.service.exception.ServiceException;

import java.util.LinkedList;
import java.util.List;

public class SearchItem implements SearchItemService {
    @Override
    public List<String> findCategoryItemsNames(String categoryName) throws ServiceException {
        if(categoryName == null)
            throw new ServiceException();
        List<String> result = new LinkedList<>();
        try {
            DAOFactory factory = DAOFactory.getInstance();
            VeloDAO dao = factory.getVeloDAO();
            result = dao.findAllCategoryItems(categoryName);
        } catch(DAOException de){
            throw new ServiceException(de.getMessage());
        }
        return result;
    }
}
