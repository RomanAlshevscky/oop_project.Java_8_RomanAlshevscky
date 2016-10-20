package by.epam.training.velocity.bean.entity;

import java.util.LinkedList;

public class Category {

    private String name;
    private LinkedList<Item> itemList;

    public Category(String name){
        this.name = name;
        itemList = new LinkedList<>();
    }

    public void addItem(Item i){
        itemList.add(i);
    }

    /**
     * Return item by name. If there's no such item - return null;
     * @param name
     * @return
     */
    public Item getItem(String name){
        for(Item i: itemList){
            if(i.getName() == name)
                return i;
        }
        return null;
    }

    public boolean deleteItem(String name) {
        Item i = getItem(name);
        if (i != null) {
            itemList.remove();
            return true;
        }
        return false;
    }
}
