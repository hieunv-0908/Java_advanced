package bai01;

public class Main {
    public static void main(String[] args) {

        // Tạo sản phẩm
        Product p1 = new Product("SP01", "Laptop", 15000000);
        Product p2 = new Product("SP02", "Chuột", 300000);

        System.out.println("Đã thêm sản phẩm SP01, SP02");

        // Tạo khách hàng
        Customer customer = new Customer("Nguyễn Văn A", "a@example.com", "Hà Nội");

        System.out.println("Đã thêm khách hàng");

        // Tạo đơn hàng
        Order order = new Order("ORD001", customer);

        order.addItem(p1, 1);
        order.addItem(p2, 2);

        System.out.println("Đơn hàng ORD001 được tạo");

        // Tính tổng tiền
        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);

        order.setTotal(total);

        System.out.println("Tổng tiền: " + total);

        // Lưu đơn hàng
        OrderRepository repository = new OrderRepository();
        repository.save(order);

        // Gửi email
        EmailService emailService = new EmailService();
        emailService.sendOrderConfirmation(customer, order);
    }
}