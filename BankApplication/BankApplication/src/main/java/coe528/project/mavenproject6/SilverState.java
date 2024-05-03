/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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



public class SilverState extends bankAccount {

    

    
    public void onlinePurchase(int amount){
        if(balance >= (amount + 20)){
            balance -= (amount + 20);
            popUpBox.display("Silver Member Purchase", "You have made a purchase of $" + amount +"\nand with the additional service charge of $20\nthe total cost is $" + (amount +20));    
        }
        else
            popUpBox.display("Error Message", "You have insufficient funds");
    }

   public String getAccountLevel(){
        return "You are a Silver Member";
    }
}