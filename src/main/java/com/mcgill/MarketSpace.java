package com.mcgill;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MarketSpace {

    private List<Computer> cart;

    private Map<Integer, Product> products = new HashMap<Integer, Product>();

    private static MarketSpace instance;

    public static MarketSpace getInstance() {

        if (instance == null) {
            instance = new MarketSpace();
        }

        return instance;

    }

    public Map<Integer, Product> getProducts() {

        System.out.println("Getting products");

        return products;
    }

    public int getNumberOfProducts() {
        return products.size();
    }

    public void loadProducts() {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("products.txt"));

            String line = reader.readLine();

            while (line != null) {

                String[] descriptionAndPrice = line.split(",");

                products.put(products.size() + 1,
                        new Product(
                                Double.parseDouble(
                                        descriptionAndPrice[1]),
                                descriptionAndPrice[0]));

                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class Product {
    public double price;
    public String description;

    public Product(double price, String description) {
        this.description = description;
        this.price = price;
    }
}
