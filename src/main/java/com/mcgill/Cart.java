package com.mcgill;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Computer> items = new ArrayList<Computer>();

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public void addDefaultComputer() {

        items.add(new DefaultComputer());

    }

    public void printOrder() {
        System.out.print("[");

        for (int i = 0; i < items.size(); i++) {

            Computer item = items.get(i);

            System.out.println(
                    "OrderID@" + item.getOrderID()
                            + ": "
                            + item.getDescription()
                            + " $"
                            + item.getPrice());
        }

        System.out.print("]");
    }

}
