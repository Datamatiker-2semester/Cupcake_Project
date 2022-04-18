package dat.startcode.model.persistence;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import dat.startcode.model.entities.*;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderlineMapper {

    ConnectionPool connectionPool;

    public OrderlineMapper(ConnectionPool connectionPool) {

        this.connectionPool = connectionPool;
    }

    public Orderline createOrderline(int order_id, int quantity, int price, int topping_id, int bottom_id) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        Orderline orderline;
        String sql = "insert into orderline (order_id, quantity, price, topping_id, bottom_id) values (?,?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                ps.setInt(2, quantity);
                ps.setInt(3, price);
                ps.setInt(4,topping_id);
                ps.setInt(5,bottom_id);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    orderline = new Orderline(order_id,quantity,price,topping_id,bottom_id);
                } else {
                    throw new DatabaseException("The cupcake couldn't be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert Orderline into the database");
        }
        return orderline;
    }

    public ArrayList<Orderline> getOrderline() throws DatabaseException {

        ArrayList<Orderline> orderlineList = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");

        Orderline orderline;
        String sql = "SELECT * FROM orderline";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    int quantity = rs.getInt("quantity");
                    int price = rs.getInt("price");
                    int toppingId = rs.getInt("topping_id");
                    int bottomId = rs.getInt("bottom_id");
                    orderlineList.add(orderline = new Orderline(orderId,quantity,price,toppingId,bottomId));
                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Orderlines could not be found");
        }
        return orderlineList;
    }
}
