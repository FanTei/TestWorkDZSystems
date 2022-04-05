package menu;

import java.io.*;

public class FirstMenu implements Menu {
    private final CreateMenu createMenu;
    private final ExportMenu exportMenu;
    private final ShowMenu showMenu;

    public FirstMenu(CreateMenu createMenu, ShowMenu showMenu, ExportMenu exportMenu) {
        this.createMenu = createMenu;
        this.showMenu = showMenu;
        this.exportMenu = exportMenu;
    }

    @Override
    public void show() {
        String menu = "1)To create equipment at the well\n" +
                "2)Information output\n" +
                "3)Export to XML";
        System.out.println(menu);
        String input = Application.inputString("");
        switch (input) {
            case "1": {
                createMenu.show();
                break;
            }
            case "2": {
                showMenu.show();
                break;
            }
            case "3": {
                exportMenu.show();
            }
        }
        show();
    }
}
