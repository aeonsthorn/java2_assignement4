package com.mcgill;

public class Main {

    private static MarketSpace marketSpace;
    private static SelfServicer selfServicer;

    public static void main(String[] args) {

        marketSpace = MarketSpace.getInstance();

        marketSpace.loadProducts();

        selfServicer = new SelfServicer(marketSpace);

        selfServicer.takeOrder();

    }
}
