import entity.Product;
import factory.ProductFactory;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();

        int choice = 0;

        do {
            System.out.println("\n---------------------- QUẢN LÝ SẢN PHẨM ----------------------");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xoá sản phẩm");
            System.out.println("5. Thoát");
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(" Nhập sai!");
                continue;
            }

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Loại (1-Physical, 2-Digital): ");
                        int type = Integer.parseInt(sc.nextLine());

                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Price: ");
                        double price = Double.parseDouble(sc.nextLine());

                        System.out.print(type == 1 ? "Weight: " : "Size: ");
                        double extra = Double.parseDouble(sc.nextLine());

                        Product p = ProductFactory.createProduct(type, id, name, price, extra);

                        if (p != null) {
                            db.addProduct(p);
                            System.out.println(" Thêm thành công!");
                        } else {
                            System.out.println(" Loại không hợp lệ!");
                        }

                    } catch (Exception e) {
                        System.out.println(" Lỗi nhập dữ liệu!");
                    }
                    break;

                case 2:
                    List<Product> list = db.getProducts();

                    if (list.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        for (Product p : list) {
                            p.displayInfo();
                        }
                    }
                    break;

                case 3:
                    try {
                        System.out.print("ID cần sửa: ");
                        String id = sc.nextLine();

                        System.out.print("Loại mới (1-Physical, 2-Digital): ");
                        int type = Integer.parseInt(sc.nextLine());

                        System.out.print("Name mới: ");
                        String name = sc.nextLine();

                        System.out.print("Price mới: ");
                        double price = Double.parseDouble(sc.nextLine());

                        System.out.print(type == 1 ? "Weight: " : "Size: ");
                        double extra = Double.parseDouble(sc.nextLine());

                        Product newProduct = ProductFactory.createProduct(type, id, name, price, extra);

                        if (newProduct != null && db.updateProduct(id, newProduct)) {
                            System.out.println(" Cập nhật thành công!");
                        } else {
                            System.out.println(" Không tìm thấy!");
                        }

                    } catch (Exception e) {
                        System.out.println(" Lỗi nhập!");
                    }
                    break;

                case 4:
                    System.out.print("ID cần xoá: ");
                    String id = sc.nextLine();

                    if (db.deleteProduct(id)) {
                        System.out.println(" Xoá thành công!");
                    } else {
                        System.out.println("Không tìm thấy!");
                    }
                    break;

                case 5:
                    System.out.println("Thoát...");
                    break;

                default:
                    System.out.println("Sai lựa chọn!");
            }

        } while (choice != 5);
    }
}