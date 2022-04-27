package dat.startcode.model.persistence;

import dat.startcode.model.entities.Cupcake;
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

    public ArrayList<Bottom> getBottom() throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");

        ArrayList<Bottom> bottomArrayList = new ArrayList<>();

        String sql = "SELECT * FROM cupcake.bottom";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    String name = rs.getString("bottom_name");
                    int price = rs.getInt("bottom_price");

                    Bottom bottom = new Bottom(name,price);
                    bottomArrayList.add(bottom);

                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Bottoms could not be found");
        }
        return bottomArrayList;
    }

    public Bottom getBottomFromID(int bottomId){
        Logger.getLogger("web").log(Level.INFO, "");

        Bottom bottom = null;
        String sql = "SELECT * FROM bottom where bottom_id= ? ";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1,bottomId);

                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    String bottomName = rs.getString("bottom_name");
                    int price = rs.getInt("bottom_price");

                    bottom = new Bottom(bottomName,price);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bottom;
    }

    public ArrayList<Topping> getToppings() throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");

        ArrayList<Topping> toppingArrayList = new ArrayList<>();

        String sql = "SELECT * FROM cupcake.topping";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    String name = rs.getString("topping_name");
                    int price = rs.getInt("topping_price");
                    Topping topping = new Topping(name,price);
                    toppingArrayList.add(topping);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Toppings could not be found");
        }
        return toppingArrayList;
    }

    public Topping getToppingFromID(int toppingId){

        Logger.getLogger("web").log(Level.INFO, "");

        Topping topping = null;

        String sql = "SELECT * FROM topping where topping_id= ? ";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1,toppingId);

                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    String toppingName = rs.getString("topping_name");
                    int price = rs.getInt("topping_price");

                    topping = new Topping(toppingName,price);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topping;

    }
}



