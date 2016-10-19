package by.epam.training.VeloCity.command;

import by.epam.training.VeloCity.bean.Request;
import by.epam.training.VeloCity.bean.Response;

public interface Command {

    Response execute(Request request);
}
