package EncapculationExercise.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money){
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        Validator.validateString(name);
        this.name = name;
    }

    private void setMoney(double money) {
        Validator.validateValueNonNegative(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        this.products.add(product);
    }
}
