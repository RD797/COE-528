/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package coe528.project.mavenproject6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



public class Bank extends Application {
   
  //All vars needed to complete the actions of each button
    private Scene customerPage,loginPage, managerPage;
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    private Customer activeCustomer;
    private static Manager admin = new Manager();
    private int index = -1;
    private Button button;
    
    

    public static void main(String[] args) {
               
         String currentDirectory = System.getProperty("user.dir"); 
         //Adding the existing customer text files in system to arrayList of customers
         File dir = new File(currentDirectory);
         for(File file : dir.listFiles()){
             if(file.getName().endsWith((".txt"))){
                    try(Scanner readFile = new Scanner(file)){
                        String user = readFile.next();
                        String pass = readFile.next();
                        int balance = Integer.parseInt(readFile.next());
                        customers.add(new Customer(user,pass));
                        for(Customer x : customers){
                            if(x.getUsername().equals(user))
                                x.depositMoney(balance - 100); 
                                x.setAccountLevel();
                        }
                    }
                    catch(Exception f){}  
             }
         }
         
        launch(args);
        
    }

    
    @Override
    public void start(Stage window) throws Exception {
        
        window.setTitle("RD Bank");
        
        // Define the colour for all buttons
        Color darkBlue = Color.ROYALBLUE;
        
        
        
        //Labels for loginPage
        Label label1 = new Label("Username");
        Label label2 = new Label("Password");
        
        //Labels for Manger page
        Label label3 = new Label("To add new customer, enter their username and password, then proceed to 'Create Customer' ");
        Label label4 = new Label("New Customer's username:");
        Label label5 = new Label("New Customer's password:");
        Label label6 = new Label("\n\n\n");
        Label label7 = new Label("Enter the username of the Customer you wish to delete:");
        Label label8 = new Label("\n\n\n");
        
        
        //Labels for Customer page
        Label dLabel = new Label("\n\nEnter amount you wish to deposit:");
        Label wLabel = new Label("\n\nEnter amount you wish to withdraw:");
        Label opLabel = new Label("\n\nEnter cost of product you wish to purchase online:");
        Label spaces = new Label("\n\n\n");
        
        //TextFields for customer page
        TextField depositMoney = new TextField();
        TextField withdrawMoney = new TextField();
        TextField onlinePurchase = new TextField();
       
        
        
        
        
        //Username and password inputs and button for login page
        TextField username = new TextField();
        username.setPromptText("Enter username");
        PasswordField password = new PasswordField();
        password.setPromptText("Enter password");
        button = new Button("Login");
        button.setStyle("-fx-background-color: royalblue; -fx-text-fill: white;");
        
        // Buttons for customer page and the colour styles
        Button getBalanceButton = new Button("Check Balance");
        getBalanceButton.setStyle("-fx-background-color: #" + darkBlue.toString().substring(2, 8)+ "; -fx-text-fill: white;");
        Button getCurrentLevel = new Button("Check Account Level");
        getCurrentLevel.setStyle("-fx-background-color: #" + darkBlue.toString().substring(2, 8)+ "; -fx-text-fill: white;");  
        Button doDepositAction = new Button("Deposit Money");
        doDepositAction.setStyle("-fx-background-color: #" + darkBlue.toString().substring(2, 8)+ "; -fx-text-fill: white;");
        Button doWithdrawAction = new Button("Withdraw Money");
        doWithdrawAction.setStyle("-fx-background-color: #" + darkBlue.toString().substring(2, 8)+ "; -fx-text-fill: white;");
        Button doOnlinePurchase = new Button("Complete Payment");
        doOnlinePurchase.setStyle("-fx-background-color: #" + darkBlue.toString().substring(2, 8)+ "; -fx-text-fill: white;");
        Button userLogout = new Button("Logout");
        userLogout.setStyle("-fx-background-color: #" + darkBlue.toString().substring(2, 8)+ "; -fx-text-fill: white;");

          
        
        
        // Buttons for the Manager page
        Button createCustomer = new Button("Create Customer");
        createCustomer.setStyle("-fx-background-color: #" + darkBlue.toString().substring(2, 8)+ "; -fx-text-fill: white;");
        Button deleteCustomer = new Button("Delete Customer");
        deleteCustomer.setStyle("-fx-background-color: #" + darkBlue.toString().substring(2, 8)+ "; -fx-text-fill: white;");
        Button managerLogout = new Button("Logout");
        managerLogout.setStyle("-fx-background-color: #" + darkBlue.toString().substring(2, 8)+ "; -fx-text-fill: white;");
        
        
        //Textfields for the manager page
        TextField createUsername = new TextField();
        PasswordField createPassword = new PasswordField();
        TextField userToDelete = new TextField();

         //dealing with fonts cause I am picky
        label1.setFont(Font.font("Tahoma"));
        label2.setFont(Font.font("Tahoma"));
        label3.setFont(Font.font("Tahoma"));
        label4.setFont(Font.font("Tahoma"));    
        label5.setFont(Font.font("Tahoma"));
        label6.setFont(Font.font("Tahoma"));
        label7.setFont(Font.font("Tahoma"));
        label8.setFont(Font.font("Tahoma"));
        dLabel.setFont(Font.font("Tahoma"));
        wLabel.setFont(Font.font("Tahoma"));
        opLabel.setFont(Font.font("Tahoma"));
        spaces.setFont(Font.font("Tahoma"));
       
        
      
        
        //Login Button Action
        button.setOnAction(x ->{ 
            //Searching for if account exists by checking if username and name of file matches
               String inputFile = username.getText();
               String inputPassword = password.getText();
               File f = new File(inputFile + ".txt");
               
               //If the file exists, it will be tried for both admin file and customer file
               if(f.exists()) { 
                   //1. Grab the the first line(username) and the second line(password) from file
                    try(Scanner readFile = new Scanner(f)){
                         String usernameFile = readFile.next();
                         String passwordFile = readFile.next();
                         
                     
                    //2. Check if the username and password matches the ones on the file
                    if(inputFile.equals(usernameFile) && inputPassword.equals(passwordFile)){ 
                        //2a). If username is "admin", go to the managerPage
                        if(usernameFile.equals("admin")){
                            window.setScene(managerPage);
                             window.setTitle("Welcome Manager");
                            username.clear();
                            password.clear();
                        }
                        
                        //if user is not Manager, search for the customer in the arraylist
                        else {  
                           for(int i = 0; i < customers.size(); i++){  
                               //if the username matches the file username, then set that customer object to a Active customer
                                  if(customers.get(i).getUsername().equals(inputFile)){
                                      activeCustomer = customers.get(i);
                                      index = i; //keep track of the number of active customers
                                  }                        
                           } 
                                      //once customer found, move to customer page
                                      window.setScene(customerPage);
                                      window.setTitle("Welcome Customer");
                                      username.clear();
                                      password.clear();
                          

                        } 
                        
                   //This part of the conditional is if the username does not correspond to a manager or a customer
                    }
                    else //if both credentials don't match anything, then there is an error
                        popUpBox.display("Error", "Invalid login credentials");//ik the password is wrong because we wouldnt have enetered the if statement to begin with if the username was wrong
               
                    }  
                    catch(Exception ee){ //this is if some other error comes up 
                         System.out.println("Please Refresh Page");
                        }            
               } 
            //Marks the end of "if the file exists"
               
             //if the file does not exist then...  
               else{
                   popUpBox.display("Error", "This user does not exist");// because the file does not exist
                           
               }
                                           
        });
        //Marks the end of the Login Button Action
        
        
        
   ///Manager Page actions: Creating customer, Deleting Customer
        
        createCustomer.setOnAction(x -> {
                customers.add(new Customer(createUsername.getText(),createPassword.getText()));
                createUsername.clear();
                createPassword.clear();
                popUpBox.display("New Customer", "Customer has been created!");
                });
        
        deleteCustomer.setOnAction(x -> {
           String deleteUsername = userToDelete.getText();
           for(int i = 0; i < customers.size() ; i++){
               if(customers.get(i).getUsername().equals(deleteUsername)){
                   admin.deleteCustomer(customers.get(i));
                   customers.remove(i);
                   userToDelete.clear(); 
                   break;
               }       
           }          
        });
        //End of Manager Actions
        
        
        
    //Customer Page Actions: Check Balance, Check Level, Deposit, Withdraw, Make Purchase
       
    //balance button is clicked
        getBalanceButton.setOnAction(x ->{
            popUpBox.display("Balance", "Balance is $" +activeCustomer.getBalance());
        });
        
        
        //current level button is clicked
        getCurrentLevel.setOnAction(e -> {
            popUpBox.display("Balance", activeCustomer.getAccountLevel());
        });
       
        
        //when deposit button is clicked
        doDepositAction.setOnAction(x ->{
            //textfield is depositMoney
            try{
                int amount = Integer.parseInt(depositMoney.getText());
                activeCustomer.depositMoney(amount);
                depositMoney.clear();
            }
            catch(NumberFormatException e){
                     popUpBox.display("Error", "Value must be an integer");  
                     depositMoney.clear();
            }      
        });
        
        
        //When withdraw button is clicked
        doWithdrawAction.setOnAction(x -> {
            //textfield is withdraw money
            try{
                int amount = Integer.parseInt(withdrawMoney.getText());
                activeCustomer.withdrawMoney(amount);
                withdrawMoney.clear();
            }
            catch(NumberFormatException e){
                     popUpBox.display("Error", "Value must be an integer");  
                     withdrawMoney.clear();
            }      
        });
        
        //When Online purchase button is clicked
        doOnlinePurchase.setOnAction(x -> {
            //textfield is online Purchase
             try{
                int amount = Integer.parseInt(onlinePurchase.getText());
                activeCustomer.onlinePurchase(amount);
                onlinePurchase.clear();
            }
            catch(NumberFormatException e1){
                     popUpBox.display("Error", "Value must be an integer");
                     onlinePurchase.clear();
            }  
        });
       
        
 
    //When Manager logs out
        managerLogout.setOnAction(x -> {
          
            window.setScene(loginPage);
            window.setTitle("RD Bank");
            createUsername.clear();
            createPassword.clear();
            userToDelete.clear();
         
        } );
        
       
       //When Customer logs out 
        userLogout.setOnAction(x -> { //updating user balance and loging out
            try{
                FileWriter writeToFile = new FileWriter(activeCustomer.getUsername() + ".txt");
                writeToFile.write(activeCustomer.getUsername() + "\n");
                writeToFile.write(activeCustomer.getPassword() + "\n");
                writeToFile.write(""+activeCustomer.getBalance());
                writeToFile.close();
            }
            catch(Exception e){}
            
            window.setScene(loginPage);
            window.setTitle("RD Bank");
            depositMoney.clear();
            withdrawMoney.clear();
            onlinePurchase.clear(); //online purchase 
                });
        
 
 
 
     
       
        // Layout of login page
        BorderPane layout1 = new BorderPane();
        layout1.setPadding(new Insets(20, 20, 20, 30));
        Label loginTitle = new Label("Welcome to RD Bank");
        loginTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
        layout1.setTop(loginTitle); // Add title at the top
        BorderPane.setAlignment(loginTitle, Pos.CENTER);

        VBox centerLayout = new VBox(10);
        centerLayout.getChildren().addAll(label1, username, label2, password);
        VBox.setMargin(button, new Insets(10, 0, 0, 0)); // Add margin to push button to bottom
        centerLayout.setAlignment(Pos.CENTER_LEFT);

        HBox bottomLayout = new HBox(10);
        bottomLayout.getChildren().addAll(button);
        bottomLayout.setAlignment(Pos.BOTTOM_RIGHT);
        layout1.setCenter(centerLayout);
        layout1.setBottom(bottomLayout);

        loginPage = new Scene(layout1, 300, 300);


       

        // Layout of Manager page
        GridPane layout2 = new GridPane();
        layout2.setPadding(new Insets(20));
        layout2.setHgap(10);
        layout2.setVgap(10);
        layout2.setAlignment(Pos.CENTER);

        // Add labels and fields to the grid
        layout2.add(label3, 0, 0, 2, 1);
        layout2.add(label4, 0, 1);
        layout2.add(createUsername, 1, 1);
        layout2.add(label5, 0, 2);
        layout2.add(createPassword, 1, 2);
        layout2.add(createCustomer, 1, 3);
        layout2.add(label7, 0, 4);
        layout2.add(userToDelete, 1, 4);
        layout2.add(deleteCustomer, 1, 5);
        layout2.add(managerLogout, 0, 6, 2, 1);
        GridPane.setHalignment(managerLogout, HPos.RIGHT); // Align the logout button to the right

        managerPage = new Scene(layout2, 600, 400);

        // Layout of Customer page
        GridPane layout3 = new GridPane();
        layout3.setPadding(new Insets(20));
        layout3.setHgap(10);
        layout3.setVgap(10);
        layout3.setAlignment(Pos.CENTER);

        // Add buttons and fields to the grid
        layout3.add(getBalanceButton, 0, 0);
        layout3.add(getCurrentLevel, 2, 0);
        layout3.add(dLabel, 0, 1);
        layout3.add(depositMoney, 1, 1);
        layout3.add(doDepositAction, 2, 1);
        layout3.add(wLabel, 0, 2);
        layout3.add(withdrawMoney, 1, 2);
        layout3.add(doWithdrawAction, 2, 2);
        layout3.add(opLabel, 0, 3);
        layout3.add(onlinePurchase, 1, 3);
        layout3.add(doOnlinePurchase, 2, 3);
        layout3.add(spaces, 0, 4, 3, 1);
        layout3.add(userLogout, 0, 5, 3, 1);
        GridPane.setHalignment(userLogout, HPos.RIGHT); // Align the logout button to the right

        customerPage = new Scene(layout3, 700, 500);

        window.setScene(loginPage);
        window.show();
    }
}