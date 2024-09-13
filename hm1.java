import java.util.Scanner;

public class hm1 {

    private static final double SILVER_DISCOUNT = 0.05;
    private static final double GOLD_DISCOUNT = 0.10;
    private static final double PLATINUM_DISCOUNT = 0.15;
    private static final double MINIMUM_AMOUNT = 1000.0;

    public static double calculateDiscount(double amount, String membershipLevel) {
        double discount = 0.0;

        if (amount > MINIMUM_AMOUNT) {
            switch (membershipLevel.toUpperCase()) {
                case "SILVER":
                    discount = SILVER_DISCOUNT;
                    break;
                case "GOLD":
                    discount = GOLD_DISCOUNT;
                    break;
                case "PLATINUM":
                    discount = PLATINUM_DISCOUNT;
                    break;
                default:
                    System.out.println("Invalid membership level.");
                    return amount;
            }
            return amount * (1 - discount);
        } else {
            System.out.println("Amount is less than the minimum required for discount.");
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount spent: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter membership level (Silver/Gold/Platinum): ");
        String membershipLevel = scanner.nextLine();

        double finalAmount = calculateDiscount(amount, membershipLevel);

        System.out.printf("Original amount: %.2f\n", amount);
        System.out.printf("Final amount after discount: %.2f\n", finalAmount);

        scanner.close();
    }
}
