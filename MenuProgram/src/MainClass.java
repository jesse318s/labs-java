import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        int menuChoice = 0;
        Scanner scanner = new Scanner(System.in);

        while(menuChoice != 4) {
            // Prompt the user for a menu choice
            System.out.print(
                    "\n1. Display the factorial of a chosen number.\n2. Display all prime numbers between 1 and a chosen number.\n3. Display all perfect numbers between 1 and a chosen number\n4. Exit Program." +
                            "\n\nPlease make a menu selection: "
            );

            menuChoice = scanner.nextInt();

            // Process the menu choice
            if (menuChoice == 1) {
                calculateFactorial();
            }

            if (menuChoice == 2) {
                calculatePrimes();
            }

            if (menuChoice == 3) {
                calculatePerfects();
            }
        }
    }

    public static void calculateFactorial() {
        int menuChoice = 1;

        while (menuChoice == 1) {
            int userNumber = 0;
            int factorialCount = 0;
            int factorialResult = 0;
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for a number
            System.out.print("\nPlease enter a positive whole number or zero: ");

            userNumber = scanner.nextInt();
            factorialCount = userNumber;

            System.out.println();

            // Calculate and output the factorial of the user's number
            if (userNumber > 1) {
                System.out.print(userNumber + " x ");

                factorialResult = userNumber * --factorialCount;

                System.out.print(factorialCount);

                while (factorialCount > 1) {
                    System.out.print(" x ");
                    factorialCount--;

                    System.out.print(factorialCount);
                    factorialResult *= factorialCount;
                }

                System.out.println(" = " + factorialResult);
            } else if (userNumber > -1) {
                System.out.println(userNumber + " = 1");
            } else {
                System.out.println();
            }

            // Prompt the user to continue
            System.out.print(
                    "\nWould you like to enter another number, or return to the main menu?\n1. Enter another number.\n2. Return to the main menu." +
                            "\n\nPlease make a menu selection: "
            );

            menuChoice = scanner.nextInt();
        }
    }

    public static void calculatePrimes() {
        int menuChoice = 1;

        while (menuChoice == 1) {
            boolean isPrime = true;
            int userNumber = 0;
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for a number
            System.out.print("\nPlease enter a positive whole number: ");

            userNumber = scanner.nextInt();

            System.out.println();

            // Calculate and output the primes between the user's number and 1
            for (int i = 2; i < userNumber + 1; i++) {
                for (int x = 2; x <= i / 2; ++x) {
                    if (i % x == 0) {
                        isPrime = false;
                        x = i + 1;
                    }
                }

                if (isPrime) {
                    System.out.print(i + " ");
                }

                isPrime = true;
            }

            System.out.println();

            // Prompt the user to continue
            System.out.print(
                    "\nWould you like to enter another number, or return to the main menu?\n1. Enter another number.\n2. Return to the main menu." +
                            "\n\nPlease make a menu selection: "
            );

            menuChoice = scanner.nextInt();
        }
    }

    public static void calculatePerfects() {
        int menuChoice = 1;

        while (menuChoice == 1) {
            int userNumber = 0;
            Scanner scanner = new Scanner(System.in);

            // Prompt the user for a number
            System.out.print("\nPlease enter a whole number: ");

            userNumber = scanner.nextInt();

            System.out.println();

            // Calculate and output the perfect numbers between the user's number and 1
            for (int i = 2; i < userNumber + 1; i++) {
                int sum = 1;

                for (int x = 2; x <= i/2; ++x) {
                    if (i % x == 0) {
                        sum += x;
                    }
                }

                if (sum == i) {
                    System.out.print(i + " ");
                }
            }

            System.out.println();

            // Prompt the user to continue
            System.out.print(
                    "\nWould you like to enter another number, or return to the main menu?\n1. Enter another number.\n2. Return to the main menu." +
                            "\n\nPlease make a menu selection: "
            );

            menuChoice = scanner.nextInt();
        }
    }
}
