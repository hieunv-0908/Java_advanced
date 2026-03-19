package bai02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // dùng cảm biến cũ + adapter
        OldThermometer old = new OldThermometer();
        TemperatureSensor sensor = new ThermometerAdapter(old);

        SmartHomeFacade facade = new SmartHomeFacade(sensor);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem nhiệt độ");
            System.out.println("2. Rời nhà");
            System.out.println("3. Chế độ ngủ");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    facade.getCurrentTemperature();
                    break;

                case 2:
                    facade.leaveHome();
                    break;

                case 3:
                    facade.sleepMode();
                    break;

                case 0:
                    System.out.println("Thoát...");
                    return;
            }
        }
    }
}
