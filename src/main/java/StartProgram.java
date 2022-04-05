import command.Command;
import command.CreateCommand;
import command.ExportXmlCommand;
import command.ShowCommand;
import connect.ConnectDatabase;
import menu.CreateMenu;
import menu.ExportMenu;
import menu.FirstMenu;
import menu.ShowMenu;
import service.EquipmentService;
import service.WellService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class StartProgram {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        StartProgram startProgram = new StartProgram();
        startProgram.start();
    }

    private final FirstMenu firstMenu;

    public StartProgram() throws SQLException, ClassNotFoundException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        Connection connection = connectDatabase.connected();
        EquipmentService equipmentService = new EquipmentService(connection);
        WellService wellService = new WellService(connection);
        Command createCommand = new CreateCommand(wellService, equipmentService);
        Command showCommand = new ShowCommand(wellService);
        Command exportXmlCommand = new ExportXmlCommand(wellService, equipmentService);
        CreateMenu createMenu = new CreateMenu(createCommand);
        ExportMenu exportMenu = new ExportMenu(exportXmlCommand);
        ShowMenu showMenu = new ShowMenu(showCommand);
        firstMenu = new FirstMenu(createMenu, showMenu, exportMenu);
    }

    public void start() {
        firstMenu.show();
    }
}
