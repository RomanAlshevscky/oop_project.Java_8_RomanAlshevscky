package by.epam.training.velocity.view.Exception;


public class ViewException extends Exception {
    private static final long serialVersionUID = 1L;

    public ViewException(){
        super();
    }

    public ViewException(String message){
        super(message);
    }

    public ViewException(Exception e){
        super(e);
    }

    public ViewException(String message, Exception e){
        super(message, e);
    }

    @Override
    public String getMessage(){
        String message = this.getMessage();
        //add more info;
        return message;
    }
}