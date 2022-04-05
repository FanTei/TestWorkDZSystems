package command;

import service.EquipmentService;
import service.WellService;

import java.sql.*;
import java.util.UUID;

public class CreateCommand implements Command {
    private final WellService wellService;
    private final EquipmentService equipmentService;

    public CreateCommand(WellService wellService, EquipmentService equipmentService) {
        this.wellService = wellService;
        this.equipmentService = equipmentService;
    }

    @Override
    public void execute(String commandText) {
        String wellName = commandText;
        int wellId = wellService.getWellIdByName(wellName);
        if (wellId == -1) {
            wellService.createWellByName(wellName);
            wellId = wellService.getWellIdByName(wellName);
        }
        equipmentService.createEquipmentByWellId(wellId);
    }


}
