package Controller;

import Model.Model_class.Customer;
import Model.Model_class.CustomerCheckSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    private DatabaseHandler dbHandler;

    public LoginController() {
        dbHandler = new DatabaseHandler();
        dbHandler.connect();
    }

    public boolean check(String phone, String password) {
        String query = "SELECT * FROM Customer WHERE phone = ? AND password = ?";
        try (Connection conn = dbHandler.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, phone);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Customer customer = new Customer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("address"),
                    rs.getString("phone")
                );
                CustomerCheckSession.getInstance().setCustomer(customer);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
