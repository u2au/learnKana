import java.util.Scanner;  // Import the Scanner class

public class Menu
{
    Scanner getInput = new Scanner(System.in);

    // Welcoming messages
    protected void showMsg()
    {
        System.out.println("""
                Welcome! It's a program helps you memorize hiragana!
                We suggest you finishing learning all the hiragana before using the program.
                You may type 'stop' to end.
                - Press ENTER to select a mode -""");

        getInput.nextLine();

    }

    // Select a mode to decide the vocabulary
    protected int selectMode()
    {

        System.out.println("""
                Currently, we have 4 options for memorizing kana:
                Press 1 - All hiragana
                Press 2 - Hiragana without voiced and voiceless sound like ぶ、ぷ
                Press 3 - All katakana
                Press 4 - Katakana without voiced and voiceless sound like ブ、プ
                """);

        // Input validation
        String mode = getInput.nextLine();
        while (Integer.parseInt(mode) != 1 && Integer.parseInt(mode) != 2 && Integer.parseInt(mode) != 3 && Integer.parseInt(mode) != 4)
        {
            System.out.println("Invalid input. Please type 1/2/3/4 to continue the program.");
            mode = getInput.nextLine();
        }

        System.out.println();

        return Integer.parseInt(mode);

    }



}
