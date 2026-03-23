package entity;

import engine.Intersection;
import trafficlight.TrafficLight;

// Lớp đại diện cho phương tiện thông thường
// Không có quyền ưu tiên, phải tuân thủ đèn giao thông
public class StandardVehicle extends Vehicle {

    // Constructor khởi tạo xe với tốc độ mặc định = 1
    public StandardVehicle(String name, TrafficLight light, Intersection intersection) {
        super(name, 1, light, intersection);
    }

    // Xe thường không phải xe ưu tiên
    @Override
    public boolean isPriority() {
        return false;
    }
}