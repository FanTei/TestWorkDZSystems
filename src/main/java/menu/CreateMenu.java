package menu;

import command.Command;
import command.CreateCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class CreateMenu implements Menu {
    private final Command createCommand;

    public CreateMenu(Command createCommand) {
        this.createCommand = createCommand;
    }

    @Override
    public void show() {
        int equipmentCount = Application.inputNumber("Input the number of equipment");
        String wellName = Application.inputString("Input name of well");
        for (int i = 0; i < equipmentCount; i++) {
            createCommand.execute(wellName);
        }
    }
}
