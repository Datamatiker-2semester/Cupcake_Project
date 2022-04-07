package dat.startcode.model.persistence;

import dat.startcode.model.entities.Topping;
import dat.startcode.model.entities.User;
import dat.startcode.model.entities.Bottom;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CupcakeMapper {

    ConnectionPool connectionPool;

    public CupcakeMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }


    public User login(String username, String password) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM bottom";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String role = rs.getString("role");
                    user = new User(username, password, role);
                } else {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }


    public ArrayList<Bottom> getBottom() throws DatabaseException {

        ArrayList<Bottom> bottomlist = new ArrayList<Bottom>();
        Logger.getLogger("web").log(Level.INFO, "");

        Bottom bottom;
        String sql = "SELECT * FROM bottom";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int bottomId = rs.getInt("bottom_id");
                    String bottomName = rs.getString("bottom_name");
                    int bottomPrice = rs.getInt("bottom_price");
                    bottomlist.add(bottom = new Bottom(bottomId, bottomName, bottomPrice));
                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Bottoms could not be found");
        }
        return bottomlist;
    }

    public ArrayList<Topping> getToppings() throws DatabaseException {

        ArrayList<Topping> toppingList = new ArrayList<Topping>();
        Logger.getLogger("web").log(Level.INFO, "");

        Topping topping;
        String sql = "SELECT * FROM topping";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int toppingId = rs.getInt("topping_id");
                    String toppingName = rs.getString("topping_name");
                    int toppingPrice = rs.getInt("topping_price");
                    toppingList.add(topping = new Topping(toppingId, toppingName, toppingPrice));
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Toppings could not be found");
        }
        return toppingList;
    }
}



