import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {
    private DrawCircleOfFifths drawer = new DrawCircleOfFifths();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawer.drawCircleOfFifths((Graphics2D) g, getWidth() / 2, getHeight() / 2, Math.min(getWidth(), getHeight()) / 2 - 40);
    }
}
