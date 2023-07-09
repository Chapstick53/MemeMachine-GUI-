package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private ImageView gifView;
    @FXML
    private StackPane gifStackPane;

    private final List<String> gifPaths = new ArrayList<>();
    private int currentIndex = 0;

    @FXML
    public void initialize() {
        // Add the paths or URLs of your GIFs to the list
        gifPaths.add("/gifs/400new.gif");
        gifPaths.add("/gifs/eif.com-resize.gif");
        gifPaths.add("/gifs/ezgif.com-resize.gif");
        gifPaths.add("/gifs/ezgif.com-resize (1).gif");
        gifPaths.add("/gifs/ezgif.com-resize (2).gif");
        gifPaths.add("/gifs/ezgif.com-resize (3).gif");
        gifPaths.add("/gifs/ezgif.com-resize (4).gif");
        // Add more GIF paths as needed

        // Load and display the first GIF
        displayCurrentGif();
    }

    private void displayCurrentGif() {
        // Load the GIF based on the current index
        Image gifImage = new Image(getClass().getResourceAsStream(gifPaths.get(currentIndex)));
        gifView.setImage(gifImage);
        gifView.setFitWidth(400);
        gifView.setFitHeight(400);
        gifView.setPreserveRatio(true);

        // Center the ImageView within the StackPane
        gifStackPane.getChildren().setAll(gifView);
    }

    @FXML
    protected void onHelloButtonClick() {
        currentIndex++;
        if (currentIndex >= gifPaths.size()) {
            currentIndex = 0; // Loop back to the first GIF
        }
        displayCurrentGif();
    }
}
