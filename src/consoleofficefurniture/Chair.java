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
public class Chair extends FurnitureItem {

    private Boolean armRests;
    
    Chair()
    {
    	super();
        armRests = false;
        itemPrice();
    }
    
    Chair(int id, char tw, int qty, Boolean arm)
    {
    	super(id, tw, qty);
        armRests = arm;
        itemPrice();
    }

    public Boolean getArmRests()
    {
        return armRests;
    }
    
    
    private double itemPrice(){
    	
    	if (super.getTypeOfWood() == 'w'){
            itemPrice = (calcUnits() * 0.03);
    	} else if (super.getTypeOfWood()== 'o'){
            itemPrice = (calcUnits() * 0.04);
    	}else{
            itemPrice = 0.00;
        }
        
    	return itemPrice;
    }

    @Override
    public int calcUnits()
    {
        int units = 1625;
        
        if(armRests == true)
            units = units + 250;
        
        return units;
    }
    
    //@Override annotation is used when we override a method in sub class.
    //Generally novice developers overlook this feature as it is not mandatory to use
    //this annotation while overriding the method.
    @Override
    public String toString(){
        if(armRests == true)
            return super.toString() + "  With Armrest";
        else
            return super.toString() + "  Without Armrest";
    }

}
