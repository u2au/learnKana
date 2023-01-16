package cc.rinsuki.learnkana;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Report extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Report.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 335, 600);
        stage.setTitle("learnKana");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}