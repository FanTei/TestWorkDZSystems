package command;

import service.EquipmentService;
import service.WellService;

public class ShowCommand implements Command {
    private final WellService wellService;

    public ShowCommand(WellService wellService) {
        this.wellService = wellService;

    }

    @Override
    public void execute(String commandText) {
        String wellNames = commandText;
        String[] namesArray = wellNames.split("[, ]+");
        for (String name : namesArray) {
            int wellId = wellService.getWellIdByName(name);
            System.out.println(name + "  " + wellService.getWellEquipmentCount(wellId));
        }
    }
}
