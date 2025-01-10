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
        gradientPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Menu History");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        gradientPanel.add(titleLabel, BorderLayout.NORTH);

        int customerId = CustomerCheckSession.getInstance().getCustomer().getCustomer_id();
        DefaultTableModel model = historyController.getHistory(customerId);

        historyTable = new JTable(model);
        historyTable.setBackground(Color.WHITE);
        historyTable.setForeground(Color.BLACK);
        historyTable.setGridColor(new Color(220, 220, 220));
        historyTable.setRowHeight(25);
        historyTable.getTableHeader().setBackground(new Color(0, 102, 204));
        historyTable.getTableHeader().setForeground(Color.WHITE);
        historyTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));

        JScrollPane scrollPane = new JScrollPane(historyTable);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204)));
        gradientPanel.add(scrollPane, BorderLayout.CENTER);

        backButton = new DesignButton("Back", new Color(0, 102, 204), new Color(102, 204, 255));
        backButton.addActionListener(e -> {
            frame.dispose();
            new CustomerMenu();
        });

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setOpaque(false);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        bottomPanel.add(backButton);
        gradientPanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(gradientPanel);
        frame.setVisible(true);
    }
}