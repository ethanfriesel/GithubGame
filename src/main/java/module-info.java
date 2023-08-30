module com.example.githubgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.githubgame to javafx.fxml;
    exports com.example.githubgame;
}