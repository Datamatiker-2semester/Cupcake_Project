
import dat.startcode.model.entities.Topping;
import dat.startcode.model.entities.User;
import dat.startcode.model.entities.Bottom;
import dat.startcode.model.entities.Cupcake;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CupcakeMapper;

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
        List<Topping> toppingList = cupcakeMapper.getToppings();
        for (Topping topping : toppingList) {
            System.out.println(topping);
        }
    }
}
