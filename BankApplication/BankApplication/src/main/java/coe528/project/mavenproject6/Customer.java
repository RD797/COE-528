/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project.mavenproject6;

/**
 *
 * @author riyad
 */



import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*;

public class Customer {
    
    private String username;
    private String password;
    private String role = "customer";
    private bankAccount account;
    //public int balance;
   
    public Customer(String username, String password){
        try{// Check if a file with the username already exists

            File loginInfo = new File(username + ".txt");
            // If the file doesn't exist, create a new one
            if(loginInfo.createNewFile() == true){
                System.out.println("User created:" + loginInfo.getName());
                this.username = username;
                this.password = password;
                //New customer is always in silver state
                account = new SilverState();
                FileWriter writeToFile = new FileWriter(username + ".txt");
                writeToFile.write(username + "\n");
                writeToFile.write(password + "\n");
                writeToFile.write(""+100);
                writeToFile.close();
            }
            // If the file already exists, load existing user information
            else if(loginInfo.exists()){
                this.username = username;
                this.password = password;
                account = new SilverState();
            }
            else{
                System.out.println("User already exists");
                return;
            }
        }catch(IOException e){
            System.out.println("IOException occured");
        }
    }
    
    public int getBalance(){
        return account.getBalance();
    }
    public void depositMoney(int amount){
        account.addAmount(amount);
        popUpBox.display("Deposit", "$" + amount + " has been deposited");
        this.setAccountLevel();
    }

    public void withdrawMoney(int amount){
        if(account.getBalance() >= amount){
            account.removeAmount(amount);
             popUpBox.display("Deposit", "$" + amount + " has been withdrawed"); 
            this.setAccountLevel();
        }
        else
             popUpBox.display("Deposit", "You do not have enough funds to withdraw $" +amount); 
           
    }
    public void onlinePurchase(int amount){
        if(amount < 50){
            popUpBox.display("Deposit", "Online purchase must be at least $50"); 
            return; }
        account.onlinePurchase(amount);
        this.setAccountLevel();
    }
    
    public void setAccountLevel(){ 
        int balance = account.getBalance();
        
        if(balance < 10000){
            account = new SilverState();
            account.setBalance(balance);
        }
        if(balance >= 10000 && balance < 20000){
            account = new GoldState();
            account.setBalance(balance);
        }       
        if(balance > 20000){
            account = new PlatinumState();
            account.setBalance(balance);
        }
            
    }
    
    public String getAccountLevel(){
        return account.getAccountLevel();
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}