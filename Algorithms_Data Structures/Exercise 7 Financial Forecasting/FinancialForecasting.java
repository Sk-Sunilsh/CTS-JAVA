import java.util.Scanner;
import java.text.NumberFormat;

public class FinancialForecasting {

    public static double calculateFutureValue(double principal, double annualRate, int periodYears) {
        if (periodYears <= 0) return principal;
        return calculateFutureValue(principal, annualRate, periodYears - 1) * (1 + annualRate);
    }

    public static double calculateFutureValueIterative(double principal, double annualRate, int periodYears) {
        double amount = principal;
        for (int i = 1; i <= periodYears; i++) {
            amount *= (1 + annualRate);
        }
        return amount;
    }

    public static String formatCurrency(double amount) {
        return NumberFormat.getCurrencyInstance().format(amount);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter initial investment amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter expected annual interest rate (%): ");
        double ratePercent = input.nextDouble();
        double annualRate = ratePercent / 100.0;

        System.out.print("Enter number of years to forecast: ");
        int years = input.nextInt();

        if (principal < 0 || ratePercent < 0 || years < 0) {
            System.out.println("Please enter non-negative values for all inputs.");
        } else {
            double futureValueRecursive = calculateFutureValue(principal, annualRate, years);
            double futureValueIterative = calculateFutureValueIterative(principal, annualRate, years);

            System.out.println("\n--- Financial Forecast ---");
            System.out.printf("Recursive Method: %s after %d years%n", formatCurrency(futureValueRecursive), years);
            System.out.printf("Iterative Method: %s after %d years%n", formatCurrency(futureValueIterative), years);
        }

        input.close();
    }
}
