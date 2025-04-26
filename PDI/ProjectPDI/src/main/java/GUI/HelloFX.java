package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.File;

public class HelloFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        // Creación de items menú "File"
        Menu fileMenu = new Menu("File");
        MenuItem openImage = new MenuItem("Open");
        MenuItem saveImage = new MenuItem("Save image");
        fileMenu.getItems().addAll(openImage, saveImage);

        // Items del sub menú canal
        MenuItem red = new MenuItem("Red");
        MenuItem green = new MenuItem("Green");
        MenuItem blue = new MenuItem("Blue");
        MenuItem gray = new MenuItem("Gray Scale");
        Menu channelSubMenu = new Menu("Channel");
        channelSubMenu.getItems().addAll(red, green, blue, gray);

        // Extract
        Menu extractMenu = new Menu("Extract");
        extractMenu.getItems().addAll(channelSubMenu);

        // Barra principal
        MenuBar mainBar = new MenuBar();
        mainBar.getMenus().addAll(fileMenu, extractMenu);
        mainBar.setStyle("-fx-background-color: #b0b0b0; -fx-text-fill: white;");

        // Layout principal
        BorderPane layout = new BorderPane();
        layout.setTop(mainBar);
        layout.setStyle("-fx-background-color: #2e2e2e;");

        // AnchorPane para contener la imagen
        AnchorPane imageContainer = new AnchorPane();
        layout.setCenter(imageContainer);

        // Configurar el manejador de eventos para "Open"
        openImage.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Image File");

            // Filtro para archivos de imagen
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                    "Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp");
            fileChooser.getExtensionFilters().add(extFilter);

            // Mostrar el diálogo de selección de archivos
            File file = fileChooser.showOpenDialog(stage);

            if (file != null) {
                // Cargar la imagen seleccionada
                Image image = new Image(file.toURI().toString());
                ImageView imageView = new ImageView(image);

                // Configurar el ImageView para escalar con calidad
                imageView.setPreserveRatio(true); // Mantener la relación de aspecto
                imageView.setSmooth(true);       // Suavizado para mejor calidad

                // Establecer un tamaño más pequeño para la imagen
                double maxWidth = 250;  // Ancho máximo deseado
                double maxHeight = 250; // Alto máximo deseado

                // Calcular el tamaño proporcional
                if (image.getWidth() > maxWidth || image.getHeight() > maxHeight) {
                    double ratio = Math.min(maxWidth / image.getWidth(), maxHeight / image.getHeight());
                    imageView.setFitWidth(image.getWidth() * ratio);
                    imageView.setFitHeight(image.getHeight() * ratio);
                } else {
                    // Si la imagen es más pequeña que el tamaño máximo, usar su tamaño original
                    imageView.setFitWidth(image.getWidth());
                    imageView.setFitHeight(image.getHeight());
                }


                // Limpiar el AnchorPane y agregar la imagen
                imageContainer.getChildren().clear();
                imageContainer.getChildren().add(imageView);

                // Anclar la imagen a la esquina superior izquierda
                AnchorPane.setTopAnchor(imageView, 8.0);
                AnchorPane.setLeftAnchor(imageView, 8.0);
            }
        });

        // Escena
        Scene scene = new Scene(layout, 1000, 600);

        // Configurar la ventana
        Image gallery = new Image("icon.png");
        stage.getIcons().add(gallery);
        stage.setTitle("Procesador Digital de Imágenes");
        stage.setFullScreen(false);
        stage.setMinWidth(600);
        stage.setMinHeight(400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}