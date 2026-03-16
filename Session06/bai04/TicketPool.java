package bai04;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {
    private String roomName;
    private List<Ticket> tickets;
    private int nextTicketNumber; // dùng để đánh số vé tiếp theo

    public TicketPool(String roomName, int totalTickets) {
        this.roomName = roomName;
        this.tickets = new ArrayList<>();
        this.nextTicketNumber = 1;

        addTickets(totalTickets); // tận dụng luôn hàm thêm vé
    }

    // ===== PHẦN CŨ CỦA BÀI 1 =====
    public synchronized Ticket sellTicket() {
        for (Ticket ticket : tickets) {
            if (!ticket.isSold()) {
                ticket.setSold(true);
                return ticket;
            }
        }
        return null;
    }

    public synchronized int remainingTickets() {
        int count = 0;
        for (Ticket ticket : tickets) {
            if (!ticket.isSold()) {
                count++;
            }
        }
        return count;
    }

    public String getRoomName() {
        return roomName;
    }

    // ===== PHẦN MỚI CỦA BÀI 2 =====
    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            String ticketId = roomName + "-" + String.format("%03d", nextTicketNumber);
            tickets.add(new Ticket(ticketId, roomName));
            nextTicketNumber++;
        }
    }
}