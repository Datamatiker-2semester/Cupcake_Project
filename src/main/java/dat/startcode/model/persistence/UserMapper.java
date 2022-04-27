package dat.startcode.model.persistence;

import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserMapper implements IUserMapper {
    ConnectionPool connectionPool;
    User user;

    public UserMapper(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public User login(String username, String password) throws DatabaseException {

        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;
        int userId;
        String role;
        int balance;
        String email;


        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {


                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    userId = rs.getInt("user_id");
                    email = rs.getString("email");
                    role = rs.getString("role");
                    balance = rs.getInt("balance");
                    user = new User (userId,username,password,email,role,balance);
                } else {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    @Override
    public User createUser(String username, String password, String email) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String sql = "insert into user (username,password,email) values (?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, email);

                int maxUsers = ps.getMaxRows();

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {

                    user = new User(maxUsers,username,password,email);


                } else {
                    throw new DatabaseException("The user with username = " + username + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return user;
    }

    @Override
    public ArrayList<User> getUser() throws DatabaseException {
        ArrayList<User> userList = new ArrayList<>();
        Logger.getLogger("web").log(Level.INFO, "");

        User user;
        String sql = "SELECT * FROM user";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int userId = rs.getInt("user_id");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String email = rs.getString("email");
                    String role = rs.getString("role");
                    int balance = rs.getInt("balance");
                    userList.add( new User(userId,username,password,email,role,balance));
                }
            }

        } catch (SQLException ex) {
            throw new DatabaseException(ex, "User could not be found");
        }
        return userList;
    }
    public void updateUser(User user){

        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "update `user` set `username` = ?, email = ?, balance = ? where user_id = ?;";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getEmail());
                ps.setInt(3,user.getBalance());
                ps.setInt(4,user.getUserId());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}