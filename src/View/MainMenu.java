package View;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    private JFrame frame;
    private DesignButton loginButton, registerButton, exitButton;

    public MainMenu() {
        showMainMenu();
    }

    public void showMainMenu() {
        frame = new JFrame("Main Menu");
        frame.setSize(400, 390);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DesignPanel gradientPanel = new DesignPanel(new Color(0, 102, 204), new Color(102, 204, 255));
        gradientPanel.setLayout(null);

        JLabel titleLabel = new JLabel("McToz Delivery Service");
        titleLabel.setBounds(0, 50, 400, 40);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gradientPanel.add(titleLabel);

        loginButton = new DesignButton("LOGIN", new Color(0, 153, 204), new Color(51, 204, 255));
        loginButton.setBounds(70, 130, 260, 45);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        loginButton.addActionListener(e -> {
            frame.dispose();
            new LoginView();
        });
        gradientPanel.add(loginButton);

        registerButton = new DesignButton("REGISTER", new Color(0, 153, 204), new Color(51, 204, 255));
        registerButton.setBounds(70, 185, 260, 45);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        registerButton.addActionListener(e -> {
            frame.dispose();
            new RegisterView();
        });
        gradientPanel.add(registerButton);

        exitButton = new DesignButton("Exit", new Color(0, 153, 204), new Color(51, 204, 255));
        exitButton.setBounds(70, 240, 260, 45);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        exitButton.addActionListener(e -> System.exit(0));
        gradientPanel.add(exitButton);

        frame.add(gradientPanel);
        frame.setVisible(true);
    }
}