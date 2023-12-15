package com.example.bohdanindproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderTicketController {
    @FXML
    private Button next;

    @FXML
    private Button previus;

    @FXML
    void nextWindow(ActionEvent event) {
        next.getScene().getWindow().hide();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SessionsController.class.getResource(" sessions.fxml"));
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

    @FXML
    void previusWindow(ActionEvent event) {
        previus.getScene().getWindow().hide();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("main.fxml"));
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

