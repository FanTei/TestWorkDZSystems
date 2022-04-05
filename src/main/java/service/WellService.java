package service;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class WellService {
    private final Connection connection;

    public WellService(Connection connection) {
        this.connection = connection;
    }

    public int getWellIdByName(String wellName) {
        try {
            PreparedStatement select = connection.prepareStatement("SELECT * FROM well WHERE  name= ?");
            select.setString(1, wellName);
            ResultSet rs = select.executeQuery();
            if (rs.next())
                return Integer.parseInt(rs.getString(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void createWellByName(String wellName) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO well(name) VALUES(?)");
            preparedStatement.setString(1, wellName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getWellEquipmentCount(int wellId) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM equipment WHERE well_id=" + wellId);
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Map<Integer, String> getAllWells(){
        Map<Integer, String> wells = new HashMap<>();
        try {
            PreparedStatement select = connection.prepareStatement("SELECT * FROM well");
            ResultSet rs = select.executeQuery();
            while (rs.next())
                wells.put(Integer.parseInt(rs.getString(1)), rs.getString(2));

        } catch (Exception e) {
            return null;
        }
        return wells;
    }
}
