/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleofficefurniture;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author nevil
 */
public class ConsoleOfficeFurniture {

    static FurnitureItem newFurnitureItem = new FurnitureItem();
    
    static ArrayList<Chair> aChair = new ArrayList<>();
    static ArrayList<Table> aTable = new ArrayList<>();
    static ArrayList<Desk> aDesk = new ArrayList<>();
    
    static double totalPrice = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int choice = menu();
    	
    	while (choice != 0) {  
        	
            switch(choice){      	
      	
            	case 1: addChair();
                    choice = menu();
               	break;
                
                case 2: addTable();
                    choice = menu();
               	break;
                
                case 3: addDesk();
                    choice = menu();
               	break;
                
                case 4: clear();
                    choice = menu();
               	break;
                
                case 5: listTotalPrice();
                    choice = menu();
               	break;
                
                case 6: saveToFile();
                    choice = menu();
               	break;
                
                case 8: displaySummary();
                    choice = menu();
               	break;
            }
        }
        
        Chair myChair = new Chair();
    }// end main
	
    
    static int menu(){ //displays the main menu and returns user choice to the switch in main method
    	int choice;
    	
    	Scanner keyboard = new Scanner(System.in);
    	
    	do{
        	System.out.println("Please Enter Your Choice \n" +
                    	"1. Add Chair \n" +
                    	"2. Add Table \n" +
                    	"3. Add Desk \n" +
                        "4. Clear \n" +
                        "5. Total Price \n" +
                        "6. Save \n" +
                        "7. Load \n" +
                        "8. Summary \n" +
                    	"0. Exit");
        	
        	choice = keyboard.nextInt();
    	}
    	while (choice < 0 || choice > 9);
    	
    	return choice;
    }// end menu
	
    
    // reset application
    static void clear()
    {
        aChair.clear();
        aTable.clear();
        aDesk.clear();
        
        totalPrice = 0;
        
        System.out.println("\n All counter and Variables cleared! ");
    }
    
    
    // total price function
    static void listTotalPrice()
    {
        totalPrice = 0;
        
        // list though all chair classes
        aChair.forEach((singleChair) -> {
            totalPrice = totalPrice + (singleChair.getTotalPrice());
        });
        
        
        // list though all Desk classes
        aDesk.forEach((singleDesk) -> {
            totalPrice = totalPrice + (singleDesk.getTotalPrice());
        });
        
        // list though all Table classes
        aTable.forEach((singleTable) -> {
            totalPrice = totalPrice + (singleTable.getTotalPrice());
        });
        
        
        
        System.out.println("\n The total price is £"+totalPrice);
    }
    
    // save to file function - NOT WORKING need to look at later!!
    static void saveToFile()
    {
        JSONObject obj = new JSONObject();
        obj.put("Name", "crunchify.com");
        obj.put("Author", "App Shah");

        JSONArray jsonArrayChair = new JSONArray();
        JSONArray jsonArrayDesk = new JSONArray();
        JSONArray jsonArrayTable = new JSONArray();
        
        jsonArrayChair.add(aChair);
        jsonArrayDesk.add(aDesk);
        jsonArrayTable.add(aTable);
        
        obj.put("Chairs", jsonArrayChair );
        obj.put("Desks", jsonArrayDesk );
        obj.put("Tables", jsonArrayTable );

        // try-with-resources statement based on post comment below :)
        try {
            FileWriter file = new FileWriter("file1.dat");
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
            file.flush();
            file.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    // display summary of order in asending order of price
    static void displaySummary()
    {
        
        
    }
    
    static void addChair(){
    	
        Chair newChair = new Chair();
        
    	int idNum;
    	char typeOfWood;
    	int quantity;
        boolean armrest;
        char charTemp;
    	
    	ImageIcon i = new ImageIcon("Chair1.jpg");
    	
    	Scanner keyboard = new Scanner(System.in);
    	
    	System.out.println("Please Enter a chair id : ");
        	idNum = keyboard.nextInt();
        	
    	System.out.println("Please Enter quantity : ");
        	quantity = keyboard.nextInt();
        	
    	System.out.println("Please Enter type of wood (o or w) : ");
        	typeOfWood = keyboard.next().charAt(0);
         	
        System.out.println("Please Enter arm rest (y or n) : ");
        	charTemp = keyboard.next().charAt(0);
        
        if(charTemp == 'y')
        {
            armrest = true;
        }
        else 
        {
            armrest = false;
        }

        
    	// create chair class and assign values
    	newChair = new Chair(idNum, typeOfWood, quantity, armrest);
    	
        // add price multiply via quantity to the total price
        totalPrice = totalPrice + (newChair.getItemPrice() * newChair.getQuantity());
        
        // add Chair to collection
        aChair.add(newChair);
        
    	System.out.println("\nSUMMARY : " + newChair.toString());
    	//System.out.printf("Units : £%.2f\n\n",newChair.calcUnits());
    	//System.out.printf("Item Price : £%.2f\n\n",newChair.itemPrice());  	
        
    }// end add chair
    
    
    
    static void addTable(){
    	
        Table newTable = new Table();
        
    	int idNum;
    	char typeOfWood;
    	int quantity;
        int diameter = 0;
        char temp;
        String baseType;
    	
    	ImageIcon i = new ImageIcon("Chair1.jpg");
    	
    	Scanner keyboard = new Scanner(System.in);
    	
    	System.out.println("Please Enter a Table id : ");
        	idNum = keyboard.nextInt();
        	
    	System.out.println("Please Enter quantity : ");
        	quantity = keyboard.nextInt();
        	
    	System.out.println("Please Enter type of wood (o or w) : ");
        	typeOfWood = keyboard.next().charAt(0);
        
        while(diameter < 50)
        {
                
            System.out.println("Please Enter a Table diameter : ");
                    diameter = keyboard.nextInt();
                    
            if(diameter < 50)
                System.out.println("Diameter has to be bigger then 50!");
        }
        
        System.out.println("Please Enter base type (w or c) : ");
        	temp = keyboard.next().charAt(0);
                
        if(temp == 'w')
            baseType = "wooden";
        else
            baseType = "chrome";
        
        
        //newFurnitureItem = new FurnitureItem(idNum, typeOfWood, quantity);
        
    	//newFurnitureItem = new FurnitureItem(idNum, typeOfWood, quantity);
    	
    	newTable = new Table(idNum, typeOfWood, quantity, diameter, baseType);
    	
        // add table to the table collection
        aTable.add(newTable);
        
    	System.out.println("\nSUMMARY : " + newTable.toString());
    	//System.out.printf("Units : £%.2f\n\n",newChair.calcUnits());
    	//System.out.printf("Item Price : £%.2f\n\n",newChair.itemPrice());  	
        
    }// end add table
    
    
    
    static void addDesk(){
    	
        Desk newDesk = new Desk();
        
    	int idNum;
    	char typeOfWood;
    	int quantity;
        int width;
        int depth;
        int numOfDraws;
    	
    	ImageIcon i = new ImageIcon("Chair1.jpg");
    	
    	Scanner keyboard = new Scanner(System.in);
    	
    	System.out.println("Please Enter a Desk id : ");
        	idNum = keyboard.nextInt();
        	
    	System.out.println("Please Enter quantity : ");
        	quantity = keyboard.nextInt();
        	
    	System.out.println("Please Enter type of wood (o or w) : ");
        	typeOfWood = keyboard.next().charAt(0);
         	
        System.out.println("Please Enter a Desk width : ");
        	width = keyboard.nextInt();
        
        System.out.println("Please Enter a Desk depth : ");
        	depth = keyboard.nextInt();
        
        System.out.println("Please Enter a Desk number of draws : ");
        	numOfDraws = keyboard.nextInt();
        
        //newFurnitureItem = new FurnitureItem(idNum, typeOfWood, quantity);
        
    	//newFurnitureItem = new FurnitureItem(idNum, typeOfWood, quantity);
    	
    	newDesk = new Desk(idNum, typeOfWood, quantity, width, depth, numOfDraws);
    	
        // add new desk to desk collection
        aDesk.add(newDesk);
        
    	System.out.println("\nSUMMARY : " + newDesk.toString());
    	//System.out.printf("Units : £%.2f\n\n",newChair.calcUnits());
    	//System.out.printf("Item Price : £%.2f\n\n",newChair.itemPrice());  	
        
    }// end add desk
    
}// end class
