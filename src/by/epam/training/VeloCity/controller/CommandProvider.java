package by.epam.training.velocity.controller;

import by.epam.training.velocity.command.Command;
import by.epam.training.velocity.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    CommandProvider() {// public  класс с ещинственным friendly конструктором - кого троллим?
        // что мы делаем с константными строками с коде?
        commands.put("RETURN_ALL_CATEGORIES", new ReturnAllCategories());
        commands.put("ADD_CATEGORY", new AddCategory());
        commands.put("DELETE_CATEGORY", new DeleteCategory());
        commands.put("EDIT_CATEGORY", new EditCategory());
        commands.put("RETURN_CATEGORY_ITEMS", new ReturnCategoryItems());
        commands.put("ADD_ITEM", new AddItem());
        commands.put("DELETE_ITEM", new DeleteItem());
        commands.put("EDIT_ITEM", new EditItem());
        commands.put("RETURN_REPORT", new ReturnReport());
    }

    public Command getCommand(String commandName){
        Command command;
        command = commands.get(commandName);
        return command;
    }
}
