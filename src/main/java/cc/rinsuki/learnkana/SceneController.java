package cc.rinsuki.learnkana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController {

    // Initialization
    @FXML
    Label startButton, numOfAnsLabel, kanaLabel, kanaAnsLabel, ansFeedbackLabel;

    private static int mode, numOfKana, numOfAns = 0;

    private static short whichKana,
                         firstKana = 1;

    private static String kana,
                   kanaAns,
                   inputAns,
                   lastKana,
                   lastKanaAns,
                   feedbackText;

    @FXML private TextField input;

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

    String[] katakana = {
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

    // Review Kana
    @FXML
    private void reviewKana()
    {
        numOfAnsLabel.setText(("No." + String.valueOf(++numOfAns))); // Numbering of Kana

        switch (firstKana)
        {
            case 0:
                // Check if last kana is correct
                if (!input.getText().equals(kanaAnswer[whichKana]))
                {
                    feedbackText = "Incorrect. Answer for " + kana + " is " + kanaAnswer[whichKana] + ".";
                    ansFeedbackLabel.setText(feedbackText);
                }

                else {
                    input.setText(""); // Clear text field
                    ansFeedbackLabel.setText("Correct.");
                }

                break;

            case 1:
                ansFeedbackLabel.setText("");
                firstKana = 0;
                break;

            default:
                break;

        }

        whichKana = (short)(Math.random() * numOfKana); // Generate random num

        if (mode == 1 || mode == 3) kana = hiragana[whichKana];
        else kana = katakana[whichKana];

        // Answer
        kanaAns = kanaAnswer[whichKana];
        kanaLabel.setText(kana);

        System.out.println(mode + " " + numOfKana + " " + kana + " " + kanaAns);

    }
    // Review Kana END

    // Show answer
    @FXML
    private void showAns()
    {
        kanaAnsLabel.setText(kanaAns);
    }

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

    private void setMode(int m, int n, String mn)
    {
        mode = m;
        numOfKana = n;
        startButton.setText("Let's review " + mn + "!");
    }

    @FXML
    private void handleButtonOne()
    {
        setMode(1, 46, "Hiragana");
    }

    @FXML
    private void handleButtonTwo() {
        setMode(2, 71, "Katakana");
    }

    @FXML
    private void handleButtonThree() {
        setMode(3, 46, "Hiragana with Voiced Sounds");
    }

    @FXML
    private void handleButtonFour() {
        setMode(4, 71, "Katakana with Voiced Sounds");
    }



}