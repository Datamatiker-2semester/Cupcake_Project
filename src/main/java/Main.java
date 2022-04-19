
import dat.startcode.model.entities.*;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CupcakeMapper;

import dat.startcode.model.persistence.UserMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.SQLException;

public class Main {

    public static void main( String args[]) throws SQLException, DatabaseException {
       ConnectionPool connectionPool = new ConnectionPool();
        CupcakeMapper cupcakeMapper = new CupcakeMapper(connectionPool);
        ;

        List<Topping> toppingList = cupcakeMapper.getToppings();
        for (Topping topping : toppingList) {
            System.out.println(topping);
        }

        List<Bottom> bottomList = cupcakeMapper.getBottom();
        for (Bottom bottom : bottomList) {
            System.out.println(bottom);
        }

        UserMapper userMapper = new UserMapper(connectionPool);
        List<User> users = userMapper.getUser();
        for (User user : users) {
            System.out.println(user);

        }

    }
}
