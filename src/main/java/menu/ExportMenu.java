package menu;

import command.Command;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExportMenu implements Menu {
    private final String showText = "Input file name to export";
    private final Command command;

    public ExportMenu(Command command) {
        this.command = command;
    }

    @Override
    public void show() {
        String fileName = Application.inputString(showText);
        while (fileName.length()<4||!fileName.substring(fileName.length()-4,fileName.length()).equals(".xml"))
            fileName = Application.inputString("Input .xml file");
        command.execute(fileName);
    }
}
