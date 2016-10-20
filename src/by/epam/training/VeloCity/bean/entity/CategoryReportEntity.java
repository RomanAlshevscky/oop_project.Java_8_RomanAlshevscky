package by.epam.training.velocity.bean.entity;

public class CategoryReportEntity {
    private String categoryName;
    private int itemsCount;
    private int maxItemsPrice;
    private int minItemsPrice;

    public void setCategoryName(String value){
        categoryName = value;
    }

    public String getCategoryName(){
        return categoryName;
    }

    public void setItemsCount(int value){
        itemsCount = value;
    }

    public int getItemsCount(){
        return itemsCount;
    }

    public void setMaxItemsPrice(int value){
        maxItemsPrice = value;
    }

    public int getMaxItemsPrice(){
        return maxItemsPrice;
    }

    public void setMinItemsPrice(int value){
        minItemsPrice = value;
    }

    public int getMinItemsPrice(){
        return minItemsPrice;
    }

}
