package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EquipmentService {
    private final Connection connection;

    public EquipmentService(Connection connection) {
        this.connection = connection;
    }

    public void createEquipmentByWellId(int wellId){
        String randomNameForEquipment = UUID.randomUUID().toString().substring(0, 32);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO equipment (name,well_id) VALUES(?,?)");
            preparedStatement.setString(1, randomNameForEquipment);
            preparedStatement.setInt(2, wellId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, String> getEquipmentsByWellId(int wellId){
        Map<Integer, String> equipment = new HashMap<>();
        try {
            PreparedStatement select = connection.prepareStatement("SELECT * FROM equipment WHERE well_id=" + wellId);
            ResultSet rs = select.executeQuery();
            while (rs.next()) {
                equipment.put(Integer.parseInt(rs.getString(1)), rs.getString(2));
            }
        } catch (Exception e) {
        }
        return equipment;
    }
}
