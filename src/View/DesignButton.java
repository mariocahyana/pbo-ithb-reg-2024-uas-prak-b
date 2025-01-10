package View;

import javax.swing.*;
import java.awt.*;

public class DesignButton extends JButton {
    private Color color1;
    private Color color2;

    public DesignButton(String text, Color color1, Color color2) {
        super(text);
        this.color1 = color1;
        this.color2 = color2;
        setForeground(Color.WHITE);
        setFont(new Font("SansSerif", Font.BOLD, 14));
        setBorderPainted(false);
        setFocusPainted(false);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        super.paintComponent(g);
    }
}
