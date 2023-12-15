package com.example.bohdanindproject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.List;

public class ReviewsController {
    @FXML
    private Button bad;

    @FXML
    private Button great;

    // Список для зберігання відгуків
    private List<String> reviews = new ArrayList<>();

    @FXML
    void initialize() {
        // Додати обробник події для кожної кнопки
        bad.setOnAction(event -> handleReview("Не добре"));
        great.setOnAction(event -> handleReview("Супер"));
    }

    // Обробка відгуку
    private void handleReview(String review) {
        // Додати відгук до списку
        reviews.add(review);

        // Вивести в консоль всі відгуки
        System.out.println("Відгуки:");
        for (String r : reviews) {
            System.out.println(r);
        }
    }
}

