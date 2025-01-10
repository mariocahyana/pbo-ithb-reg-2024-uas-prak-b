package Controller;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewHistoryController {
    private DatabaseHandler dbHandler;

    public ViewHistoryController() {
        dbHandler = new DatabaseHandler();
        dbHandler.connect();
    }

    public DefaultTableModel getHistory(int customerId) {
        String[] header = {"Transaction ID", "Delivery Type", "Weight (kg)", "Total Cost", "Created At", "Updated At"};
        DefaultTableModel model = new DefaultTableModel(null, header);

        String query = "SELECT t.id AS transaction_id, t.delivery_type, t.expected_weight, t.total_cost, " +
                       "t.created_at, MAX(d.date) AS updated_at " +
                       "FROM Transaction t " +
                       "LEFT JOIN DeliveryDetails d ON t.id = d.transaction_id " +
                       "WHERE t.customer_id = ? " +
                       "GROUP BY t.id, t.delivery_type, t.expected_weight, t.total_cost, t.created_at " +
                       "ORDER BY t.created_at ASC";

        try (Connection conn = dbHandler.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String transactionId = rs.getString("transaction_id");
                String deliveryType = rs.getString("delivery_type");
                int weight = rs.getInt("expected_weight");
                int totalCost = rs.getInt("total_cost");
                String createdAt = rs.getString("created_at");
                String updatedAt = rs.getString("updated_at") != null ? rs.getString("updated_at") : "-";

                Object[] data = {transactionId, deliveryType, weight, totalCost, createdAt, updatedAt};
                model.addRow(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }
}
