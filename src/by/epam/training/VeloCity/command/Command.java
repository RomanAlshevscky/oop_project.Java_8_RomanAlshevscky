package by.epam.training.velocity.command;

import by.epam.training.velocity.bean.Request;
import by.epam.training.velocity.bean.Response;

public interface Command {

    Response execute(Request request);
}
