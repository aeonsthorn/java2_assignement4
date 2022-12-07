package com.mcgill;

import java.util.ArrayList;

public class Cart {

  public ArrayList<Computer> items = new ArrayList<Computer>();

  public boolean isEmpty() {
    return items.size() == 0;
  }

  public void addItem(Computer item) {
    items.add(item);
  }

  public void printOrder() {
    System.out.print("[");

    for (int i = 0; i < items.size(); i++) {
      Computer item = items.get(i);

      System.out.print(
        "OrderID@" +
        item.getOrderID() +
        ": " +
        item.getDescription() +
        " $" +
        String.format("%.2f", item.getPrice())
      );
    }

    System.out.print("]");
  }
}
