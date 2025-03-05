package processing;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageProcessor {

    public static BufferedImage toGrayscale(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(img.getRGB(x, y));
                int gray = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                result.setRGB(x, y, new Color(gray, gray, gray).getRGB());
            }
        }
        return result;
    }

    public static BufferedImage extractChannel(BufferedImage img, char channel) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(img.getRGB(x, y));
                int r = (channel == 'R') ? color.getRed() : 0;
                int g = (channel == 'G') ? color.getGreen() : 0;
                int b = (channel == 'B') ? color.getBlue() : 0;
                result.setRGB(x, y, new Color(r, g, b).getRGB());
            }
        }
        return result;
    }

    public static BufferedImage adjustBrightness(BufferedImage img, int value) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(img.getRGB(x, y));

                int r = Math.min(255, Math.max(0, color.getRed() + value));
                int g = Math.min(255, Math.max(0, color.getGreen() + value));
                int b = Math.min(255, Math.max(0, color.getBlue() + value));

                result.setRGB(x, y, new Color(r, g, b).getRGB());
            }
        }
        return result;
    }

    public static BufferedImage adjustContrast(BufferedImage img, float factor) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = new Color(img.getRGB(x, y));

                int r = Math.min(255, Math.max(0, (int) ((color.getRed() - 128) * factor + 128)));
                int g = Math.min(255, Math.max(0, (int) ((color.getGreen() - 128) * factor + 128)));
                int b = Math.min(255, Math.max(0, (int) ((color.getBlue() - 128) * factor + 128)));

                result.setRGB(x, y, new Color(r, g, b).getRGB());
            }
        }
        return result;
    }
}
