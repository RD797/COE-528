
package coe528.project.mavenproject6;

/**
 *
 * @author riyad
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class PlatinumState extends bankAccount {

    
     public void onlinePurchase(int amount){
         if(balance >= amount){
            balance -= amount;
                popUpBox.display("Platinum Member Purchase", "You have made a purchase of $" + amount +"\nand with no additional service charge\nthe total cost is $" + (amount));
         }
         else
             popUpBox.display("Error Message", "You have insufficient funds");
    }
     public String getAccountLevel(){
         return "You are a Platinum Member";
     }
    
}