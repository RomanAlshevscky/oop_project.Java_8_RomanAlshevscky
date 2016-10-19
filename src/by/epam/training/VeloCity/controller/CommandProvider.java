package by.epam.training.VeloCity.controller;

import by.epam.training.VeloCity.command.Command;
import by.epam.training.VeloCity.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private Map<String, Command> commands = new HashMap<>();

    CommandProvider() {
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
