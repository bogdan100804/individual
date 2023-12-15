package com.example.bohdanindproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SessionsController {
    @FXML
    private Label first;

    @FXML
    private Button next;

    @FXML
    private Label second;

    @FXML
    private Label third;

    private List<Label> selectedShows = new ArrayList<>();

    @FXML
    void initialize() {
        // Додати обробник події для кожного Label
        first.setOnMouseClicked(event -> handleLabelClick(first));
        second.setOnMouseClicked(event -> handleLabelClick(second));
        third.setOnMouseClicked(event -> handleLabelClick(third));
    }

    private void handleLabelClick(Label label) {
        // Якщо Label вже вибрано, відмінити вибір, інакше додати його до списку вибраних
        if (selectedShows.contains(label)) {
            label.setStyle("-fx-background-color: #CDBD29; -fx-background-radius: 30;");
            selectedShows.remove(label);
        } else {
            label.setStyle("-fx-background-color: #FFD700; -fx-background-radius: 30;");
            selectedShows.add(label);
        }

        // Вивести в консоль обрані Label
        System.out.println("Обрані вистави:");
        for (Label selectedShow : selectedShows) {
            System.out.println(selectedShow.getText());
        }

        // Перевірити, чи є обрані вистави, і відповідно встановити доступність кнопки "Далі"
        next.setDisable(selectedShows.isEmpty());
    }

    @FXML
    void nextWindow(ActionEvent event) {
        // Перевірка, чи вибрані хоча б один Label перед переходом
        if (!selectedShows.isEmpty()) {
            next.getScene().getWindow().hide();

            // Передача списку вибраних вистав у нове вікно
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registration.fxml"));
                AnchorPane root = fxmlLoader.load();
                RegistrationController registrationController = fxmlLoader.getController();
                registrationController.setSelectedShows(selectedShows);

                Scene scene = new Scene(root, 700, 500);
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
}

