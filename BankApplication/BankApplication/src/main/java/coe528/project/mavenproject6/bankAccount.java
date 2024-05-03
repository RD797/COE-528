/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project.mavenproject6;

/**
 *
 * @author riyad
 */



import java.util.*;

//Overview: BankAccount represents the amount of money a user has
//          The balance must be greater than or equal to 
//          zero. BankAccounts are mutable since the value of the balance is changing constantly.

//Abstract function
// AF(c) = a bank account, B, such that  --> since it is mutable, the value of balance is changing
//         B.balance = c.balance

//repOk()
// RI(c) = true if c.balance >= 0 --> user cannot do anything if they do not have any money in the bank except for deposit
//       = false otherwise

public abstract class bankAccount {
   
    protected int balance;
    
    //EFFECTS: sets this.balance to 100
    public bankAccount(){
        balance = 100;
    }
    
    //EFFECTS: returns balance
    protected int getBalance(){
        return balance;
    }
    
    //EFFECTS: Sets this.balance to newBalance if newBalance >= 0
    protected void setBalance(int newBalance){
        if(newBalance >= 0)
            this.balance = newBalance;
    }
    
    //REQUIRES: An alphanumerical amount
    //EFFECTS: adds amount to this.balance if amount >= 0
    protected void addAmount(int amount){
        balance += amount;
    }
    
     //REQUIRES: An alphanumerical amount
    //EEFECTS: removes amount from this.balance if amount >= 0 and amount <= this.balance
    protected void removeAmount(int amount){
            balance -= amount;
    }
    
     //REQUIRES: An alphanumerical amount
    //EFFECTS: If amount >= 50, and if this.balance >= (amount + a varying service charge), then amount + varying service charge is subtracted from this.balance 
    public void onlinePurchase(int amount){} 
    
    
    //EFFECTS: Returns state of current account level
    public  String getAccountLevel(){return "String in abstract";}
    
    
    //EFFECTS: returns abstraction function, returns balance
    @Override
    public String toString(){
        return "Balance is $" + balance;
    }
    
    //EFFECTS: Returns true if rep invarient is true 
    //otherwise returns false
    public boolean repOK(){
        if(this.balance > 0)
            return true;
        return false;
    }
    
}