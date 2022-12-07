package com.mcgill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrderSorter {}

interface SortStrategy {
  public void sort(ArrayList<Computer> list);
}

class SortById implements SortStrategy, Comparator<Computer> {

  @Override
  public void sort(ArrayList<Computer> list) {
    Collections.sort(list, this);
  }

  @Override
  public int compare(Computer o1, Computer o2) {
    return o2.getOrderID().compareTo(o1.getOrderID());
  }
}

class SortByPrice implements SortStrategy, Comparator<Computer> {

  @Override
  public void sort(ArrayList<Computer> list) {
    Collections.sort(list, this);
  }

  @Override
  public int compare(Computer o1, Computer o2) {
    return (int) (o2.getPrice() - o1.getPrice());
  }
}
