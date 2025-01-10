package View;

import Controller.AddTransaksiController;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class AddTransaksiView {
    private JFrame frame;
    private JTextField nameField, addressField, phoneField, weightField;
    private JComboBox<String> deliveryTypeComboBox;
    private DesignButton addButton, backButton;
    private AddTransaksiController transactionController;
    private HashMap<String, Integer> deliveryTypes;

    public AddTransaksiView() {
        transactionController = new AddTransaksiController();
        deliveryTypes = transactionController.getDelivery();
        showTransactionForm();
    }

    public void showTransactionForm() {
        frame = new JFrame("Add Transaksi Pengiriman");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DesignPanel gradientPanel = new DesignPanel(new Color(0, 102, 204), new Color(102, 204, 255));

        JLabel titleLabel = new JLabel("Add Transaksi");
        titleLabel.setBounds(0, 20, 500, 30);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gradientPanel.add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 70, 120, 25);
        nameLabel.setForeground(Color.WHITE);
        gradientPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 70, 250, 25);
        gradientPanel.add(nameField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 110, 120, 25);
        addressLabel.setForeground(Color.WHITE);
        gradientPanel.add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(180, 110, 250, 25);
        gradientPanel.add(addressField);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(50, 150, 120, 25);
        phoneLabel.setForeground(Color.WHITE);
        gradientPanel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(180, 150, 250, 25);
        gradientPanel.add(phoneField);

        JLabel weightLabel = new JLabel("Weight (kg):");
        weightLabel.setBounds(50, 190, 120, 25);
        weightLabel.setForeground(Color.WHITE);
        gradientPanel.add(weightLabel);

        weightField = new JTextField();
        weightField.setBounds(180, 190, 250, 25);
        gradientPanel.add(weightField);

        JLabel deliveryLabel = new JLabel("Delivery Type:");
        deliveryLabel.setBounds(50, 230, 120, 25);
        deliveryLabel.setForeground(Color.WHITE);
        gradientPanel.add(deliveryLabel);

        deliveryTypeComboBox = new JComboBox<>(deliveryTypes.keySet().toArray(new String[0]));
        deliveryTypeComboBox.setBounds(180, 230, 250, 25);
        gradientPanel.add(deliveryTypeComboBox);

        addButton = new DesignButton("Add", new Color(0, 153, 204), new Color(51, 204, 255));
        addButton.setBounds(100, 300, 130, 40);
        addButton.addActionListener(e -> saveTransaction());
        gradientPanel.add(addButton);

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

    private void saveTransaction() {
        String name = nameField.getText().trim();
        String address = addressField.getText().trim();
        String phone = phoneField.getText().trim();
        String weight = weightField.getText().trim();
        String deliveryType = (String) deliveryTypeComboBox.getSelectedItem();

        if (name.isEmpty() || address.isEmpty() || phone.isEmpty() || weight.isEmpty()) {
            AlertDesignTemplate.showErrorDialog(frame, "Error", "Isi semua field!");
            return;
        }

        int weightNum = Integer.parseInt(weight);
        if (weightNum <= 0) {
            AlertDesignTemplate.showErrorDialog(frame, "Error", "Berat pengiriman gabisa 0!");
            return;
        }

        int feePerKg = deliveryTypes.get(deliveryType);
        int totalCost = weightNum * feePerKg;

        if (transactionController.inputTrans(1, deliveryType, weightNum, totalCost, name, address, phone)) {
            AlertDesignTemplate.showInfoDialog(frame, "Success", "Transaksi berhasil disimpan.");
            frame.dispose();
            new CustomerMenu();
        } else {
            AlertDesignTemplate.showErrorDialog(frame, "Error", "Gagal menyimpan transaksi.");
        }
    }
}
