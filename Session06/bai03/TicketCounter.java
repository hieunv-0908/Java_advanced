package bai03;

// Quầy bán vé
public class TicketCounter implements Runnable {
    private String counterName;
    private TicketPool ticketPool;
    private int soldCount = 0;

    public TicketCounter(String counterName, TicketPool ticketPool) {
        this.counterName = counterName;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        while (true) {
            String ticket = ticketPool.getTicket();

            if (ticket == null) {
                // nếu hết vé thì dừng quầy
                break;
            }

            soldCount++;
            System.out.println(counterName + " đã bán vé " + ticket);

            try {
                // sleep để mô phỏng thời gian bán vé
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(counterName + " bị gián đoạn.");
            }
        }

        System.out.println(counterName + " kết thúc.");
    }

    public int getSoldCount() {
        return soldCount;
    }
}