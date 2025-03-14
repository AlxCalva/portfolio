package ui;
import processing.ImageProcessor;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class HistogramPanel extends JPanel {
    private int[] histogram;

    public void setImage(BufferedImage image) {
        this.histogram = ImageProcessor.computeHistogramY(image);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (histogram == null) return;

        int width = getWidth();
        int height = getHeight();
        int max = 0;

        for (int value : histogram) {
            if (value > max) max = value;
        }

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.WHITE);

        for (int i = 0; i < histogram.length; i++) {
            int barHeight = (int) ((double) histogram[i] / max * height);
            g.drawLine(i, height, i, height - barHeight);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(256, 200);
    }
}
