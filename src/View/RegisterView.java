package View;

import Controller.RegisterController;

import javax.swing.*;
import java.awt.*;

public class RegisterView {
    private JFrame frame;
    private JTextField nameField, phoneField, addressField;
    private JPasswordField passwordField;
    private DesignButton registerButton, backButton;
    private RegisterController registerController;

    public RegisterView() {
        registerController = new RegisterController();
        showRegistForm();
    }

    public void showRegistForm() {
        frame = new JFrame("Menu Registrasi");
        frame.setSize(430, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DesignPanel gradientPanel = new DesignPanel(new Color(0, 102, 204), new Color(102, 204, 255));

        JLabel titleLabel = new JLabel("Registrasi");
        titleLabel.setBounds(0, 20, 450, 30);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gradientPanel.add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 70, 100, 25);
        nameLabel.setForeground(Color.WHITE);
        gradientPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 70, 200, 25);
        gradientPanel.add(nameField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 110, 100, 25);
        phoneLabel.setForeground(Color.WHITE);
        gradientPanel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(150, 110, 200, 25);
        gradientPanel.add(phoneField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 150, 100, 25);
        addressLabel.setForeground(Color.WHITE);
        gradientPanel.add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(150, 150, 200, 25);
        gradientPanel.add(addressField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 190, 100, 25);
        passwordLabel.setForeground(Color.WHITE);
        gradientPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 190, 200, 25);
        gradientPanel.add(passwordField);

        registerButton = new DesignButton("Register", new Color(0, 153, 204), new Color(51, 204, 255));
        registerButton.setBounds(70, 235, 130, 40);
        registerButton.addActionListener(e -> registerHandling());
        gradientPanel.add(registerButton);

        backButton = new DesignButton("Back", new Color(0, 153, 204), new Color(51, 204, 255));
        backButton.setBounds(220, 235, 130, 40);
        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });
        gradientPanel.add(backButton);

        frame.add(gradientPanel);
        frame.setVisible(true);
    }

    private void registerHandling() {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        String address = addressField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (name.isEmpty() || phone.isEmpty() || address.isEmpty() || password.isEmpty()) {
            AlertDesignTemplate.showErrorDialog(frame, "Error", "Isi semua field!");
            return;
        }

        if (registerController.cek(phone, address)) {
            AlertDesignTemplate.showErrorDialog(frame, "Error", "Alamat / Nomer HP sudah ada!");
            return;
        }

        if (registerController.userRegist(name, phone, address, password)) {
            AlertDesignTemplate.showInfoDialog(frame, "Success", "Yeyy, berhasil!");
            frame.dispose();
            new LoginView();
        } else {
            AlertDesignTemplate.showErrorDialog(frame, "Error", "Yahh, Gagal!");
        }
    }
}
