package connect;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParserConfigurationException {
        ConnectDatabase connectDatabase = new ConnectDatabase();
        Connection connection = connectDatabase.connected();

    }

    public Connection connected() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        String connect = "jdbc:sqlite:test.db";
        return DriverManager.getConnection(connect);
    }
}
