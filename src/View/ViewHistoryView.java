package View;

import Controller.ViewHistoryController;
import Model.Model_class.CustomerCheckSession;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewHistoryView {
    private JFrame frame;
    private JTable historyTable;
    private DesignButton backButton;
    private ViewHistoryController historyController;

    public ViewHistoryView() {
        historyController = new ViewHistoryController();
        showHistoryMenu();
    }

    public void showHistoryMenu() {
        frame = new JFrame("Menu History");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DesignPanel gradientPanel = new DesignPanel(new Color(0, 102, 204), new Color(102, 204, 255));
        gradientPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Menu History");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gradientPanel.add(titleLabel, BorderLayout.NORTH);

        int customerId = CustomerCheckSession.getInstance().getCustomer().getCustomer_id();
        DefaultTableModel model = historyController.getHistory(customerId);

        historyTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(historyTable);
        gradientPanel.add(scrollPane, BorderLayout.CENTER);

        backButton = new DesignButton("Back", new Color(0, 102, 204), new Color(102, 204, 255));
        backButton.addActionListener(e -> {
            frame.dispose();
            new CustomerMenu();
        });

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(backButton);
        gradientPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(gradientPanel);
        frame.setVisible(true);
    }
}
