package dat.startcode.model.entities;

import java.util.Date;

public class Orderline {

    int orderLineId;
    int orderID;
    int quantity;
    int toppingId;
    int bottomId;
    int price;
    

    public Orderline(int orderID, int quantity, int toppingId, int bottomId, int price) {
        this.orderID = orderID;
        this.quantity = quantity;
        this.toppingId = toppingId;
        this.bottomId = bottomId;
        this.price = price;
    }

    public int getOderLineId() {
        return orderLineId;
    }

    public int getOderID() {
        return orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getToppingId() {
        return toppingId;
    }

    public int getBottomId() {
        return bottomId;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Your order ID is: "+orderID+" you have ordered: "+quantity+" amounts of cupcakes";
    }
}
