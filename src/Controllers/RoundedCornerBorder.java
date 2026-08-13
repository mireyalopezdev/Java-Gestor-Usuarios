package Controllers;


import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;


public class RoundedCornerBorder extends AbstractBorder {
    private final int radius;
    private final Color borderColor;

    public RoundedCornerBorder(int radius, Color borderColor) {
        this.radius = radius;
        this.borderColor = borderColor;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(5, 5, 5, 5);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(borderColor);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(new RoundRectangle2D.Float(x, y, width - 1, height - 1, radius, radius));
        g2d.dispose();
    }

}
    
