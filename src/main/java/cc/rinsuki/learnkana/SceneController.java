package cc.rinsuki.learnkana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController {

    // Initialization
    private int mode = 0;
    private short numOfKana = -1,
                  whichKana = -1;

    private String kana = "ゑ",
                   kanaAns = "we",
                   inputAns = "uwu";

    private String[] kanaAnswer = {
            // a
            "a", "i", "u", "e", "o",
            // ka
            "ka", "ki", "ku", "ke", "ko",
            // sa
            "sa", "shi", "su", "se", "so",
            // ta
            "ta", "chi", "tsu", "te", "to",
            // na
            "na", "ni", "nu", "ne", "no",
            // ha
            "ha", "hi", "fu", "he", "ho",
            // ma
            "ma", "mi", "mu", "me", "mo",
            // ra
            "ra", "ri", "ru", "re", "ro",
            // ya
            "ya", "yu", "yo",
            // wa
            "wa", "wo",
            // n
            "n",

            // Voiceless and voiced hiragana
            // ga
            "ga", "gi", "gu", "ge", "go",
            // za
            "za", "ji", "zu", "ze", "zo",
            // da
            "da", "di", "du", "de", "do",
            // ba
            "ba", "bi", "bu", "be", "bo",
            // pa
            "pa", "pi", "pu", "pe", "po"
            // Voiceless and voiced hiragana END
    };
    // Set pronunciation answers END

    String[] hiragana = {
            // a
            "あ", "い", "う", "え", "お",
            // ka
            "か", "き", "く", "け", "こ",
            // sa
            "さ", "し", "す", "せ", "そ",
            // ta
            "た", "ち", "つ", "て", "と",
            // na
            "な", "に", "ぬ", "ね", "の",
            // ha
            "は", "ひ", "ふ", "へ", "ほ",
            // ma
            "ま", "み", "む", "め", "も",
            // ra
            "ら", "り", "る", "れ", "ろ",
            // ya
            "や", "ゆ", "よ",
            // wa
            "わ", "を",
            // n
            "ん",

            // Voiceless and voiced hiragana
            // ga
            "が", "ぎ", "ぐ", "げ", "ご",
            // za
            "ざ", "じ", "ず", "ぜ", "ぞ",
            // da
            "だ", "ぢ", "づ", "で", "ど",
            // ba
            "ば", "び", "ぶ", "べ", "ぼ",
            // pa
            "ぱ", "ぴ", "ぷ", "ぺ", "ぽ"
            // Voiceless and voiced hiragana END
    };

    String[] kanaArr = {
            // a
            "ア", "イ", "ウ", "エ", "オ",
            // ka
            "カ", "キ", "ク", "ケ", "コ",
            // sa
            "サ", "シ", "ス", "セ", "ソ",
            // ta
            "タ", "チ", "ツ", "テ", "ト",
            // na
            "ナ", "ニ", "ヌ", "ネ", "ノ",
            // ha
            "ハ", "ヒ", "フ", "ヘ", "ホ",
            // ma
            "マ", "ミ", "ム", "メ", "モ",
            // ra
            "ラ", "リ", "ル", "レ", "ロ",
            // ya
            "ヤ", "ユ", "ヨ",
            // wa
            "ワ", "ヲ",
            // n
            "ン",

            // Voiceless and voiced katakana
            // ga
            "ガ", "ギ", "グ", "ゲ", "ゴ",
            // za
            "ザ", "ジ", "ズ", "ゼ", "ゾ",
            // da
            "ダ", "ヂ", "ヅ", "デ", "ド",
            // ba
            "バ", "ビ", "ブ", "ベ", "ボ",
            // pa
            "パ", "ピ", "プ", "ペ", "ポ"
            // Voiceless and voiced katakana END
    };

    // Review Hiragana
    private void reviewHiragana()
    {
        whichKana = (short)(Math.random() * numOfKana);
        kana = hiragana[whichKana];
        kanaAns = kanaAnswer[whichKana];

    }
    // Review Hiragana END


    // Switch between scenes
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToReviewScene(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Review.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToReportScene(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Report.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToHomeScene(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // Switch between scenes END

    @FXML
    private void handleButtonOne()
    {
        mode = 1;
        numOfKana = 46;
    }

    @FXML
    private void handleButtonTwo() {
        mode = 2;
        numOfKana = 71;
    }

    @FXML
    private void handleButtonThree() {
        mode = 3;
        numOfKana = 46;
    }

    @FXML
    private void handleButtonFour() {
        numOfKana = 71;
    }

}