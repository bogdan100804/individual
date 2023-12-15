package com.example.bohdanindproject;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Button next;

    @FXML
    void nextWindow(ActionEvent event) {
        next.getScene().getWindow().hide();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("orderTicket.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Продаж квитків");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}