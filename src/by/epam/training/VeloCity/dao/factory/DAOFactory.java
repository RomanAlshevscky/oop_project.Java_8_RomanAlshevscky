package by.epam.training.VeloCity.dao.factory;

import by.epam.training.VeloCity.dao.VeloDAO;
import by.epam.training.VeloCity.dao.impl.MySQLVeloDAO;

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
