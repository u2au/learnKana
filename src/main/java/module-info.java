module com.example.learnkana {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.learnkana to javafx.fxml;
    exports com.example.learnkana;
    exports homecontroller.learnkana;
    opens homecontroller.learnkana to javafx.fxml;
    exports cc.rinsuki.learnkana;
    opens cc.rinsuki.learnkana to javafx.fxml;
}