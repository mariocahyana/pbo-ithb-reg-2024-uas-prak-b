package View;

import Controller.AddTransaksiDetailController;

import javax.swing.*;
import java.awt.*;

public class AddTransaksiDetailView {
    private JFrame frame;
    private JTextField transactionIdField, currentPositionField, evidenceField, updatedByField;
    private JComboBox<String> statusComboBox;
    private DesignButton AddButton, backButton;
    private AddTransaksiDetailController detailController;

    public AddTransaksiDetailView() {
        detailController = new AddTransaksiDetailController();
        showDeliveryDetailForm();
    }

    public void showDeliveryDetailForm() {
        frame = new JFrame("Add Trans Detail");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DesignPanel gradientPanel = new DesignPanel(new Color(0, 102, 204), new Color(102, 204, 255));

        JLabel titleLabel = new JLabel("Add Trans Detail");
        titleLabel.setBounds(0, 20, 500, 30);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gradientPanel.add(titleLabel);

        JLabel transactionIdLabel = new JLabel("Transaction ID:");
        transactionIdLabel.setBounds(50, 70, 120, 25);
        transactionIdLabel.setForeground(Color.WHITE);
        gradientPanel.add(transactionIdLabel);

        transactionIdField = new JTextField();
        transactionIdField.setBounds(180, 70, 250, 25);
        gradientPanel.add(transactionIdField);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(50, 110, 120, 25);
        statusLabel.setForeground(Color.WHITE);
        gradientPanel.add(statusLabel);

        String[] statuses = {"pending", "in_progress", "on_delivery", "arrived"};
        statusComboBox = new JComboBox<>(statuses);
        statusComboBox.setBounds(180, 110, 250, 25);
        gradientPanel.add(statusComboBox);

        JLabel currentPositionLabel = new JLabel("Current Position:");
        currentPositionLabel.setBounds(50, 150, 120, 25);
        currentPositionLabel.setForeground(Color.WHITE);
        gradientPanel.add(currentPositionLabel);

        currentPositionField = new JTextField();
        currentPositionField.setBounds(180, 150, 250, 25);
        gradientPanel.add(currentPositionField);

        JLabel evidenceLabel = new JLabel("Evidence:");
        evidenceLabel.setBounds(50, 190, 120, 25);
        evidenceLabel.setForeground(Color.WHITE);
        gradientPanel.add(evidenceLabel);

        evidenceField = new JTextField();
        evidenceField.setBounds(180, 190, 250, 25);
        gradientPanel.add(evidenceField);

        JLabel updatedByLabel = new JLabel("Updated By:");
        updatedByLabel.setBounds(50, 230, 120, 25);
        updatedByLabel.setForeground(Color.WHITE);
        gradientPanel.add(updatedByLabel);

        updatedByField = new JTextField();
        updatedByField.setBounds(180, 230, 250, 25);
        gradientPanel.add(updatedByField);

        AddButton = new DesignButton("Add", new Color(0, 153, 204), new Color(51, 204, 255));
        AddButton.setBounds(100, 300, 130, 40);
        AddButton.addActionListener(e -> saveDeliveryDetail());
        gradientPanel.add(AddButton);

        backButton = new DesignButton("Back", new Color(0, 153, 204), new Color(51, 204, 255));
        backButton.setBounds(270, 300, 130, 40);
        backButton.addActionListener(e -> {
            frame.dispose();
            new CustomerMenu();
        });
        gradientPanel.add(backButton);

        frame.add(gradientPanel);
        frame.setVisible(true);
    }

    private void saveDeliveryDetail() {
        String transactionIdText = transactionIdField.getText().trim();
        String status = (String) statusComboBox.getSelectedItem();
        String currentPosition = currentPositionField.getText().trim();
        String evidence = evidenceField.getText().trim();
        String updatedBy = updatedByField.getText().trim();

        if (transactionIdText.isEmpty() || currentPosition.isEmpty() || evidence.isEmpty() || updatedBy.isEmpty()) {
            AlertDesignTemplate.showErrorDialog(frame, "Error", "Isi semua field!");
            return;
        }

        int transactionId;
        try {
            transactionId = Integer.parseInt(transactionIdText);
        } catch (NumberFormatException e) {
            AlertDesignTemplate.showErrorDialog(frame, "Error", "Transaction ID harus angka!");
            return;
        }

        boolean success = detailController.inputDetail(transactionId, status, currentPosition, evidence, updatedBy);

        if (success) {
            AlertDesignTemplate.showInfoDialog(frame, "Success", "Yeyy, berhasil.");
            frame.dispose();
            new MainMenu();
        } else {
            AlertDesignTemplate.showErrorDialog(frame, "Error", "Yahh, gagal.");
        }
    }
}
