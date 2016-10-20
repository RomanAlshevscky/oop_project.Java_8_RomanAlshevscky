package by.epam.training.velocity.service.impl;

import by.epam.training.velocity.bean.entity.CategoryReportEntity;
import by.epam.training.velocity.dao.VeloDAO;
import by.epam.training.velocity.dao.exception.DAOException;
import by.epam.training.velocity.dao.factory.DAOFactory;
import by.epam.training.velocity.service.ReportService;
import by.epam.training.velocity.service.exception.ServiceException;

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
