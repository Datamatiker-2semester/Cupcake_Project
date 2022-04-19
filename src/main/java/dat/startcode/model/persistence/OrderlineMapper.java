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
    CupcakeMapper cupcakeMapper;

    public OrderlineMapper(ConnectionPool connectionPool) {

        this.connectionPool = connectionPool;
    }


    public Orderline createOrderline( int topping_id, int bottom_id, int cupcake_price) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");
        Orderline orderline;
        String sql = "insert into orderline (topping_id, bottom_id, cupcake_price) values (?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, topping_id);
                ps.setInt(2, bottom_id);
                ps.setInt(3,cupcake_price);
                int rowsAffected = ps.executeUpdate();


                if (rowsAffected == 1) {
                    orderline = new Orderline(topping_id,bottom_id,cupcake_price);
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
                    int topping_id = rs.getInt("topping_id");
                    int bottom_id = rs.getInt("bottom_id");
                    int cupcake_price = rs.getInt("cupcake_price");
                    orderlineList.add(orderline = new Orderline(topping_id,bottom_id,cupcake_price ));
                }
            }
        } catch (
                SQLException ex) {
            throw new DatabaseException(ex, "Orderlines could not be found");
        }
        return orderlineList;
    }
}
