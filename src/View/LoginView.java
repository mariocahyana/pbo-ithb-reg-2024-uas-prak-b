package View;

import Controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginView {
    private JFrame frame;
    private JTextField phoneField;
    private JPasswordField passwordField;
    private DesignButton loginButton, backButton;
    private LoginController loginController;

    public LoginView() {
        loginController = new LoginController();
        showLoginForm();
    }

    public void showLoginForm() {
        frame = new JFrame("Menu Login");
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DesignPanel gradientPanel = new DesignPanel(new Color(0, 102, 204), new Color(102, 204, 255));

        ImageIcon logoIcon = new ImageIcon("UAS\\src\\Asset\\logo2.png");
        Image logoImg = logoIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImg));
        logoLabel.setBounds(140, 30, 120, 120);
        gradientPanel.add(logoLabel);

        JLabel brandName = new JLabel("McToz");
        brandName.setBounds(0, 160, 400, 30);
        brandName.setFont(new Font("SansSerif", Font.BOLD, 24));
        brandName.setForeground(Color.WHITE);
        brandName.setHorizontalAlignment(SwingConstants.CENTER);
        gradientPanel.add(brandName);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(70, 220, 110, 25);
        phoneLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        phoneLabel.setForeground(Color.WHITE);
        gradientPanel.add(phoneLabel);

        phoneField = new JTextField();
        phoneField.setBounds(70, 250, 260, 30);
        gradientPanel.add(phoneField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(70, 290, 100, 25);
        passwordLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        passwordLabel.setForeground(Color.WHITE);
        gradientPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(70, 320, 260, 30);
        gradientPanel.add(passwordField);

        loginButton = new DesignButton("Login", new Color(0, 153, 204), new Color(51, 204, 255));
        loginButton.setBounds(70, 380, 120, 40);
        loginButton.addActionListener(e -> loginHandling());
        gradientPanel.add(loginButton);

        backButton = new DesignButton("Back", new Color(0, 153, 204), new Color(51, 204, 255));
        backButton.setBounds(210, 380, 120, 40);
        backButton.addActionListener(e -> {
            frame.dispose();
            new MainMenu();
        });
        gradientPanel.add(backButton);

        frame.add(gradientPanel);
        frame.setVisible(true);
    }

    private void loginHandling() {
        String phone = phoneField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (phone.isEmpty() || password.isEmpty()) {
            AlertDesignTemplate.showErrorDialog(frame, "Error", "Isi semua field!");
            return;
        }

        if (loginController.check(phone, password)) {
            AlertDesignTemplate.showInfoDialog(frame, "Success", "Yeyy, berhasil!");
            frame.dispose();
            new CustomerMenu();
        } else {
            AlertDesignTemplate.showErrorDialog(frame, "Failed", "Yahh, gagal!");
        }
    }
}