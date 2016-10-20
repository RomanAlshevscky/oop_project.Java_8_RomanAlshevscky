package by.epam.training.velocity.service;

import by.epam.training.velocity.bean.entity.CategoryReportEntity;
import by.epam.training.velocity.service.exception.ServiceException;

import java.util.List;

public interface ReportService {

    List<CategoryReportEntity> getReport() throws ServiceException;
}
