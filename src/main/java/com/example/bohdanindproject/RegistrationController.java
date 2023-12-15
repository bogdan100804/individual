package com.example.bohdanindproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class RegistrationController {

    @FXML
    private TextField date;

    @FXML
    private TextField pip;

    @FXML
    private Button registrate;

    @FXML
    private Label errorMessage;

    private List<Label> selectedShows;

    private List<String> registeredViewers = new ArrayList<>();

    public void setSelectedShows(List<Label> selectedShows) {
        this.selectedShows = selectedShows;
    }

    @FXML
    void registration(ActionEvent event) {
        // Перевірка наявності введених даних
        if (pip.getText().isEmpty() || date.getText().isEmpty()) {
            errorMessage.setText("   Будь ласка, введіть ПІП та дату");
            return;
        }

        // Реєстрація нового глядача
        String newViewer = "ПІП: " + pip.getText() + ", Дата: " + date.getText();

        // Додавання обраних вистав до інформації про нового глядача (при потребі)
        if (selectedShows != null && !selectedShows.isEmpty()) {
            StringBuilder showsInfo = new StringBuilder(", Обрані вистави: ");
            for (Label show : selectedShows) {
                showsInfo.append(show.getText()).append(", ");
            }
            newViewer += showsInfo.toString();
        }

        // Додавання нового глядача до списку глядачів
        registeredViewers.add(newViewer);

        // Скидання помилки та очищення полів введення
        errorMessage.setText("");
        pip.clear();
        date.clear();

        // Вивід інформації про нового глядача (можна замінити цей вивід на збереження у вашій системі)
        System.out.println("Новий глядач зареєстрований: " + newViewer);

        registrate.getScene().getWindow().hide();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("reviews.fxml"));
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

