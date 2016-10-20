package by.epam.training.velocity.service.exception;


public class ServiceException extends Exception {
    private static final long serialVersionUID = 1L;

    public ServiceException(){
        super();
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(Exception e){
        super(e);
    }

    public ServiceException(String message, Exception e){
        super(message, e);
    }

    @Override
    public String getMessage(){
        String message = this.getMessage();
        //add more info;
        return message;
    }
}
