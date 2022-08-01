import javax.swing.*;

public class First {
    public static void main(String[] args) {
        double price = Double.parseDouble(JOptionPane.showInputDialog("Please enter the price of one photobook: "));

        double total = computeBill(price);

        JOptionPane.showMessageDialog(null,"The total for one photobook that costs $" + String.format("%.2f", price) + " is $" +
                String.format("%.2f", total));

        int copies = Integer.parseInt(JOptionPane.showInputDialog("Please enter the quantity of photobooks you wish to order: "));

        total = computeBill(price, copies);

        JOptionPane.showMessageDialog(null,"The total for " + copies + " photobooks that costs $" + String.format("%.2f", price) +
                " is $" + String.format("%.2f", total));

        double coupon = Double.parseDouble(JOptionPane.showInputDialog("Please enter the amount of the coupon: "));

        total = computeBill(price, copies, coupon);

        JOptionPane.showMessageDialog(null,"The total for " + copies + " photobooks that costs $" + String.format("%.2f", price) +
                " with a $" + String.format("%.2f", coupon) + " coupon is $" + String.format("%.2f", total));
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
