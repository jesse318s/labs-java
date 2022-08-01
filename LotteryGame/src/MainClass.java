import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        int playerNum1 = 0;
        int playerNum2 = 0;
        int playerNum3 = 0;
        Scanner sc = new Scanner(System.in);

        // Output welcome message
        System.out.println("Welcome to the Lottery Game Program!\nYou will enter three total digits for your guess, which will be compared to a randomly generated number to determine your reward.");

        // Retrieve player input
        System.out.print("\nPlease enter the first digit of your guess: ");
        playerNum1 = sc.nextInt();
        System.out.print("Please enter the second digit of your guess: ");
        playerNum2 = sc.nextInt();
        System.out.print("Please enter the third digit of your guess: ");
        playerNum3 = sc.nextInt();

        // Test player input
        testPlayerNumbers(playerNum1, playerNum2, playerNum3);
    }

    // Function to compare player guess to randomly generated number
    public static void testPlayerNumbers(int playerNum1, int playerNum2, int playerNum3) {
        boolean num1Correct = false;
        boolean num2Correct = false;
        boolean num3Correct = false;

        // Generate three random numbers between 0 and 9
        int randomNum1 = (int) (Math.random() * 10);
        int randomNum2 = (int) (Math.random() * 10);
        int randomNum3 = (int) (Math.random() * 10);

        // Output the player guess and random number
        System.out.println("\nYour guess is " + playerNum1 + playerNum2 + playerNum3 + ".");
        System.out.println("The random number is " + randomNum1 + randomNum2 + randomNum3 + ".\n");

        // Check if all three digits of the guess are correct and in order, then output reward
        if (playerNum1 == randomNum1 && playerNum2 == randomNum2 && playerNum3 == randomNum3) {
            System.out.println("You have won $1,000,000.00!");
            return;
        }

        // Check if the first digit of the player guess is correct
        if (playerNum1 == randomNum1) {
            num1Correct = true;
            playerNum1 = 99;
        }
        if (playerNum1 == randomNum2) {
            num1Correct = true;
            playerNum1 = 99;
        }
        if(playerNum1 == randomNum3) {
            num1Correct = true;
        }

        // Check if the second digit of the player guess is correct
        if (playerNum2 == randomNum1) {
            num2Correct = true;
            playerNum2 = 99;
        }
        if (playerNum2 == randomNum2) {
            num2Correct = true;
            playerNum2 = 99;
        }
        if (playerNum2 == randomNum3) {
            num2Correct = true;
        }

        // Check if the third digit of the player guess is correct
        if (playerNum3 == randomNum1) {
            num1Correct = true;
            playerNum3 = 99;
        }
        if (playerNum3 == randomNum2) {
            num2Correct = true;
            playerNum3 = 99;
        }
        if (playerNum3 == randomNum3) {
            num3Correct = true;
        }

        // Check if the entire guess is correct, then output reward
        if (num1Correct && num2Correct && num3Correct) {
            System.out.println("You have won $1,000.00!");
            return;
        }

        // Check if two digits of the guess are correct, then output reward
        if (num1Correct && num2Correct || num1Correct && num3Correct || num2Correct && num3Correct) {
            System.out.println("You have won $100.00!");
            return;
        }

        // Check if one digit of the guess is correct, then output reward
        if (num1Correct || num2Correct || num3Correct) {
            System.out.println("You have won $10.00!");
            return;
        }

        // If no digits of the guess are correct, then output reward
        System.out.println("You have won $0.00.");
    }
}
