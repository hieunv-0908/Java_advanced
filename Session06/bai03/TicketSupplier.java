package bai03;

// Nhà cung cấp vé, định kỳ thêm vé mới vào 2 phòng
public class TicketSupplier implements Runnable {
    private TicketPool roomA;
    private TicketPool roomB;
    private int supplyCount; // số vé thêm mỗi lần
    private int interval;    // thời gian nghỉ giữa các lần thêm
    private int rounds;      // số lần thêm vé

    public TicketSupplier(TicketPool roomA, TicketPool roomB, int supplyCount, int interval, int rounds) {
        this.roomA = roomA;
        this.roomB = roomB;
        this.supplyCount = supplyCount;
        this.interval = interval;
        this.rounds = rounds;
    }

    @Override
    public void run() {
        for (int i = 1; i <= rounds; i++) {
            try {
                Thread.sleep(interval); // chờ đến lần cung cấp tiếp theo
            } catch (InterruptedException e) {
                System.out.println("Nhà cung cấp bị gián đoạn.");
            }

            roomA.addTickets(supplyCount);
            System.out.println("Nhà cung cấp: Đã thêm " + supplyCount + " vé vào phòng " + roomA.getRoomName());

            roomB.addTickets(supplyCount);
            System.out.println("Nhà cung cấp: Đã thêm " + supplyCount + " vé vào phòng " + roomB.getRoomName());
        }

        System.out.println("Nhà cung cấp kết thúc.");
    }
}