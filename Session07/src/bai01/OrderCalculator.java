package bai01;

public class OrderCalculator {

    public double calculateTotal(Order order) {
        double total = 0;

        for (OrderItem item : order.getItems()) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }

        return total;
    }
}