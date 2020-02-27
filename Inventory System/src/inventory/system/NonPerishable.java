/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.system;

/**
 *
 * @author Hamza Rafi
 */
public class NonPerishable extends Goods{
    
    private String type;
    private int shelflife;

    public NonPerishable(String name, double price, int id, int quantity, String type, int shelflife) {
        super(name, price, id, quantity);
        this.type = type;
        this.shelflife = shelflife;
    }

   
    @Override
    public String ItemDescription() {
        return  "\nType: " + type + "\nShelfLife: " + shelflife  ;
    }
    
    public void applyDiscount(){
        if (shelflife < 10)
            super.setPrice(price*.9);
    }
        
    
    @Override
     public void addingKDV(){
        price += price*0.12;
    }

    @Override
    public String toString() {
        return "\nNonPerishable " + super.toString() + ItemDescription() + "\n";
    }
     
    
}
