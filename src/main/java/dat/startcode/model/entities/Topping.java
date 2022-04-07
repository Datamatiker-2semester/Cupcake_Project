package dat.startcode.model.entities;

public class Topping {
    private int toppingPrice;
    private String toppingName;
    private int id;

    public Topping(int id, String toppingName, int price) {
        this.toppingPrice = price;
        this.toppingName = toppingName;
        this.id = id;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingPrice(int toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    @Override
    public String toString() {
        return "The following topping is: "+toppingName+" and costs: "+toppingPrice;
    }
}
