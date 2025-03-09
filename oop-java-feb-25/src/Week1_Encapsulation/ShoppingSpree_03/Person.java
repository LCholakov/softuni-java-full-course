package Week1_Encapsulation.ShoppingSpree_03;
//package ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw  new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw  new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public void buyProduct(Product product){
        if (this.money >= product.getCost()){
            this.products.add(product);
            this.money -= product.getCost();
            System.out.printf("%s bought %s%n", this.name, product.getName());
        } else {
//            System.out.printf("%s can't afford %s%n", this.name, product.getName());
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) {
            return this.name + " - nothing bought";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(" - ");
        this.products.forEach(p -> sb.append(p.getName() + ", "));

        return sb.substring(0, sb.length() - 2);
    }
}
