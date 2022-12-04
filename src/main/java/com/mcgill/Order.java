package com.mcgill;

public class Order {

}

interface Computer {
    public String getDescription();

    public double getPrice();

    public String getOrderID();
}

class DefaultComputer implements Computer {
    @Override
    public String getDescription() {
        return "Default Computer";
    }

    @Override
    public double getPrice() {
        return 700.00;
    }

    @Override
    public String getOrderID() {
        return "1";
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

    public Component(Computer computer) {
        super(computer);
    }

    public String getDescription() {
        return super.getDescription() + "Component";
    }

    public double getPrice() {
        return super.getPrice() + 9000.00;
    }

}

class Mouse extends Component {

    public Mouse(Computer computer) {
        super(computer);
    }

    private String description = "Mouse";
    private double price = 39.99;
    private String orderID = "1";

}