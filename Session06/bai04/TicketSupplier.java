package bai04;

public class TicketSupplier implements Runnable {
    private TicketPool roomA;
    private TicketPool roomB;
    private int supplyCount;   // số vé thêm mỗi lần
    private int interval;      // thời gian giữa các lần cung cấp (ms)
    private int rounds;        // số lần cung cấp
    private boolean finished;  // đánh dấu đã cung cấp xong chưa

    public TicketSupplier(TicketPool roomA, TicketPool roomB, int supplyCount, int interval, int rounds) {
        this.roomA = roomA;
        this.roomB = roomB;
        this.supplyCount = supplyCount;
        this.interval = interval;
        this.rounds = rounds;
        this.finished = false;
    }

    @Override
    public void run() {
        for (int i = 1; i <= rounds; i++) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            roomA.addTickets(supplyCount);
            System.out.println("Nhà cung cấp: Đã thêm " + supplyCount + " vé vào phòng A");

            roomB.addTickets(supplyCount);
            System.out.println("Nhà cung cấp: Đã thêm " + supplyCount + " vé vào phòng B");
        }

        finished = true;
        System.out.println("Nhà cung cấp kết thúc.");
    }

    public boolean isFinished() {
        return finished;
    }
}