package by.epam.training.velocity.controller;

import by.epam.training.velocity.bean.Request;
import by.epam.training.velocity.bean.Response;
import by.epam.training.velocity.command.Command;
import by.epam.training.velocity.controller.Exception.ControllerException;

public class Controller {
    private final CommandProvider provider = new CommandProvider();

    public Response doAction(Request request) throws ControllerException {
        String commandName = request.getCommandName();

        Command command = provider.getCommand(commandName);

        if (command == null)
            throw new ControllerException();
        Response response = command.execute(request);

        return response;
    }

}
