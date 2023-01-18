package cc.rinsuki.learnkana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class SceneController {

    // Initialization
    @FXML
    Label startButton, numOfAnsLabel, kanaLabel, kanaAnsLabel, ansFeedbackLabel, wrongKanaLabel, questionLabel;

    private static int mode, numOfKana, numOfAns = 0, numOfWrongKana = 0;

    private static boolean existedKana = false;

    private static short whichKana,
                         firstKana = 1;

    private static String kana,
                   kanaAns,
                   inputAns,
                   lastKana,
                   lastKanaAns,
                   feedbackText,
                   wrongKanaLabelText = "";

    @FXML private TextField input;
    @FXML private Button nextButton, checkButton;

    String[] wrongKana = new String[71];
    String[] wrongPronunciation = new String[71];

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

    // Check if one kana had been added to array before
    private boolean checkArr(String k)
    {
        return (Arrays.asList(wrongKana).contains(k));
    }

    // Check if kana pronunciation is correct
    private void checkKana(String kp)
    {
//        // If incorrect
//        if (!kp.equals(kanaAnswer[whichKana]))
//        {
            // Get kana and check if kana exists
            if (mode == 1 || mode == 3) // Hiragana
            {
                // If kana not exist
                if (!checkArr(hiragana[whichKana]))
                {
                    wrongKana[numOfWrongKana] = hiragana[whichKana];
                    System.out.println(wrongKana[numOfWrongKana] + " " + hiragana[whichKana]); // DEBUG

                }

                else existedKana = true;
            }

            else // Katakana
            {
                // If kana not exist
                if (!checkArr(katakana[whichKana]))
                {
                    wrongKana[numOfWrongKana] = katakana[whichKana];
                }

                else existedKana = true;
            }
            // Get kana and check if kana exists END

//        }

        if (!existedKana)
        {
            wrongPronunciation[numOfWrongKana] = kanaAnswer[whichKana];
            System.out.println(wrongPronunciation[numOfWrongKana] + " " + kanaAnswer[whichKana]); // DEBUG

            // Check if exceed max num of wrong kana
            // Need modification
            if (numOfWrongKana >= 15)
            {
                firstKana = 1;
            }

            else
            {
                // Save kana and pronunciation information
                System.out.println(wrongKana[numOfWrongKana] + wrongPronunciation[numOfWrongKana]); // DEBUG
                wrongKanaLabelText += (wrongKana[numOfWrongKana] + " (" + wrongPronunciation[numOfWrongKana++] + ")\n");
                System.out.println(wrongKana[numOfWrongKana] + wrongPronunciation[numOfWrongKana]); // DEBUG

            }
        }

        existedKana = false; // Restore existing status

    }
    // Check if kana pronunciation is correct END


    // Review Kana
    @FXML
    private void reviewKana()
    {
        // Check corrective of last kana
        switch (firstKana)
        {
            case 0:
                // Check if last kana is correct
                if (!input.getText().equals(kanaAnswer[whichKana]))
                {
                    feedbackText = "Incorrect. Answer for " + kana + " is " + kanaAnswer[whichKana] + ".";
                    ansFeedbackLabel.setText(feedbackText);
                    checkKana(input.getText());
                }

                else {
                    input.setText(""); // Clear text field
                    ansFeedbackLabel.setText("Correct.");
                }

                break;

            case 1:
                // Set as default
                ansFeedbackLabel.setText("");
                numOfWrongKana = 0;
                firstKana = 0;
                numOfAns = 0;
                questionLabel.setText("What is the pronunciation for this kana?");
                ansFeedbackLabel.setText("Please press ENTER to jump to next kana.");
                nextButton.setDisable(false);
                checkButton.setDisable(false);

                break;

            default:
                break;

        }
        // Check corrective of last kana END

        // End the review
        if (numOfWrongKana >= 15)
        {
            nextButton.setDisable(true);
            questionLabel.setText("So far, there are 15 kana errors.");
            ansFeedbackLabel.setText("Let's click 'Finish!' to see your report!");
        }

        // Continue reviewing
        else
        {
            kanaAnsLabel.setText(""); // Set as default
            numOfAnsLabel.setText(("No." + String.valueOf(++numOfAns))); // Numbering of Kana
            whichKana = (short)(Math.random() * numOfKana); // Generate random num
            kanaAns = kanaAnswer[whichKana]; // Set answer

            if (mode == 1 || mode == 3)
            {
                kana = hiragana[whichKana];
            }

            else
            {
                kana = katakana[whichKana];
            }

            // Display new kana
            kanaLabel.setText(kana);

            System.out.println(mode + " " + numOfKana + " " + kana + " " + kanaAns); // DEBUG
        }



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
        firstKana = 1; // Set as default
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
        startButton.setDisable(false);
    }

    @FXML
    private void handleButtonTwo() {
        setMode(2, 46, "Katakana");
        startButton.setDisable(false);
    }

    @FXML
    private void handleButtonThree() {
        setMode(3, 71, "Hiragana with Voiced Sounds");
        startButton.setDisable(false);
    }

    @FXML
    private void handleButtonFour() {
        setMode(4, 71, "Katakana with Voiced Sounds");
        startButton.setDisable(false);
    }

    @FXML
    private void generateReport()
    {
        wrongKanaLabel.setText(wrongKanaLabelText);
        System.out.println(wrongKanaLabelText); // DEBUG
        wrongKanaLabelText = "";
    }

}