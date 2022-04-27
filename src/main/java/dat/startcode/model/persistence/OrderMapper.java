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


    public int createOrder( int user_id) {

        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "insert into orderline (user_id) values (?)";

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

    public void createOrderLine(int order_id, int topping_id, int bottom_id, int cupcake_price)  {

        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "insert into orderline (order_id,topping_id,bottom_id,cupcake_price) values(?,?,?,?)";


        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

               ps.setInt(1,order_id);
               ps.setInt(2,topping_id);
               ps.setInt(3,bottom_id);
               ps.setInt(4,cupcake_price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
