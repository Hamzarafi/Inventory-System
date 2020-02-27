/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory.system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author hamza
 */
public class GoodsSys {

    public static ArrayList<Goods> GoodsList = new ArrayList();
    
    public static void addGoods(Goods gd){
        
        GoodsList.add(gd);
        
    }
    //to test run without the GUI
    /*
    public static void addGoods() {
        //will use an add/delete buttons in GUI so will not need this but only for testing now
        Scanner input = new Scanner(System.in);
        System.out.println("Enter how many Goods do you want to enter:");
        int num = input.nextInt();

        for (int i = 1; i <= num; i++) {
            //Entering the type, in GUI we will use a comboBox selection
            //so not checking the entered input
            System.out.println("Enter category of Good:");
            System.out.println("(Perishable, Nonperishable or Machinery):");
            String category = input.next();

            System.out.println("\nEnter name: ");
            String name = input.next();
            Goods found = searchGoods(name);
            if (found == null) {
                System.out.println("Enter Price: ");
                double price = input.nextDouble();
                System.out.println("Enter ID: ");
                int ID = input.nextInt();
                System.out.println("Enter quantity: ");
                int quantity = input.nextInt();
                System.out.println("Enter Date of Entry: ");
                String date = input.next();
                if (category.equalsIgnoreCase("Perishable")) {
                    System.out.println("Enter Date of Expiry");
                    String Expiry = input.next();
                    System.out.println("if Frozen write YES else anything");//check box in GUI
                    String entered = input.next();
                    boolean frozen = false;
                    if (entered.equalsIgnoreCase("Yes")) {
                        frozen = true;
                    }
                    Perishable obj = new Perishable(name, price, ID, quantity, date, Expiry, frozen);
                    GoodsList.add(obj);
                } else if (category.equalsIgnoreCase("Nonperishable")) {
                    System.out.println("Enter type: ");
                    String type = input.next();
                    System.out.println("Enter Shelf life: ");//check box in GUI
                    int shelfLife = input.nextInt();
                    NonPerishable obj = new NonPerishable(name, price, ID, quantity, date, type, shelfLife);
                    GoodsList.add(obj);
                } else if (category.equalsIgnoreCase("Machinery")) {
                    System.out.println("Enter Warranty: ");
                    String warrenty = input.next();
                    System.out.println("Enter Manufacture: ");//check box in GUI
                    String maufacturer = input.next();
                    Machinery obj = new Machinery(name, price, ID, quantity, date, warrenty, maufacturer);
                    GoodsList.add(obj);
                }
            }
            else 
            {
                System.out.println("Found in the system");
                System.out.println("Enter the quantity you want to add");
                int enter = input.nextInt();
                
            }
        }
    }*/

    public static Goods updateGoods(int q, String name) {
        Goods found = searchGoods(name);
        found.setQuantity(found.getQuantity() + q);
        removeGoods(name);
        GoodsList.add(found);
        return null;
    }
    
    public static Goods searchGoods(String name) {
        for (int i = 0; i < GoodsList.size(); i++) {
            if (GoodsList.get(i).getName().equalsIgnoreCase(name)) {
                return GoodsList.get(i);
            }

        }
        return null;
    }

    public static boolean removeGoods(String name) {
        for (int i = 0; i < GoodsList.size(); i++) {
            if (GoodsList.get(i).getName().equalsIgnoreCase(name)) {
                GoodsList.remove(i);
                return true;
            }

        }
        return false;
    }

    public static void sold(String name, int quantityToReduce){
        Goods toReduce = searchGoods(name);
        if (toReduce != null)
        {
            toReduce.setQuantity(toReduce.getQuantity() - quantityToReduce);
        }        
    }
    
    public static String getAllGoods(){
        String res = "";
        Iterator<Goods> it = GoodsList.iterator();
        while (it.hasNext()) {
            Goods v = it.next();
            res += v.toString();
        }
        return res;
    }

    public static String getSelectedgoods(String cat) {
        String res = "";
        cat = cat.toLowerCase();
        switch (cat) {
            case "perishable":
                for (Goods a : GoodsList) {
                    if (a instanceof Perishable) {
                        res += a.toString();
                    }
                }
                break;
            case "nonperishable":
                for (Goods a : GoodsList) {
                    if (a instanceof NonPerishable) {
                        res += a.toString();
                    }
                }
                break;
            case "machinery":
                for (Goods a : GoodsList) {
                    if (a instanceof Machinery) {
                        res += a.toString();
                    }
                }
                break;
        }
        return res;
    }
    
    public static void writetoBin() {
        ObjectOutputStream obj;
        try {
            obj = new ObjectOutputStream(new FileOutputStream("binary_bin"));
            obj.writeObject(GoodsList);
            obj.close();
        } catch (FileNotFoundException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        } catch (IOException ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
    }
    
    public static void readBinFile(){
        ObjectInputStream obji;
        try {
            obji = new ObjectInputStream(new FileInputStream("binary_bin"));
            GoodsList = (ArrayList<Goods>) (obji.readObject());
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (ClassNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
    }
}
