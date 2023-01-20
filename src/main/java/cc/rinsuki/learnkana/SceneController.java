package cc.rinsuki.learnkana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class SceneController {

    // Initialization
    @FXML
    Label startButtonLabel,
          numOfAnsLabel,
          kanaLabel,
          kanaAnsLabel,
          ansFeedbackLabel,
          wrongKanaLabel,
          questionLabel,
          bonusLabel;

    @FXML
    private ProgressBar progressBar;

    private static int mode,
                       numOfKana,
                       numOfAns = 0,
                       numOfWrongKana = 0;

    private static boolean existedKana = false;

    private static short whichKana,
                         firstKana = 1;

    private static String kana,
                          kanaAns,
                          feedbackText,
                          wrongKanaLabelText = "";

    @FXML private TextField input;
    @FXML private Button nextButton,
                         checkButton,
                         reportButton;

    private final String[] wrongKana = new String[71];
    private final String[] wrongPronunciation = new String[71];

    // Set pronunciation answers
    private final String[] kanaAnswer = {
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

    // Set kana
    private final String[] hiragana = {
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
    // Set kana END

    // Check if one kana had been added to array before
    private boolean checkArr(String k) { return (!Arrays.asList(wrongKana).contains(k)); }

    // Check if kana pronunciation is correct
    private void checkKana()
    {
            // Get kana and check if kana exists
            if (mode == 1 || mode == 3) // Hiragana
            {
                // If kana not exist
                if (checkArr(hiragana[whichKana]))
                    wrongKana[numOfWrongKana] = hiragana[whichKana];

                else existedKana = true;
            }

            else // Katakana
            {
                // If kana not exist
                if (checkArr(katakana[whichKana]))
                    wrongKana[numOfWrongKana] = katakana[whichKana];

                else existedKana = true;
            }
            // Get kana and check if kana exists END

        if (!existedKana)
        {
            wrongPronunciation[numOfWrongKana] = kanaAnswer[whichKana];

            // Check if exceed max num of wrong kana
            // Need modification
            if (numOfWrongKana >= 15)
                firstKana = 1;

            else
                // Save kana and pronunciation information
                wrongKanaLabelText += (wrongKana[numOfWrongKana] + " (" + wrongPronunciation[numOfWrongKana++] + ")\n");

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
                    checkKana();
                    progressBar.setProgress(((double)(numOfWrongKana) / 15));
                }

                else
                {
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
                progressBar.setStyle("-fx-accent: #39C5BB;");
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
            numOfAnsLabel.setText(("No." + (++numOfAns))); // Numbering of Kana
            whichKana = (short)(Math.random() * numOfKana); // Generate random num
            kanaAns = kanaAnswer[whichKana]; // Set answer

            if (mode == 1 || mode == 3)
                kana = hiragana[whichKana];

            else kana = katakana[whichKana];

            // Display new kana
            kanaLabel.setText(kana);

        }

    }
    // Review Kana END

    // Show answer
    @FXML
    private void showAns()
    {
        kanaAnsLabel.setText(kanaAns);
    }

    private void setMode(int m, int n, String mn)
    {
        mode = m;
        numOfKana = n;
        startButtonLabel.setText("Let's review " + mn + "!");
    }

    @FXML
    private void handleButtonH()
    {
        setMode(1, 46, "Hiragana");
        startButtonLabel.setDisable(false);
    }

    @FXML
    private void handleButtonK() {
        setMode(2, 46, "Katakana");
        startButtonLabel.setDisable(false);
    }

    @FXML
    private void handleButtonHVC() {
        setMode(3, 71, "Hiragana with Voiced Sounds");
        startButtonLabel.setDisable(false);
    }

    @FXML
    private void handleButtonKVC() {
        setMode(4, 71, "Katakana with Voiced Sounds");
        startButtonLabel.setDisable(false);
    }

    @FXML
    private void generateReport() {
        if (wrongKanaLabelText.equals(""))
            wrongKanaLabel.setText("Wow, you answered all kana correctly!");

        else
        {
            wrongKanaLabel.setText(wrongKanaLabelText);
            wrongKanaLabelText = "";
        }

        reportButton.setDisable(true); // Disable the button after generating the report

    }

    // Switch between scenes
    private Stage stage;
    private Scene scene;

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

    public void switchToModeSelectionScene(ActionEvent event) throws IOException
    {
        reportButton.setDisable(true); // Set as default
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ModeSelection.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // Switch between scenes END

    public void helloWorld()
    {
        bonusLabel.setText("From the beginning, when we didn't\nknow what JavaFX was, to today's learnKana,\ncountless days and nights have brought\nus to fruition, although this program\nis still immature, thank you for using it :-)");
    }

}