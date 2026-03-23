package engine;

import entity.Vehicle;

import java.util.LinkedList;
import java.util.Queue;

public class Intersection {

    private final Queue<Vehicle> queue = new LinkedList<>();

    public synchronized void enter(Vehicle v) {

        // Thêm xe vào hàng đợi
        queue.add(v);
        util.Logger.log(v.getName() + " vào hàng chờ");

        // Nếu chưa tới lượt → chờ
        while (queue.peek() != v) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Đến lượt → vào ngã tư
        util.Logger.log(">>> " + v.getName() + " vào ngã tư");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        util.Logger.log("<<< " + v.getName() + " rời ngã tư");

        // Rời khỏi hàng
        queue.poll();

        // Đánh thức xe tiếp theo
        notifyAll();
    }
}