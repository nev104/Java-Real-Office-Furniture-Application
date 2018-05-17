/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consoleofficefurniture;

import javax.swing.*;

/**
 *
 * @author nevil
 */
public class Desk extends FurnitureItem {

    private int width;
    private int depth;
    private int numOfDraws;
    
    Desk()
    {
    	super();
        width = 0;
        depth = 0;
        numOfDraws = 0;
        itemPrice();
    }
    
    Desk(int id, char tw, int qty, int w, int d, int draws)
    {
    	super(id, tw, qty);
        width = w;
        depth = d;
        numOfDraws = draws;
        itemPrice();
    }

    public int getWidth()
    {
        return width;
    }
    
    public int getDepth()
    {
        return depth;
    }
    
    public int getNumOfDraws()
    {
        return numOfDraws;
    }
    
    
    private double itemPrice(){
    	
    	if (super.getTypeOfWood() == 'w'){
            itemPrice = (calcUnits() * 0.03);
    	} else if (super.getTypeOfWood()== 'o'){
            itemPrice = (calcUnits() * 0.04);
    	}else{
            itemPrice = 0.00;
        }
        
        itemPrice = itemPrice + (numOfDraws * 8.50);
        
    	return itemPrice;
    }
    
    
    
    @Override
    public int calcUnits()
    {
        int units;
        
        // working out cost
        //(((height + width + depth) * 12) + (depth * width) * price per unit) + (number of draws * £8.50)
        //Note: The height of all desks is 80cm.
        
        units = ((80 + width + depth) * 12)+ (depth * width);
        
        return units;
    }
    
    //@Override annotation is used when we override a method in sub class.
    //Generally novice developers overlook this feature as it is not mandatory to use
    //this annotation while overriding the method.
    @Override
    public String toString(){
        return super.toString() + "  Depth "+ depth +"   Width "+ width +"   Num Of Draws "+ numOfDraws;
    }

}
