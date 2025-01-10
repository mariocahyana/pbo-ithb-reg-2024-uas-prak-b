package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class AddTransaksiController {
    private DatabaseHandler dbHandler;

    public AddTransaksiController() {
        dbHandler = new DatabaseHandler();
        dbHandler.connect();
    }

    public HashMap<String, Integer> getDelivery() {
        HashMap<String, Integer> deliveryTypes = new HashMap<>();
        String query = "SELECT name, fee_per_kg FROM categorydelivery";

        try (Connection conn = dbHandler.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                deliveryTypes.put(rs.getString("name"), rs.getInt("fee_per_kg"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveryTypes;
    }

    public boolean inputTrans(int customerId, String deliveryType, int weight, int totalCost,
                                   String receiptName, String receiptAddress, String receiptPhone) {
        String query = "INSERT INTO Transaction (customer_id, delivery_type, expected_weight, total_cost, " +
                       "created_at, receipt_name, receipt_address, receipt_phone) VALUES (?, ?, ?, ?, CURRENT_DATE, ?, ?, ?)";

        try (Connection conn = dbHandler.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            stmt.setString(2, deliveryType);
            stmt.setInt(3, weight);
            stmt.setInt(4, totalCost);
            stmt.setString(5, receiptName);
            stmt.setString(6, receiptAddress);
            stmt.setString(7, receiptPhone);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
