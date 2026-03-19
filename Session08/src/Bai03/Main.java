package Bai03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RemoteControl remote = new RemoteControl();

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner ac = new AirConditioner();

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Gán nút");
            System.out.println("2. Nhấn nút");
            System.out.println("3. Undo");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Chọn nút:");
                    int btn = sc.nextInt();

                    System.out.println("Chọn chức năng:");
                    System.out.println("1. Bật đèn");
                    System.out.println("2. Tắt đèn");
                    System.out.println("3. Bật quạt");
                    System.out.println("4. Tắt quạt");
                    System.out.println("5. Set điều hòa");

                    int func = sc.nextInt();

                    Command command = null;

                    switch (func) {
                        case 1: command = new LightOnCommand(light); break;
                        case 2: command = new LightOffCommand(light); break;
                        case 3: command = new FanOnCommand(fan); break;
                        case 4: command = new FanOffCommand(fan); break;
                        case 5:
                            System.out.print("Nhập nhiệt độ: ");
                            int temp = sc.nextInt();
                            command = new ACSetTemperatureCommand(ac, temp);
                            break;
                    }

                    if (command != null) {
                        remote.setCommand(btn, command);
                    }
                    break;

                case 2:
                    System.out.print("Nhấn nút: ");
                    int press = sc.nextInt();
                    remote.pressButton(press);
                    break;

                case 3:
                    remote.undo();
                    break;

                case 0:
                    System.out.println("Thoát...");
                    return;
            }
        }
    }
}
