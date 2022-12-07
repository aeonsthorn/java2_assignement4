package com.mcgill;

public class Order {}

interface Computer {
  public String getDescription();

  public double getPrice();

  public String getOrderID();
}

class DefaultComputer implements Computer {

  private String description = "Default Computer";
  private double price = 700.00;
  private String orderID;

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public String getOrderID() {
    return orderID;
  }

  public DefaultComputer(String orderID) {
    this.orderID = orderID;
  }
}

class ComputerDecorator implements Computer {

  Computer currentComputer;

  public ComputerDecorator(Computer computer) {
    currentComputer = computer;
  }

  public double getPrice() {
    return currentComputer.getPrice();
  }

  public String getDescription() {
    return currentComputer.getDescription();
  }

  public String getOrderID() {
    return currentComputer.getOrderID();
  }
}

class Component extends ComputerDecorator {

  private String componentDescription;
  private double componentPrice;

  public Component(Computer computer, String description, double price) {
    super(computer);
    this.componentDescription = description;
    this.componentPrice = price;
  }

  public String getDescription() {
    return super.getDescription() + " + " + componentDescription;
  }

  public double getPrice() {
    return super.getPrice() + componentPrice;
  }
}
