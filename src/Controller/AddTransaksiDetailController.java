package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTransaksiDetailController {
    private DatabaseHandler dbHandler;

    public AddTransaksiDetailController() {
        dbHandler = new DatabaseHandler();
        dbHandler.connect();
    }

    public boolean inputDetail(int transactionId, String status, String currentPosition, String evidence, String updatedBy) {
        String query = "INSERT INTO DeliveryDetails (transaction_id, status, current_position, evidence, date, updated_by) " +
                       "VALUES (?, ?, ?, ?, CURRENT_DATE, ?)";

        try (Connection conn = dbHandler.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, transactionId);
            stmt.setString(2, status);
            stmt.setString(3, currentPosition);
            stmt.setString(4, evidence);
            stmt.setString(5, updatedBy);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
