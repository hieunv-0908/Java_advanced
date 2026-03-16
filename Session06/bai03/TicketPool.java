package bai03;

import java.util.LinkedList;
import java.util.Queue;

// Quản lý danh sách vé của từng phòng
public class TicketPool {
    private String roomName;
    private Queue<String> tickets = new LinkedList<>();
    private int nextTicketNumber; // lưu số thứ tự vé tiếp theo để thêm vé mới không bị trùng

    public TicketPool(String roomName, int totalTickets) {
        this.roomName = roomName;
        this.nextTicketNumber = 1;

        // tạo vé ban đầu
        for (int i = 1; i <= totalTickets; i++) {
            tickets.add(roomName + "-" + String.format("%03d", i));
            nextTicketNumber++;
        }
    }

    // lấy 1 vé để bán
    public synchronized String getTicket() {
        if (tickets.isEmpty()) {
            return null;
        }
        return tickets.poll();
    }

    // thêm count vé mới vào phòng
    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            tickets.add(roomName + "-" + String.format("%03d", nextTicketNumber));
            nextTicketNumber++;
        }
    }

    // trả về số vé còn lại
    public synchronized int getRemainingTickets() {
        return tickets.size();
    }

    public String getRoomName() {
        return roomName;
    }
}