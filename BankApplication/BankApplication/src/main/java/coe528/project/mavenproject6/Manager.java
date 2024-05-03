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


import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Manager {
    
    private String username = "admin";
    private String password = "admin";
    private String role = "manager";
    
    
   
    public Manager(){
       try{
            File loginInfo = new File(username + ".txt");
            if(loginInfo.createNewFile() == true){
                FileWriter writeToFile = new FileWriter(username + ".txt");
                writeToFile.write(username + "\n");
                writeToFile.write(password);
                writeToFile.close();
            }
        }catch(IOException e){
            System.out.println("Exception occured");
        }
 
    }
    
    public Customer addCustomer(String username, String password){
        return new Customer(username,password);
    }
    
    public void deleteCustomer(Customer customerToDelete){
        //delete the text file
        File file = new File(customerToDelete.getUsername() + ".txt");
        if(file.delete())
             popUpBox.display("Confirmation", "Customer file successfully deleted");


        
        
    }
    
}