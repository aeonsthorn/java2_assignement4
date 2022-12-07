package com.mcgill;

import java.util.Scanner;

public class SelfServicer {

  private boolean isRunning = false;

  private Cart cart;

  private MarketSpace marketSpace;

  private final String initialGreeting = "Hi, what would you like to do?";

  private final Scanner scanner = new Scanner(System.in);

  private final String[] choices = {
    "Buy a computer",
    "See my shopping cart",
    "Sort by order ID (Descending order)",
    "Sort by order price (Descending order)",
    "Quit",
  };

  public SelfServicer(MarketSpace marketSpace) {
    this.marketSpace = marketSpace;
  }

  public void takeOrder() {
    isRunning = true;
    cart = new Cart();

    Scanner scanner = new Scanner(System.in);

    while (isRunning) {
      System.out.println(initialGreeting);

      for (int i = 0; i < choices.length; i++) {
        System.out.println((i + 1) + ": " + choices[i]);
      }

      while (!scanner.hasNextInt()) {
        scanner.next();
      }
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          buyComputer();
          break;
        case 2:
          seeMyShoppingCart();
          break;
        case 3:
          sortByOrderID();
          break;
        case 4:
          sortByOrderPrice();
          break;
        case 5:
          quit();
          break;
        default:
          continue;
      }

      System.out.println("\n");
    }
    scanner.close();
  }

  private void buyComputer() {
    int uniqueID = (int) Math.floor(Math.random() * 100);

    Computer computer = new DefaultComputer(Integer.toString(uniqueID));

    boolean isAddingParts = true;

    while (isAddingParts) {
      System.out.print("Current build: ");
      System.out.print(computer.getDescription());
      System.out.println(
        ", and total price is " + String.format("%.2f", computer.getPrice())
      );
      System.out.println("What component would you like to add?");

      marketSpace
        .getProducts()
        .forEach((key, product) -> {
          System.out.print(key);
          System.out.print(": ");
          System.out.print(product.description);
          System.out.print(" $");
          System.out.println(product.price);
        });

      System.out.println((marketSpace.getNumberOfProducts() + 1) + ": Done");

      while (!scanner.hasNextInt()) {
        scanner.next();
      }
      int choice = scanner.nextInt();

      if (choice == marketSpace.getNumberOfProducts() + 1) {
        isAddingParts = false;
      }

      if (!isAddingParts) break;

      computer =
        new Component(
          computer,
          marketSpace.getProducts().get(choice).description,
          marketSpace.getProducts().get(choice).price
        );
    }

    cart.addItem(computer);
  }

  private void seeMyShoppingCart() {
    if (isCartEmpty()) return;

    cart.printOrder();
  }

  private void sortByOrderID() {
    if (isCartEmpty()) return;

    SortById sortById = new SortById();
    sortById.sort(cart.items);
  }

  private void sortByOrderPrice() {
    if (isCartEmpty()) return;

    SortByPrice sortByPrice = new SortByPrice();
    sortByPrice.sort(cart.items);
  }

  private void quit() {
    System.out.println("Thank you for your order, have a nice day!");
    isRunning = false;
  }

  private boolean isCartEmpty() {
    boolean isEmpty = cart.isEmpty();

    if (isEmpty) System.out.print("No items");

    return isEmpty;
  }
}
