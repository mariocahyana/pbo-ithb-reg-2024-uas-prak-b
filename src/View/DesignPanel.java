package View;

import javax.swing.*;
import java.awt.*;

public class DesignPanel extends JPanel {
    private Color color1;
    private Color color2;

    public DesignPanel(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
