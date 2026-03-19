package bai01;

public class Fan implements Device {
    @Override
    public void turnOn() {
        System.out.println("Quạt: Quay.");
    }

    @Override
    public void turnOff() {
        System.out.println("Quạt: Dừng.");
    }
}
