package Bai03;

public class AirConditioner {
    private int temperature = 25;

    public void setTemperature(int temp) {
        System.out.println("Điều hòa: Nhiệt độ = " + temp);
        this.temperature = temp;
    }

    public int getTemperature() {
        return temperature;
    }
}
