package by.epam.training.VeloCity.dao.exception;


public class DAOException extends Exception {
    private static final long serialVersionUID = 1L;

    public DAOException(){
        super();
    }

    public DAOException(String message){
        super(message);
    }

    public DAOException(Exception e){
        super(e);
    }

    public DAOException(String message, Exception e){
        super(message, e);
    }

    @Override
    public String getMessage(){
        String message = this.getMessage();
        //add more info;
        return message;
    }
}
