package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterController {
    private DatabaseHandler dbHandler;

    public RegisterController() {
        dbHandler = new DatabaseHandler();
        dbHandler.connect();
    }

    public boolean cek(String phone, String address) {
        String query = "SELECT * FROM Customer WHERE phone = ? OR address = ?";
        try (Connection conn = dbHandler.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, phone);
            stmt.setString(2, address);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean userRegist(String name, String phone, String address, String password) {
        String query = "INSERT INTO Customer (name, phone, address, password) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbHandler.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, address);
            stmt.setString(4, password);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
