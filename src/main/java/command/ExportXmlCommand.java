package command;


import service.EquipmentService;
import service.WellService;

import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class ExportXmlCommand implements Command {

    private final WellService wellService;
    private final EquipmentService equipmentService;

    public ExportXmlCommand(WellService wellService, EquipmentService equipmentService) {
        this.wellService = wellService;
        this.equipmentService = equipmentService;
    }

    @Override
    public void execute(String commandText) {
        String fileName = commandText;
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("<dbinfo>\n");
            Map<Integer, String> wells = wellService.getAllWells();
            for (Integer wellId : wells.keySet()) {
                fileWriter.write(String.format("<well name =\"%s\" id=\"%d\">\n", wells.get(wellId), wellId));
                Map<Integer, String> equipment = equipmentService.getEquipmentsByWellId(wellId);
                for (Integer equipmentId : equipment.keySet()) {
                    fileWriter.write(String.format("    <equipment name=\"%s\" id=\"%d\"/>\n", equipment.get(equipmentId), equipmentId));
                }
                fileWriter.write("</well>\n");
            }
            fileWriter.write("</dbinfo>\n");
            fileWriter.close();
        } catch (Exception e) {
        }
    }
}
