package by.epam.training.VeloCity.dao;

import by.epam.training.VeloCity.bean.entity.Item;
import by.epam.training.VeloCity.dao.exception.DAOException;

import java.util.List;

public interface VeloDAO {

    List<String> findAllCategoriesNames() throws DAOException;
    void addCategory(String name) throws DAOException;
    void deleteCategory(String name) throws DAOException;
    void editCategory(String oldName, String newName) throws DAOException;
    List<String> findAllCategoryItems(String categoryName) throws DAOException;
    void addItem(String category, Item i) throws DAOException;
    void deleteItem(String itemName) throws DAOException;
    void editItem(Item i, String oldName) throws DAOException;
    int findMaxItemPrice(String categoryName) throws DAOException;
    int findMinItemPrice(String categoryName) throws DAOException;
    int findCategoryItemsCount(String categoryName) throws DAOException;
}
