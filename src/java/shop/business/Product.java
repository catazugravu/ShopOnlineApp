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
public class Product {

    private int productID;
    private String productCode;
    private String productDescription;
    private double productPrice;

    public Product() {
    }

    public Product(int productID, String productCode, String productDescription, double productPrice) {
        this.productID = productID;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }


}
