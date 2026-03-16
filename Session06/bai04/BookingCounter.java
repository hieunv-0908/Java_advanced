package bai04;

import java.util.Random;
public class BookingCounter implements Runnable {
    private String counterName;
    private TicketPool roomA;
    private TicketPool roomB;
    private int soldCount;
    private Random random;
    private TicketSupplier supplier; // để biết nhà cung cấp còn đang hoạt động không

    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB, TicketSupplier supplier) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
        this.soldCount = 0;
        this.random = new Random();
        this.supplier = supplier;
    }

    @Override
    public void run() {
        while (true) {
            boolean roomAEmpty = roomA.remainingTickets() == 0;
            boolean roomBEmpty = roomB.remainingTickets() == 0;

            // Nếu cả 2 phòng đều hết vé
            if (roomAEmpty && roomBEmpty) {
                // Nếu nhà cung cấp đã cung cấp xong hết các đợt thì mới kết thúc
                if (supplier.isFinished()) {
                    break;
                } else {
                    try {
                        Thread.sleep(2000); // chờ nhà cung cấp nạp vé mới
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
            }

            boolean chooseRoomA = random.nextBoolean();
            Ticket soldTicket = null;

            if (chooseRoomA) {
                System.out.println(counterName + " bán vé phòng A");
                soldTicket = roomA.sellTicket();

                if (soldTicket == null) {
                    System.out.println(counterName + " chuyển sang bán vé phòng B");
                    soldTicket = roomB.sellTicket();
                }
            } else {
                System.out.println(counterName + " bán vé phòng B");
                soldTicket = roomB.sellTicket();

                if (soldTicket == null) {
                    System.out.println(counterName + " chuyển sang bán vé phòng A");
                    soldTicket = roomA.sellTicket();
                }
            }

            if (soldTicket != null) {
                soldCount++;
                System.out.println(counterName + " đã bán vé " + soldTicket.getTicketId());
            }

            try {
                Thread.sleep(100); // giả lập thời gian bán vé
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(counterName + " kết thúc.");
    }

    public int getSoldCount() {
        return soldCount;
    }

    public String getCounterName() {
        return counterName;
    }
}