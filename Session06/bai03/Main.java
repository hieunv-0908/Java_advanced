package bai03;

public class Main {
    public static void main(String[] args) {
        // tạo 2 phòng vé ban đầu
        TicketPool roomA = new TicketPool("A", 10);
        TicketPool roomB = new TicketPool("B", 10);

        // tạo 2 quầy bán vé
        TicketCounter counter1 = new TicketCounter("Quầy 1", roomA);
        TicketCounter counter2 = new TicketCounter("Quầy 2", roomB);

        // tạo nhà cung cấp:
        // cứ 3 giây thêm 3 vé vào mỗi phòng, thực hiện 2 lần
        TicketSupplier supplier = new TicketSupplier(roomA, roomB, 3, 3000, 2);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread t3 = new Thread(supplier);

        // chạy đồng thời các thread
        t1.start();
        t2.start();
        t3.start();

        try {
            // chờ các thread chạy xong
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("bai03.Main bị gián đoạn.");
        }

        // in kết quả cuối cùng
        System.out.println("\n=== Kết thúc chương trình ===");
        System.out.println("Quầy 1 bán được: " + counter1.getSoldCount() + " vé");
        System.out.println("Quầy 2 bán được: " + counter2.getSoldCount() + " vé");
        System.out.println("Vé còn lại phòng A: " + roomA.getRemainingTickets());
        System.out.println("Vé còn lại phòng B: " + roomB.getRemainingTickets());
    }
}