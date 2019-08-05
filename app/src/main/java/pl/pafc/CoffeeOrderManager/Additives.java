package pl.pafc.CoffeeOrderManager;

class Additives {

    private boolean whippedCream;
    private boolean chocolate;
    private boolean candy;
    final private int whippedCreamPrice = 2;
    final private int chocolatePrice = 1;
    final private int candyPrice = 1;

    public Additives(boolean whippedCream, boolean chocolate, boolean candy) {
        this.whippedCream = whippedCream;
        this.chocolate = chocolate;
        this.candy = candy;
    }

    public int getWhippedCreamPrice() {
        return whippedCreamPrice;
    }

    public int getChocolatePrice() {
        return chocolatePrice;
    }

    public int getCandyPrice() {
        return candyPrice;
    }

    public boolean isWhippedCream() {
        return whippedCream;
    }

    public boolean isChocolate() {
        return chocolate;
    }

    public boolean isCandy() {
        return candy;
    }

    @Override
    public String toString() {
        if (!candy && (chocolate && whippedCream)) {
            return " with whippedCream and chocolate";
        }
        if (!chocolate && (whippedCream && candy)) {
            return " with whippedCream and candy";
        }
        if (!whippedCream && ( chocolate && candy)) {
            return " with chocolate and candy";
        }
        if (candy && (!chocolate && !whippedCream)) {
            return " with candy";
        }
        if (chocolate && (!candy && !whippedCream)) {
            return " with chocolate";
        }
        if (whippedCream && (!candy && !chocolate)) {
            return " with whipperCream";
        }
        if (candy && (chocolate && whippedCream)) {
            return " with whipperCream and chocolate and candy";
        }
        return "";
    }
}
