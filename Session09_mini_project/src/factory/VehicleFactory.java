package factory;

import entity.*;
import engine.Intersection;
import trafficlight.TrafficLight;

import java.util.Random;

// Factory chịu trách nhiệm tạo các loại phương tiện
public class VehicleFactory {

    private static final Random random = new Random();

    public static Vehicle createVehicle(int id, TrafficLight light, Intersection intersection) {

        // Sinh số ngẫu nhiên từ 0 - 99
        int chance = random.nextInt(100);

        // 20% tạo xe ưu tiên
        if (chance < 20) {
            return new PriorityVehicle("Xe cứu thương #" + id, light, intersection);
        }

        // 80% tạo xe thường
        return new StandardVehicle("Xe thường #" + id, light, intersection);
    }
}