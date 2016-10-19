package by.epam.training.VeloCity.service.impl;

import by.epam.training.VeloCity.bean.entity.CategoryReportEntity;
import by.epam.training.VeloCity.dao.VeloDAO;
import by.epam.training.VeloCity.dao.exception.DAOException;
import by.epam.training.VeloCity.dao.factory.DAOFactory;
import by.epam.training.VeloCity.service.ReportService;
import by.epam.training.VeloCity.service.exception.ServiceException;

import java.util.LinkedList;
import java.util.List;

public class Report implements ReportService {
    @Override
    public List<CategoryReportEntity> getReport() throws ServiceException {
        List<CategoryReportEntity> reports = new LinkedList<>();
        try {
            DAOFactory factory = DAOFactory.getInstance();
            VeloDAO dao = factory.getVeloDAO();
            List<String> categoriesNames = dao.findAllCategoriesNames();
            for(String name : categoriesNames){
                CategoryReportEntity report = new CategoryReportEntity();
                report.setCategoryName(name);
                report.setItemsCount(dao.findCategoryItemsCount(name));
                report.setMaxItemsPrice(dao.findMaxItemPrice(name));
                report.setMinItemsPrice(dao.findMinItemPrice(name));

                reports.add(report);
            }
        } catch(DAOException de){
            throw new ServiceException(de.getMessage());
        }
        return reports;
    }
}
