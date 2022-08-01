import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String menuChoice = "";

//        prompts user for first input
        System.out.print("\nEnter \"Y\" or \"y\" to play a game, or enter anything else to quit: ");

        menuChoice = scanner.nextLine();

//        play game while user agrees
        while (menuChoice.equals("Y") || menuChoice.equals("y")) {
            playGame();

//        prompts user for new input
            System.out.print("\nEnter \"Y\" or \"y\" to play again, or enter anything else to quit: ");

            menuChoice = scanner.nextLine();
        }
    }

    public static void playGame() {
        String[] secretPhrases = {"java is awesome", "i love programming", "servers are useful", "business is great", "computers are awesome"};
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb;
        String randomSecretPhrase = "";
        String secretPhraseGuessed = "";
        String userGuess = "";
        int secretPhraseNum = 0;
        int correctGuessIndex = 0;

//        generates random phrase number
        secretPhraseNum = (int) (Math.random() * 5) + 1;

//        assigns random phrase
        randomSecretPhrase = secretPhrases[secretPhraseNum - 1];

//        assigns censored phrase
        secretPhraseGuessed = randomSecretPhrase.replaceAll("[a-zA-Z]", "*");

//        assigns the censored phrase to the string builder
        sb = new StringBuilder(secretPhraseGuessed);

//        prompt user for first guess
        System.out.println("\nThe censored secret phrase is: ");
        System.out.println(secretPhraseGuessed);
        System.out.println("\nWhat is your guess?");

        userGuess = scanner.nextLine().toLowerCase();

//        prompt user for guess while the phrase is not guessed
        while (secretPhraseGuessed.contains("*")) {

            if (randomSecretPhrase.contains(userGuess)) {

                if (randomSecretPhrase.equalsIgnoreCase(userGuess)) {
//                    alert user of win after full phrase guess
                    System.out.println("\nCorrect.");
                    System.out.println("You win!");

                    return;
                }

//                check single character guess
                if (userGuess.length() == 1) {
//                    assign first correct guess index
                    correctGuessIndex = randomSecretPhrase.indexOf(userGuess);

//                    loop to assign the index for each instance of the correct character guess and replace asterisks in the censored phrase
                    while (correctGuessIndex != -1) {
                        sb.replace(correctGuessIndex, correctGuessIndex + 1, userGuess);

                        secretPhraseGuessed = sb.toString();

                        correctGuessIndex = randomSecretPhrase.indexOf(userGuess, correctGuessIndex + 1);
                    }

                    if (!randomSecretPhrase.equalsIgnoreCase(secretPhraseGuessed)) {
//                        prompt user for guess after single character guess
                        System.out.println("\nCorrect.");
                        System.out.println("\nThe censored secret phrase is: ");
                        System.out.println(secretPhraseGuessed);
                        System.out.println("\nWhat is your guess?");

                        userGuess = scanner.nextLine().toLowerCase();
                    }

                } else {
//                    prompt user for guess if the previous guess was not the full phrase, and was too long
                    System.out.println("\nWrong.");
                    System.out.println("\nThe censored secret phrase is: ");
                    System.out.println(secretPhraseGuessed);
                    System.out.println("\nWhat is your guess?");

                    userGuess = scanner.nextLine().toLowerCase();
                }

                if (randomSecretPhrase.equalsIgnoreCase(secretPhraseGuessed)) {
//                    alert user of win after single character guess
                    System.out.println("\nCorrect.");
                    System.out.println("You win!");

                    return;
                }

            } else {
//                prompt user for guess if their guess doesn't match any phrase characters
                System.out.println("\nWrong.");
                System.out.println("\nThe censored secret phrase is: ");
                System.out.println(secretPhraseGuessed);
                System.out.println("\nWhat is your guess?");

                userGuess = scanner.nextLine().toLowerCase();
            }

        }
    }
}
