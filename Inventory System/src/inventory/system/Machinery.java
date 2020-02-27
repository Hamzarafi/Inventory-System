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
public class Machinery extends Goods{
    
    private String warranty;
    private String manufacturer; 

    public Machinery( String name, double price, int id, int quantity, String Warranty, String Manufacturer) {
        super(name, price, id, quantity);
        this.warranty = Warranty;
        this.manufacturer = Manufacturer;
    }
    
    public void exdendWarrenty(){
        warranty += "+1 year extended warrenty";
    }
    
    @Override
    public String ItemDescription() {
        return  "\nWarranty: " + warranty + "\nManufacturer: " + manufacturer ;
    }
    
    @Override
    public void addingKDV(){
        price += price*0.16;
    }

    @Override
    public String toString() {
        return "\nMachinery " + super.toString() + ItemDescription()+ "\n";
    }
    
    
}
