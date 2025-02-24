package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JButton loadImageButton;
    private JLabel imageLabel;

    public MainWindow(){
        setTitle("Carga Modificación y visualización de imágenes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        loadImageButton = new JButton("Cargar Imagen");
        imageLabel = new JLabel();
        JPanel topPanel = new JPanel();
        topPanel.add(loadImageButton);
        add(topPanel, BorderLayout.NORTH);

        add(imageLabel, BorderLayout.CENTER);
        loadImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openImage();

            }
        });

        setVisible(true);
    }
    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION){
            ImageIcon image = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
            imageLabel.setIcon(image);
        }
    }
    public static void main(String[] args) {
        new MainWindow();
    }
}