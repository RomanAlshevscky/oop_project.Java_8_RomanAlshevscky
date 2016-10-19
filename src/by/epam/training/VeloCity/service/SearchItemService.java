package by.epam.training.VeloCity.service;

import by.epam.training.VeloCity.bean.entity.Item;
import by.epam.training.VeloCity.service.exception.ServiceException;

import java.util.List;

public interface SearchItemService {
    List<String> findCategoryItemsNames(String categoryName) throws ServiceException;
}
