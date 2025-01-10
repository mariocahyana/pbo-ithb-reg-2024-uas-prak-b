package View;

import javax.swing.*;

import Model.Model_class.CustomerCheckSession;

import java.awt.*;

public class CustomerMenu {
    private JFrame frame;
    private DesignButton addTrans, addDTrans, viewHistoryButton, viewDHistoryButton, logoutButton;

    public CustomerMenu() {
        showMainMenu();
    }

    public void showMainMenu() {
        frame = new JFrame("Customer Menu");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DesignPanel gradientPanel = new DesignPanel(new Color(0, 102, 204), new Color(102, 204, 255));
        gradientPanel.setLayout(null);

        String username = CustomerCheckSession.getInstance().getCustomer().getName();
        JLabel titleLabel = new JLabel("Welcome, " + username + "!");
        titleLabel.setBounds(0, 20, 500, 40);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gradientPanel.add(titleLabel);

        addTrans = new DesignButton("ADD TRANSACTION", new Color(0, 153, 204), new Color(51, 204, 255));
        addTrans.setBounds(150, 80, 200, 40);
        addTrans.setFont(new Font("SansSerif", Font.BOLD, 12));
        addTrans.addActionListener(e -> {
            frame.dispose();
            new AddTransaksiView();
        });
        gradientPanel.add(addTrans);

        addDTrans = new DesignButton("ADD TRANSACTION DETAIL", new Color(0, 153, 204), new Color(51, 204, 255));
        addDTrans.setBounds(150, 130, 200, 40);
        addDTrans.setFont(new Font("SansSerif", Font.BOLD, 12));
        addDTrans.addActionListener(e -> {
            frame.dispose();
            new AddTransaksiDetailView();
        });
        gradientPanel.add(addDTrans);

        viewHistoryButton = new DesignButton("VIEW HISTORY", new Color(0, 153, 204), new Color(51, 204, 255));
        viewHistoryButton.setBounds(150, 180, 200, 40);
        viewHistoryButton.setFont(new Font("SansSerif", Font.BOLD, 12));
        viewHistoryButton.addActionListener(e -> {
            frame.dispose();
            new ViewHistoryView();
        });
        gradientPanel.add(viewHistoryButton);

        viewDHistoryButton = new DesignButton("VIEW HISTORY DETAIL", new Color(0, 153, 204), new Color(51, 204, 255));
        viewDHistoryButton.setBounds(150, 230, 200, 40);
        viewDHistoryButton.setFont(new Font("SansSerif", Font.BOLD, 12));
        viewDHistoryButton.addActionListener(e -> {
            frame.dispose();
            new ViewHistoryDetailView();
        });
        gradientPanel.add(viewDHistoryButton);

        logoutButton = new DesignButton("LOGOUT", new Color(0, 153, 204), new Color(51, 204, 255));
        logoutButton.setBounds(150, 280, 200, 40);
        logoutButton.setFont(new Font("SansSerif", Font.BOLD, 12));
        logoutButton.addActionListener(e -> {
            CustomerCheckSession.getInstance().logout();
            frame.dispose();
            new MainMenu();
        });
        gradientPanel.add(logoutButton);
        

        frame.add(gradientPanel);
        frame.setVisible(true);
    }
}
