package by.epam.training.VeloCity.service.impl;

import by.epam.training.VeloCity.dao.VeloDAO;
import by.epam.training.VeloCity.dao.exception.DAOException;
import by.epam.training.VeloCity.dao.factory.DAOFactory;
import by.epam.training.VeloCity.service.SearchCategoryService;
import by.epam.training.VeloCity.service.exception.ServiceException;

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
