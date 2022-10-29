import java.util.Scanner;  // Import the Scanner class

public class Menu
{
    Scanner getInput = new Scanner(System.in);

    // Welcoming messages
    protected void showMsg()
    {
        System.out.println("Welcome! It's a program helps you memorize hiragana!\n" +
                           "We suggest you finishing learning all the hiragana before using the program.\n" +
                           "You may type 'stop' to end.\n" +
                           "- Press ENTER to select a mode -");

        getInput.nextLine();

    }

    // Select a mode to decide the vocabulary
    protected int selectMode()
    {

        System.out.println("Currently, we have 2 options for memorizing hiragana:\n" +
                           "Press 1 - All hiragana\n" +
                           "Press 2 - Hiragana without voiced and voiceless sound like ぶ、ぷ");

        // Input validation
        String mode = getInput.nextLine();
        while (Integer.parseInt(mode) != 1 && Integer.parseInt(mode) != 2)
        {
            System.out.println("Invalid input. Please type 1 or 2 to continue the program.");
            mode = getInput.nextLine();
        }

        System.out.println();

        return Integer.parseInt(mode);

    }



}
