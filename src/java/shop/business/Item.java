/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.business;

/**
 *
 * @author TRINH_PC
 */
public class Item {
    private int quantity;
    private Product product;

    public Item(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public Item() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
}
