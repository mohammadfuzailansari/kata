package org.example.sec06.assignment;

public class Order {

    private String item;
    private String catregory;
    private float price;
    private int quantity;

    @Override
    public String toString() {
        return "Order{" +
                "item='" + item + '\'' +
                ", catregory='" + catregory + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCatregory() {
        return catregory;
    }

    public void setCatregory(String catregory) {
        this.catregory = catregory;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

