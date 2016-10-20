package by.epam.training.velocity.service.factory;

import by.epam.training.velocity.service.*;
import by.epam.training.velocity.service.impl.*;


public class ServiceFactory {
    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private SearchCategoryService searchCategory = new SearchCategory();
    private EditCategoryService editCategory = new EditCategory();
    private SearchItemService searchItem = new SearchItem();
    private EditItemService editItem = new EditItem();
    private ReportService report = new Report();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public SearchCategoryService getSearchCategoryService() {
        return searchCategory;
    }

    public EditCategoryService getEditCategoryService() {
        return editCategory;
    }

    public SearchItemService getSearchItemService() {
        return searchItem;
    }

    public EditItemService getEditItemService() {
        return editItem;
    }

    public ReportService getReportService(){
        return report;
    }

}