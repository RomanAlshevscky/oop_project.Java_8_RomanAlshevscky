package by.epam.training.velocity.bean.entity;

public class Item {

    private String name;
    private int price;
    private int count;

    public Item(String name, int price, int count){
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName(){
        return name;
    }

    public void setName(String value){
        name = value;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int value){
        price = value;
    }

    public int getCount(){
        return count;
    }

    public void setCount(int value){
        count = value;
    }
}
