package by.epam.training.VeloCity.service;

import by.epam.training.VeloCity.bean.entity.CategoryReportEntity;
import by.epam.training.VeloCity.service.exception.ServiceException;

import java.util.List;

public interface ReportService {

    List<CategoryReportEntity> getReport() throws ServiceException;
}
