package by.epam.training.velocity.service.impl;

import by.epam.training.velocity.dao.VeloDAO;
import by.epam.training.velocity.dao.exception.DAOException;
import by.epam.training.velocity.dao.factory.DAOFactory;
import by.epam.training.velocity.service.SearchCategoryService;
import by.epam.training.velocity.service.exception.ServiceException;

import java.util.LinkedList;
import java.util.List;

public class SearchCategory implements SearchCategoryService {
    @Override
    public List<String> findAllCategoriesNames() throws ServiceException {
        List<String> result = new LinkedList<>();
        try {
            DAOFactory factory = DAOFactory.getInstance();
            VeloDAO dao = factory.getVeloDAO();
            result = dao.findAllCategoriesNames();
        } catch(DAOException de){
            throw new ServiceException(de.getMessage());
        }
        return result;
    }
}
