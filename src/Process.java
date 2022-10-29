import java.lang.Math;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;  // Import the Scanner class

public class Process
{
    Scanner getInput = new Scanner(System.in);

    // Vocabulary of hiragana
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

    // Respective pronunciation for hiragana above
    String[] hiraganaAnswer = {
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

    // Save hiragana user answered wrongly
    String[] wrongHiragana = new String[71];
    String[] wrongPronunciation = new String[71];

    // Check if one hiragana had been added to array before
    protected boolean checkArr(String input)
    {
        return (Arrays.asList(wrongPronunciation).contains(input));
    }

    // Process
    protected void process(int mode)
    {
        // Initialization
        String input = "test";
        int wrongNum = 0;

        // Mode 1 - All hiragana
        if (mode == 1)
        {
            // Generate random index number for hiragana vocabulary
            while (!input.equals("stop"))
            {
                short num = (short)(Math.random() * 71); // From 0-70, (max 70 - min 0 + 1) + min 0 = 71

                // Question
                System.out.println("How to pronounce " + hiragana[num] + "?");

                // Get user input
                input = getInput.nextLine();

                // Get the answer
                System.out.println("DEBUG");

                // Check if user wants to end the program
                if (!Objects.equals(input, "stop"))
                {
                    // Check if user input is correct
                    if (Objects.equals(input, hiraganaAnswer[num])) System.out.println("Correct!\n");

                        // If user input is incorrect
                    else
                    {
                        if (!checkArr(hiraganaAnswer[num])) // If the hiragana does not exist in the array
                        {
                            wrongHiragana[wrongNum] = hiragana[num];
                            wrongPronunciation[wrongNum++] = hiraganaAnswer[num];
                        }

                        else System.out.println("You have answered the hiragana wrong before.");

                        // Show the hiragana and its correct pronunciation
                        System.out.print("The correct pronunciation for " +
                                hiragana[num] + " is " + hiraganaAnswer[num] + ".\n" +
                                "- Press ENTER to continue -\n");

                        input = getInput.nextLine();

                    }

                }


            }

        }
        // Mode 2 - Hiragana without voiced and voiceless sound
        else if (mode == 2)
        {
            // Generate random index number for hiragana vocabulary
            while (!input.equals("stop"))
            {
                short num = (short)(Math.random() * 46); // From 0-45, (max 45 - min 0 + 1) + min 0 = 46

                // Question
                System.out.println("How to pronounce " + hiragana[num] + "?");

                // Get answer and user input
                input = getInput.nextLine();

                // Check if user wants to end the program
                if (!Objects.equals(input, "stop"))
                {
                    // Check if user input is correct
                    if (Objects.equals(input, hiraganaAnswer[num])) System.out.println("Correct!\n");

                        // If user input is incorrect
                    else
                    {
                        if (!checkArr(hiraganaAnswer[num])) // If the hiragana does not exist in the array
                        {
                            wrongHiragana[wrongNum] = hiragana[num];
                            wrongPronunciation[wrongNum++] = hiraganaAnswer[num];
                        }

                        else System.out.println("You have answered the hiragana wrong before.");

                        // Show the hiragana and its correct pronunciation
                        System.out.print("The correct pronunciation for " +
                                hiragana[num] + " is " + hiraganaAnswer[num] + ".\n" +
                                "- Press ENTER to continue -\n");

                        input = getInput.nextLine();

                    }

                }

            }
        }

        // Other situations
        else System.out.println("Sorry, there is something wrong with the program. Please contact the developer.");

        // Summary
        System.out.println("Thank you!\n" +
                           "Here are the hiragana you answered wrongly.");

        // Display hiragana wrongly answered before
        if (wrongNum > 0)
        {
            for (int i = 0; i < wrongNum; i++)
            {
                System.out.println(wrongHiragana[i] + " (" + wrongPronunciation[i] + ")");
            }
        }

        // If user did not make any mistake
        else System.out.println("Wow! You answered all hiragana correctly!");

    }
}
