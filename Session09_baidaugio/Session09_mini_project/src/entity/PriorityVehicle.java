package entity;

import engine.Intersection;
import trafficlight.TrafficLight;

// Lớp đại diện cho xe ưu tiên (cứu thương, cứu hỏa...)
public class PriorityVehicle extends Vehicle {

    public PriorityVehicle(String name, TrafficLight light, Intersection intersection) {
        super(name, 2, light, intersection);
    }

    // Xe ưu tiên luôn được coi là ưu tiên
    @Override
    public boolean isPriority() {
        return true;
    }

    // Override hành vi đi qua ngã tư
    @Override
    protected void passIntersection() {
        try {
            util.Logger.log(name + " (ưu tiên) xin vào ngã tư");

            // Có thể sau này bạn cho nó vào hàng ưu tiên riêng
            intersection.enter(this);

        } catch (Exception e) {
            util.Logger.log(name + " gặp lỗi: " + e.getMessage());
        }
    }
}