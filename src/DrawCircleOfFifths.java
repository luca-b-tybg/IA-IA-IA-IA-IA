import javax.swing.*;
import java.awt.*;

public class DrawCircleOfFifths {

    public void drawCircleOfFifths(Graphics2D g2, int centerX, int centerY, int radius) {
        // Key names
        String[] majors = {"C", "G", "D", "A", "E", "B", "F#", "Db", "Ab", "Eb", "Bb", "F"};
        String[] minors = {"Am", "Em", "Bm", "F#m", "C#m", "G#m", "D#m", "Bbm", "Fm", "Cm", "Gm", "Dm"};
        String[] diminished = {"Bdim", "F#dim", "C#dim", "G#dim", "D#dim", "A#dim", "E#dim", "Dbdim", "Abdim", "Ebdim", "Bbdim", "Fdim"};

        int minorRadius = radius - 40;
        int diminishedRadius = minorRadius - 40;

        // Draw circles
        g2.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius); // Major
        g2.drawOval(centerX - minorRadius, centerY - minorRadius, 2 * minorRadius, 2 * minorRadius); // Minor
        g2.drawOval(centerX - diminishedRadius, centerY - diminishedRadius, 2 * diminishedRadius, 2 * diminishedRadius); // Diminished

        // Draw labels
        for (int i = 0; i < 12; i++) {
            double angle = Math.toRadians((360 / 12) * i - 90);

            // Major (outer)
            int xMaj = (int) (centerX + Math.cos(angle) * (radius - 10));
            int yMaj = (int) (centerY + Math.sin(angle) * (radius - 10));
            g2.setColor(Color.BLACK);
            g2.drawString(majors[i], xMaj - 10, yMaj + 5);

            // Minor (middle)
            int xMin = (int) (centerX + Math.cos(angle) * (minorRadius - 10));
            int yMin = (int) (centerY + Math.sin(angle) * (minorRadius - 10));
            g2.setColor(new Color(86, 86, 86, 255)); // Blue for minor
            g2.drawString(minors[i], xMin - 10, yMin + 5);

            // Diminished (inner)
            int xDim = (int) (centerX + Math.cos(angle) * (diminishedRadius - 10));
            int yDim = (int) (centerY + Math.sin(angle) * (diminishedRadius - 10));
            g2.setColor(new Color(147, 147, 147)); // Red for diminished
            g2.drawString(diminished[i], xDim - 15, yDim + 5);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle of Fifths");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        DrawCircleOfFifths drawer = new DrawCircleOfFifths();

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawer.drawCircleOfFifths((Graphics2D) g, getWidth() / 2, getHeight() / 2, Math.min(getWidth(), getHeight()) / 2 - 40);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
}
