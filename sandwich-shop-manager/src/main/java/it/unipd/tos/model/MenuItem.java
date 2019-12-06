//Marco Rosin 1120673
package it.unipd.tos.model;

public class MenuItem {
    public enum itemType {
        Panino, Fritto, Bevanda
    };

    private itemType type;
    private String name;
    private double price;

    public itemType getType() {
        return type;
    }

    public void setType(itemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MenuItem(itemType i, String s, double d) {
        setType(i);
        setName(s);
        setPrice(d);
    }
}
