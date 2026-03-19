package Bai03;

public class ACSetTemperatureCommand implements Command {

    private AirConditioner ac;
    private int newTemp;
    private int prevTemp;

    public ACSetTemperatureCommand(AirConditioner ac, int newTemp) {
        this.ac = ac;
        this.newTemp = newTemp;
    }

    public void execute() {
        prevTemp = ac.getTemperature(); // lưu trạng thái cũ
        ac.setTemperature(newTemp);
    }

    public void undo() {
        ac.setTemperature(prevTemp);
        System.out.println("Undo: Điều hòa: Nhiệt độ = " + prevTemp);
    }
}