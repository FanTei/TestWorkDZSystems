package menu;

import command.Command;
import command.ShowCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class ShowMenu implements Menu {
    private final Command command;
    private final String showText = "Input well names";

    public ShowMenu(Command command) {
        this.command = command;
    }

    @Override
    public void show() {
        String wellNames = Application.inputString(showText);
        command.execute(wellNames);
    }
}
