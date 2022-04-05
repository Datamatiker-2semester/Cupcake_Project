package dat.startcode.model.persistence;

import dat.startcode.model.entities.User;
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

    public CupcakeMapper(ConnectionPool connectionPool)
    {
        this.connectionPool = connectionPool;
    }


    public User login(String username, String password) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM bottom";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String role = rs.getString("role");
                    user = new User(username, password, role);
                } else
                {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }


    public User createBottom(int bottom_id, String bottom_name, int bottom_price) throws DatabaseException
    {
        ArrayList<Bottom> bottomlist = new ArrayList<Bottom>();
        Logger.getLogger("web").log(Level.INFO, "");
        Cupcake cupcake;
        String sql = "SELECT * FROM bottom";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, bottom_id);
                ps.setString(2, bottom_name);
                ps.setInt(3, bottom_price);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    cupcake = new User(bottom_id, bottom_name, bottom_price);
                } else
                {
                    throw new DatabaseException("The cupcake could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return user;
    }


}

