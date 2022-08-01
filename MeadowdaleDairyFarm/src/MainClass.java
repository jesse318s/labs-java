import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double DOZENS_PRICE = 3.25;
        final double SINGLES_PRICE = 0.45;
        double price = 0;
        int singles = 0;
        int dozens = 0;

        // prompt user for input (in eggs)
        System.out.print("\nMeadowdale Dairy Farm sells organic brown eggs to local customers. \nIt charges $3.25 for a dozen eggs or .45 cents per individual egg that are not part of a dozen. " +
                "\n\nPlease enter the number of eggs you would like to order: ");
        int eggs = scanner.nextInt();

        // calculate price
        if (eggs >= 12) {
            dozens = eggs / 12;
            singles = eggs % 12;
            price = (dozens * DOZENS_PRICE) + (singles * SINGLES_PRICE);
        } else {
            singles = eggs;
            price = eggs * SINGLES_PRICE;
        }

        // output the amount owed and full explanation
        System.out.println("\nTotal eggs ordered: " + eggs);
        System.out.printf("\nDozens @3.25 per dozen: " + dozens + " = $%.2f", dozens * DOZENS_PRICE);
        System.out.printf("\n\nIndividual eggs @0.45 each: " + singles + " = $%.2f", singles * SINGLES_PRICE);
        System.out.printf("\n\nTotal price: $%.2f", price);
    }
}
