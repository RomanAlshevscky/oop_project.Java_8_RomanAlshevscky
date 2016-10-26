package by.epam.training.velocity.dao.impl;

import by.epam.training.velocity.bean.entity.Item;
import by.epam.training.velocity.dao.VeloDAO;
import by.epam.training.velocity.dao.exception.DAOException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MySQLVeloDAO implements VeloDAO {

    private static final String url = "jdbc:mysql://localhost:3306/velocity";
    private static final String user = "root";
    private static final String password = "7S8d4R5M}{";

    // здравствуй, многопоточность
    // и почему ты меня (т.е. тебя) так не людишь?
    // объект этого класса ОДИН, методы на нем могут вызываться параллельно
    // дальше думай сам
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public MySQLVeloDAO() {
        con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();//н-да
            // ну нет соединения, ну не беда, тихонько напечатаю об этом в консоль и затихарюсь
            // мало ли кто там это дао создает, может и пронесет
        }
    }

    @Override
    public List<String> findAllCategoriesNames() throws DAOException {
        String query = "select name from Categories";// в static final строки
        List<String> result = new LinkedList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getString("name"));// что мы делаем с константными строками?
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();// аналогично тихушничаем
            // работу с исключениями пропустили мимо
            // где throw new DAOException...?
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }// logging тут - а не ничего не делаем
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return result;
    }

    private int getCategoryLastId(){
        String query = "SELECT id FROM categories ORDER BY id desc LIMIT 1; ";
        int result = 0;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                result = rs.getInt("id");
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return result;
    }

    @Override
    public void addCategory(String name) throws DAOException {
        int newId = getCategoryLastId()+1;
        String query = "INSERT INTO Categories (id, name) VALUES(" + newId + ",\""+ name + "\");";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    @Override
    public void deleteCategory(String name) throws DAOException {
        String query = "DELETE FROM categories WHERE name =\"" + name + "\";";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    @Override
    public void editCategory(String oldName, String newName) throws DAOException {
        String query = "UPDATE categories SET name = \""+newName+"\" WHERE name =\""+oldName+"\" ";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    private int getCategoryId(String categoryName){
        String query = "SELECT id FROM categories WHERE name =\""+categoryName+"\"";
        int result = 0;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next())
                result = rs.getInt("id");
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return result;
    }

    @Override
    public List<String> findAllCategoryItems(String categoryName) throws DAOException {
        String query = "SELECT * FROM items WHERE c_id =\""+getCategoryId(categoryName)+"\"";
        List<String> result = new LinkedList<>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                result.add(rs.getString("i_name"));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return result;
    }

    private int getItemLastId(){
        String query = "SELECT i_id FROM Items ORDER BY i_id desc LIMIT 1; ";
        int result = 0;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                result = rs.getInt("i_id");
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return result;
    }

    @Override
    public void addItem(String category, Item i) throws DAOException {
        int newId = getItemLastId()+1;
        String query = "INSERT INTO Items (c_id, i_id, i_name, i_price, i_count) VALUES("
                + getCategoryId(category) + ","
                + newId + ",\""+ i.getName()
                + "\"," + i.getPrice() + "," + i.getCount() +");";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    @Override
    public void deleteItem(String itemName) throws DAOException {
        String query = "DELETE FROM Items WHERE i_name =\"" + itemName + "\";";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    @Override
    public void editItem(Item i, String oldName) throws DAOException {
        String query = "UPDATE Items SET i_name = \""+i.getName()
                + "\", i_price= " + i.getPrice() + ", i_count = "
                + i.getCount()+" WHERE i_name =\""+oldName+"\"";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    @Override
    public int findMaxItemPrice(String categoryName) throws DAOException {
        String query = "SELECT max(i_price) AS Max FROM items WHERE c_id = "+ getCategoryId(categoryName);
        int result = 0;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                result = rs.getInt("Max");
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return result;
    }

    @Override
    public int findCategoryItemsCount(String categoryName) throws DAOException {
        String query = "SELECT count(c_id) AS count FROM items WHERE c_id = "+ getCategoryId(categoryName);
        int result = 0;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                result = rs.getInt("count");
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return result;
    }

    @Override
    public int findMinItemPrice(String categoryName) throws DAOException {
        String query = "SELECT min(i_price) AS Min FROM items WHERE c_id = "+ getCategoryId(categoryName);
        int result = 0;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next()){
                result = rs.getInt("Min");
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException se) { /*can't do anything */ }
            try {
                rs.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
        return result;
    }
}
