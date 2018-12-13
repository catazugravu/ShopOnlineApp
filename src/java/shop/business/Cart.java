package shop.business;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Item> items;

    public Cart(ArrayList<Item> items) {
        this.items = items;
    }

    public Cart() {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItems(Item item) {
        items.add(item);
    }
}
