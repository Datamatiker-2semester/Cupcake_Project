package dat.startcode.model.entities;

import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CupcakeMapper;

import java.util.Date;

public class Orderline {

    private int order_id = 1;
    private int topping_id;
    private int bottom_id;
    private int cupcake_price;

    public Orderline(int topping_id, int bottom_id, int cupcake_price) {
        this.order_id++;
        this.topping_id = topping_id;
        this.bottom_id = bottom_id;
        this.cupcake_price = cupcake_price;
    }

    @Override
    public String toString() {
        return "Your order ID is: "+order_id+" you have ordered: ";
    }
}
