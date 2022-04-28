package dat.startcode.model.persistence;

import dat.startcode.model.entities.*;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    ConnectionPool connectionPool;


    public OrderMapper(ConnectionPool connectionPool) {

        this.connectionPool = connectionPool;
    }


    public int createOrder( int user_id) throws DatabaseException{

        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "insert into order (user_id) values (?)";

        boolean newOrder = false;
        int newId = 0;

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, String.valueOf(user_id));

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected == 1) {

                    newOrder = true;

                } else {

                    throw new DatabaseException("The order couldn't be inserted into the database");
                }
                ResultSet resultSet = ps.getGeneratedKeys();
                if (resultSet.next()) {
                    newId = resultSet.getInt(1);
                }
            }
        } catch (SQLException | DatabaseException e) {
                e.printStackTrace();
        }

        return newId;
    }

    public void createOrderLine(int order_id, int topping_id, int bottom_id, int amount) throws DatabaseException  {

        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "insert into orderline (order_id,topping_id,bottom_id,amount) values(?,?,?,?)";


        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

               ps.setInt(1,order_id);
               ps.setInt(2,topping_id);
               ps.setInt(3,bottom_id);
               ps.setInt(4,amount);
            }
        } catch (SQLException e) {
            throw new DatabaseException("The orderline couldn't be created");
        }
    }
    public ArrayList<Cupcake> orderlineData(int orderId) {

        ArrayList<Cupcake> cupcakes = new ArrayList<>();

        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "select orderline.bottom_id, orderline.topping_id, bottom_name, bottom_price , topping_name, topping_price, amount from orderline" +
                "inner join bottom on orderline.bottom_id = bottom.bottom_id " +
                "inner join topping on orderline.topping_id = topping.topping_id " +
                "where order_id = ?;";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1,orderId);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int bottomId = rs.getInt("bottom_id");
                    int toppingId = rs.getInt("topping_id");

                    String bottom = rs.getString("bottom_name");
                    int bottomPrice = rs.getInt("bottom_price");
                    String topping = rs.getString("topping_name");
                    int toppingPrice = rs.getInt("topping_price");
                    int amount = rs.getInt("amount");

                    cupcakes.add(new Cupcake(bottomId,toppingId,bottom, bottomPrice, topping, toppingPrice, amount));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cupcakes;
    }
    public void deleteOrderline(int orderId, Cupcake cupcake){

        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "delete from orderline where order_id = ? AND bottom_id = ? AND topping_id = ? AND amount = ?;";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ps.setInt(2, cupcake.getBottomId());
                ps.setInt(3, cupcake.getToppingId());
                ps.setInt(4, cupcake.getAmount());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteOrder(int orderId){
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "delete from orderline where order_id = 13;";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "delete from `order` where order_id = ?;";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
