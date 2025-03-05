package ui;

import processing.ImageProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImagePanel extends JPanel {
    private BufferedImage image;

    public void loadImage() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                image = ImageIO.read(file);
                repaint();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void convertToGrayscale() {
        if (image != null) {
            image = ImageProcessor.toGrayscale(image);
            repaint();
        }
    }

    public void extractChannel(char channel) {
        if (image != null) {
            image = ImageProcessor.extractChannel(image, channel);
            repaint();
        }
    }

    public void adjustBrightness(int value) {
        if (image != null) {
            image = ImageProcessor.adjustBrightness(image, value);
            repaint();
        }
    }

    public void adjustContrast(float factor) {
        if (image != null) {
            image = ImageProcessor.adjustContrast(image, factor);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}
