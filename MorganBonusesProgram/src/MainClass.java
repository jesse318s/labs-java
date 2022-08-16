import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] bonuses = {{5.00, 9.00, 16.00, 22.00, 30.00},
                {10.00, 12.00, 18.00, 24.00, 36.00},
                {20.00, 25.00, 32.00, 42.00, 53.00},
                {32.00, 38.00, 45.00, 55.00, 68.00},
                {46.00, 54.00, 65.00, 77.00, 90.00},
                {60.00, 72.00, 84.00, 96.00, 120.00},
                {85.00, 100.00, 120.00, 140.00, 175.00}};
        int menuChoice = 1;
        int weeksWorked = 0;
        int positiveReviews = 0;

        System.out.println("\nWelcome to the Morgan Bonuses Program! Follow the prompts to find your holiday bonus.");
        while (menuChoice == 1) {
            System.out.println("\nWhat are your full weeks worked?");
            weeksWorked = scanner.nextInt();
            // tests weeks worked input to make sure it is within bounds of the bonuses array
            while (weeksWorked < 0) {
                System.out.println("\nWeeks worked cannot be negative. What are your full weeks worked?");
                weeksWorked = scanner.nextInt();
            }
            if (weeksWorked > 6) {
                weeksWorked = 6;
            }

            System.out.println("\nHow many positive reviews did you receive?");
            positiveReviews = scanner.nextInt();
            // tests positive reviews input to make sure it is within bounds of the bonuses array
            while (positiveReviews < 0) {
                System.out.println("\nPositive reviews cannot be negative. How many positive reviews did you receive?");

                positiveReviews = scanner.nextInt();
            }
            if (positiveReviews > 4) {
                positiveReviews = 4;
            }

            System.out.println("\nYour bonus is: $" + String.format("%.2f", bonuses[weeksWorked][positiveReviews]) + "\n\nEnter 1 to find another bonus, or enter any other integer to exit.");
            menuChoice = scanner.nextInt();
        }
    }

}
