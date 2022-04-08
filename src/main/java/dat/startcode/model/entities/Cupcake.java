package dat.startcode.model.entities;

public class Cupcake {
    private Bottom bottom;
    private Topping topping;
    private int totalPrice;
    private int cupcakeID;

    public Cupcake(Bottom bottom, Topping topping, int totalPrice, int cupcakeID) {
        this.bottom = bottom;
        this.topping = topping;
        this.totalPrice = totalPrice;
        this.cupcakeID = cupcakeID;
    }

    public int priceOfCupcake(Bottom bottom,Topping topping){
        totalPrice= bottom.getBottomPrice()+topping.getToppingPrice();
        return totalPrice;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public int getCupcakeID() {
        return cupcakeID;
    }

    @Override
    public String toString() {
        return "Your cupcake: \n"+"Bottom: "+bottom.getBottomName()+" Topping: "+topping.getToppingName();
    }
}
