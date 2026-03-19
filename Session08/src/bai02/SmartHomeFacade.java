package bai02;

public class SmartHomeFacade {

    private Light light;
    private Fan fan;
    private AirConditioner ac;
    private TemperatureSensor sensor;

    public SmartHomeFacade(TemperatureSensor sensor) {
        this.light = new Light();
        this.fan = new Fan();
        this.ac = new AirConditioner();
        this.sensor = sensor;
    }

    // Rời nhà
    public void leaveHome() {
        light.off();
        fan.off();
        ac.off();
    }

    // Ngủ
    public void sleepMode() {
        light.off();
        ac.setTemperature(28);
        fan.lowSpeed();
    }

    // Lấy nhiệt độ
    public void getCurrentTemperature() {
        double temp = sensor.getTemperatureCelsius();
        System.out.printf("Nhiệt độ hiện tại: %.1f°C\n", temp);
    }
}