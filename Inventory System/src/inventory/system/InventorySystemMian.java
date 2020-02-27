/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.system;

import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Hamza Rafi
 */
public class InventorySystemMian {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GoodsSys.readBinFile();
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        
        
        //To test run
        /*
        String goodsName, category;
        int quantity;
        double price;
        Scanner sc = new Scanner(System.in);
        
        GoodsSys.addGoods();
        System.out.println("All Goods are added!");
        
        System.out.println("\nEnter Goods that is sold: ");
        goodsName = sc.nextLine();
        System.out.println("Enter the quantity: ");
        quantity = sc.nextInt();
        GoodsSys.sold(goodsName, quantity);
       
        Goods gd = GoodsSys.searchGoods(goodsName);
        gd.addingKDV();
        System.out.println("The price is = " + gd.getPrice());
        
        System.out.println("Enter the category you want to display: ");
        category = sc.nextLine();
        GoodsSys.getSelectedgoods(category);
            
        System.out.println("\nEnter Goods that you want to remove: ");
        goodsName = sc.nextLine();
        GoodsSys.removeGoods(goodsName);
        
        System.out.println("Content of ArrayList");
        System.out.println(GoodsSys.getAllGoods());
        */
        
    }
    
}
