module com.example.bohdanindproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.bohdanindproject to javafx.fxml;
    exports com.example.bohdanindproject;
}