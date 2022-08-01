import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.print("\nPlease enter the price of one photobook: ");
        double price = myScanner.nextDouble();

        double total = computeBill(price);

        System.out.println("The total for one photobook that costs $" + String.format("%.2f", price) + " is $" + String.format("%.2f", total));

        System.out.print("\nPlease enter the quantity of photobooks you wish to order: ");
        int copies = myScanner.nextInt();

        total = computeBill(price, copies);

        System.out.println("The total for " + copies + " photobooks that costs $" + String.format("%.2f", price) + " is $" + String.format("%.2f", total));

        System.out.print("\nPlease enter the amount of the coupon: ");
        double coupon = myScanner.nextDouble();

        total = computeBill(price, copies, coupon);

        System.out.println("The total for " + copies + " photobooks that costs $" + String.format("%.2f", price) + " with a $" + String.format("%.2f", coupon) +
                " coupon is $" + String.format("%.2f", total));
    }
    public static double computeBill(double price)
    {
        double tax = 0;
        double total = 0;

        tax = price * 0.0825;
        total = price + tax;

        return total;
    }
    public static double computeBill(double price, int copies)
    {
        double tax = 0;
        double total = 0;
        double totalPrice = price * copies;

        tax = totalPrice * 0.0825;
        total = totalPrice + tax;

        return total;
    }
    public static double computeBill(double price, int copies, double coupon)
    {
        double tax = 0;
        double total = 0;
        double totalPrice = price * copies;

        tax = (totalPrice - coupon) * 0.0825;
        total = totalPrice + tax - coupon;

        if (total < 0)
        {
            total = 0;
        }

        return total;
    }
}



