package by.epam.training.velocity.dao.factory;

import by.epam.training.velocity.dao.VeloDAO;
import by.epam.training.velocity.dao.impl.MySQLVeloDAO;

/**
 * Created by User on 18.10.2016.
 */
public class DAOFactory {
    private static final DAOFactory INSTANCE = new DAOFactory();

    private VeloDAO veloDao = new MySQLVeloDAO();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return INSTANCE;
    }

    public VeloDAO getVeloDAO(){
        return veloDao;
    }

}
