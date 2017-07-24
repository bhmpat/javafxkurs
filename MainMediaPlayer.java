package application;

import java.net.URL;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


public class MainMediaPlayer extends Application{
	
	private ArrayList<Shape> nodes;
	private double mainSceneX, mainSceneY;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			Scene scene = new Scene(root, 200, 100);
			
			URL resource = getClass().getResource("wonders.mp3");
			Media media = new Media(resource.toString());
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			
			Button play = new Button("Play");
			Button pause = new Button("Pause");
			Button stop = new Button("Stop");
			
			Slider volumeSlider = new Slider(0, 1, 1);
			mediaPlayer.volumeProperty().bind(volumeSlider.valueProperty());
			
			Slider rateSlider = new Slider(0, 5, 1);
			mediaPlayer.rateProperty().bind(rateSlider.valueProperty());
			
			Slider balanceSlider = new Slider(-1, 1, 0);
			mediaPlayer.balanceProperty().bind(balanceSlider.valueProperty());
			
			play.setOnAction(e -> {
				mediaPlayer.play();
			});
			
			pause.setOnAction(e -> {
				mediaPlayer.pause();
			});
			
			stop.setOnAction(e -> {
				mediaPlayer.stop();
			});
			
			primaryStage.setOnCloseRequest(windowEvent -> {
				mediaPlayer.stop();
			});
			
			root.getChildren().addAll(play, pause, stop, volumeSlider, rateSlider, balanceSlider);
			
			GridPane.setConstraints(play, 0, 0);
			GridPane.setConstraints(pause, 1, 0);
			GridPane.setConstraints(stop, 2, 0);
			
			GridPane.setConstraints(volumeSlider, 0, 1);
			GridPane.setColumnSpan(volumeSlider, 3);
			GridPane.setConstraints(rateSlider, 1, 2);
			GridPane.setColumnSpan(rateSlider, 3);
			GridPane.setConstraints(balanceSlider, 2, 3);
			GridPane.setColumnSpan(balanceSlider, 3);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Mediaplayer");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}