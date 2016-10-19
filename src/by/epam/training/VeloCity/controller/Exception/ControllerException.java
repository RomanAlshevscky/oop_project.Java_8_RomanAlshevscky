package by.epam.training.VeloCity.controller.Exception;

public class ControllerException extends Exception {
    private static final long serialVersionUID = 1L;

    public ControllerException() {
        super();
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(Exception e) {
        super(e);
    }

    public ControllerException(String message, Exception e) {
        super(message, e);
    }

    @Override
    public String getMessage() {
        String message = this.getMessage();
        //add more info;
        return message;
    }
}
