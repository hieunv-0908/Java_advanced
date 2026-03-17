package bai02;

public class Main {

    public static void main(String[] args) {

        double total = 1_000_000;

        // PercentageDiscount 10%
        OrderCalculator calc1 =
                new OrderCalculator(new PercentageDiscount(10));

        System.out.println("Số tiền sau giảm: " + calc1.calculate(total));


        // FixedDiscount 50.000
        OrderCalculator calc2 =
                new OrderCalculator(new FixedDiscount(50_000));

        System.out.println("Số tiền sau giảm: " + calc2.calculate(total));


        // NoDiscount
        OrderCalculator calc3 =
                new OrderCalculator(new NoDiscount());

        System.out.println("Số tiền sau giảm: " + calc3.calculate(total));


        // HolidayDiscount 15%
        OrderCalculator calc4 =
                new OrderCalculator(new HolidayDiscount());

        System.out.println("Số tiền sau giảm: " + calc4.calculate(total));
    }
}
