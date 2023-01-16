module cc.rinsuki.learnkana {
    requires javafx.controls;
    requires javafx.fxml;


    opens cc.rinsuki.learnkana to javafx.fxml;
    exports cc.rinsuki.learnkana;
}