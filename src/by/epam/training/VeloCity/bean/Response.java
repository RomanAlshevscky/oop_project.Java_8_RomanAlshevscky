package by.epam.training.VeloCity.bean;

import java.util.LinkedList;
import java.util.List;

public class Response {

    private List<String> response;
    private boolean errorStatus;
    private String errorMessage;

    public Response(){
        errorStatus = false;
        errorMessage = "";
        response = new LinkedList<>();
    }

    public void setResponse(List<String> value){
        response = value;
    }

    public List<String> getResponse(){
        return response;
    }

    public void setErrorStatus(boolean value){
        errorStatus = value;
    }

    public boolean getErrorStatus(){
        return errorStatus;
    }

    public void setErrorMessage(String value){
        errorMessage = value;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
