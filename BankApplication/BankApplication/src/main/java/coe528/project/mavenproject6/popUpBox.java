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


import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class popUpBox {

    public static void display(String title, String message) {
        Stage window = new Stage();

        // Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(350);
        window.setMinHeight(200); // Set window size to 200x200

        Label label = new Label(message);
        label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12)); // Set font to Tahoma

        Button closeButton = new Button("Return");
        closeButton.setStyle("-fx-background-color: royalblue; -fx-text-fill: white;"); // Set button color to ROYALBLUE and text color to white
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.setStyle("-fx-background-color: lightgrey;"); // Set background color to lightgrey
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10)); // Add padding for better appearance

        // Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout, 350, 200);
        window.setScene(scene);
        window.showAndWait();

    }

}