package dat.startcode.model.entities;

public class Bottom {
    private int bottomPrice;
    private String bottomName;

    public Bottom(int bottom_id, String bottomName, int price) {
        this.bottomPrice = price;
        this.bottomName = bottomName;
    }

    public int getBottomPrice() {
        return bottomPrice;
    }

    public String getBottomName() {
        return bottomName;
    }

    public void setBottomPrice(int bottomPrice) {
        this.bottomPrice = bottomPrice;
    }

    public void setBottomName(String bottomName) {
        this.bottomName = bottomName;
    }

    @Override
    public String toString() {
        return "The following bottom contains: "+bottomName+" and costs: "+ bottomPrice;
    }
}
