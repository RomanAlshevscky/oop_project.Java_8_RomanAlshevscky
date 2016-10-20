package by.epam.training.velocity.bean;

import java.util.List;

public class Request {

    private String commandName;
    private List<String> params;

    public void setCommandName(String value){
        commandName = value;
    }

    public String getCommandName(){
        return commandName;
    }

    public void setParams(List<String> values){
        params = values;
    }

    public List<String> getParams(){
        return params;
    }

}
