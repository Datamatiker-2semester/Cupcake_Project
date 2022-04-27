package dat.startcode.model.entities;

public class Order {

    int orderId;
    int userId;
    int totalPrice;

    public Order(int orderId, int userId, int totalPrice) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }


    public int getTotalPrice() {
        return totalPrice;
    }
}
