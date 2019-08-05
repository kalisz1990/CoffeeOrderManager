package pl.pafc.CoffeeOrderManager;

public class Order {

    int quantity;
    Additives additives;
    final private int coffePrice = 5;

    public Order(int quantity, Additives additives) {
        this.quantity = quantity;
        this.additives = additives;
    }

    public int getCoffePrice() {
        return coffePrice;
    }

    @Override
    public String toString() {
        return "quantity = " + quantity + " coffee" + additives;
    }
}
