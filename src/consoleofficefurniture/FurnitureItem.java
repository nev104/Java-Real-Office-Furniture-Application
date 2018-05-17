/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleofficefurniture;

import javax.swing.ImageIcon;


/**
 *
 * @author nevil
 */
public class FurnitureItem {
    
    private int idNum;
    private int quantity;
    private char typeOfWood;
    protected double itemPrice;
    protected ImageIcon image = new ImageIcon("");
	
    FurnitureItem()
    {
    	super();   	
    	idNum = 0;
    	quantity = 0;
    	typeOfWood = 'o';
    }
	
    FurnitureItem(int id, char tw, int qty)
    {
    	super();
    	idNum = id;
    	quantity = qty;
    	typeOfWood = tw;
    }
    	
    public double getItemPrice()
    {
 	
        return itemPrice;
    	
    }
    
    public double getTotalPrice()
    {
        return itemPrice * quantity;
    }
    
    public char getTypeOfWood()
    {
        return typeOfWood;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public void setQuantity(int q)
    {
        this.quantity = q;
    }
    
    public ImageIcon getImage()
    {
        return image;
    }
    
    public void toFString()
    {
        
    }
    
    public int calcUnits()
    {
        return 0;
    }
    
	
	//@Override annotation is used when we override a method in sub class.
	//Generally novice developers overlook this feature as it is not mandatory to use
	//this annotation while overriding the method.
    @Override
    public String toString(){
    	
        return super.toString() + "  Id Number: " + idNum + "  Quantity: " + quantity + "  Type of Wood: " + typeOfWood + "  Item Price:  £" + getItemPrice();
    }

    
}
