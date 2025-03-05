package ui;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Procesador de Imágenes");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());

            ImagePanel imagePanel = new ImagePanel();
            frame.add(imagePanel, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            frame.add(buttonPanel, BorderLayout.SOUTH);

            JButton loadButton = new JButton("Cargar Imagen");
            JButton grayscaleButton = new JButton("Convertir a Escala de Grises");
            JButton extractRedButton = new JButton("Extraer Rojo");
            JButton extractGreenButton = new JButton("Extraer Verde");
            JButton extractBlueButton = new JButton("Extraer Azul");
            JButton brightenButton = new JButton("Aumentar Brillo");
            JButton darkenButton = new JButton("Disminuir Brillo");
            JButton increaseContrastButton = new JButton("Aumentar Contraste");
            JButton decreaseContrastButton = new JButton("Disminuir Contraste");

            buttonPanel.add(loadButton);
            buttonPanel.add(grayscaleButton);
            buttonPanel.add(extractRedButton);
            buttonPanel.add(extractGreenButton);
            buttonPanel.add(extractBlueButton);
            buttonPanel.add(brightenButton);
            buttonPanel.add(darkenButton);
            buttonPanel.add(increaseContrastButton);
            buttonPanel.add(decreaseContrastButton);

            loadButton.addActionListener(e -> imagePanel.loadImage());
            grayscaleButton.addActionListener(e -> imagePanel.convertToGrayscale());
            extractRedButton.addActionListener(e -> imagePanel.extractChannel('R'));
            extractGreenButton.addActionListener(e -> imagePanel.extractChannel('G'));
            extractBlueButton.addActionListener(e -> imagePanel.extractChannel('B'));
            brightenButton.addActionListener(e -> imagePanel.adjustBrightness(20));
            darkenButton.addActionListener(e -> imagePanel.adjustBrightness(-20));
            increaseContrastButton.addActionListener(e -> imagePanel.adjustContrast(1.2f));
            decreaseContrastButton.addActionListener(e -> imagePanel.adjustContrast(0.8f));

            frame.setVisible(true);
        });
    }
}
