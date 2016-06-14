package model;

public enum Product {
    COLA(100, 5), CHIPS(50, 5), CANDY(65, 5);

    private final int price;
    private int quantity;

    Product(int price, int quantity){
        this.price = price;
        this.quantity = quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void buyProduct(){
        this.quantity--;
    }

    public String getDisplayPrice(){
        double displayAmount = (double) price / 100.0;
        return "$" + displayAmount;
    }
}
