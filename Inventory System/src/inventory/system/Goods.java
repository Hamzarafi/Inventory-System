/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.system;

import java.io.Serializable;

/**
 *
 * @author Hamza Rafi
 */
public abstract class Goods implements GoodsInterface, Comparable<Goods>, Serializable{
    
    protected String name;
    protected double price;
    protected int id;
    protected int quantity;
    protected static int totalNoOfItems = 0;


    public Goods(String name, double price, int id, int quantity) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.quantity = quantity;
        totalNoOfItems++ ; 
    }
    
    public abstract String ItemDescription();

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    
    
    
    @Override
    public String toString() {
        return "\nName: " + name + "\nPrice: " + price + "\nId: " + id + "\nQuantity: " 
                + quantity;
    }

    @Override
    public int compareTo(Goods o) {
        return name.compareTo(o.name);
    }

    
    
}
