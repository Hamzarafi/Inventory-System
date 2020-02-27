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
public class Perishable extends Goods {
    
    private String ExpiryDate;
    private Boolean Freezable;

    public Perishable(String name, double price, int id, int quantity, String ExpiryDate, Boolean Freezable) {
        super(name, price, id, quantity);
        this.ExpiryDate = ExpiryDate;
        this.Freezable = Freezable;
    }

    @Override
    public String ItemDescription() {
        return  "\nExpiry Date of the item: " + ExpiryDate + "\nFreezable: " + Freezable ;
    }
    
    @Override
       public void addingKDV(){
        price += price*0.08;
    }

    @Override
    public String toString() {
        return "\nPerishable " + super.toString() + ItemDescription() + "\n";
    }
    
    
}
