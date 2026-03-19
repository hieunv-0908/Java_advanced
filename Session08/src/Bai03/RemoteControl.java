package Bai03;

import java.util.*;

public class RemoteControl {

    private Map<Integer, Command> buttons = new HashMap<>();
    private Stack<Command> history = new Stack<>();

    // Gán nút
    public void setCommand(int button, Command command) {
        buttons.put(button, command);
        System.out.println("Đã gán " + command.getClass().getSimpleName() + " cho nút " + button);
    }

    // Nhấn nút
    public void pressButton(int button) {
        Command command = buttons.get(button);
        if (command != null) {
            command.execute();
            history.push(command);
        } else {
            System.out.println("Chưa gán nút này!");
        }
    }

    // Undo
    public void undo() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            command.undo();
        } else {
            System.out.println("Không có gì để undo");
        }
    }
}