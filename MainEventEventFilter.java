package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainEventEventFilter extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			Scene scene = new Scene(root, 400, 400);
			
			Button button = new Button("Hallo Welt");
			Label mouseLabel = new Label("Verwende den Button");
			
			button.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					mouseLabel.setText("Maus geklickt");
					
				}
			});
			
			button.setOnMouseEntered(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					mouseLabel.setText("Maus entered");
					
				}
			});
			
			button.setOnMouseExited(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					mouseLabel.setText("Maus exited");
					
				}
			});
			
			TextField textfield = new TextField();
			textfield.setPromptText("Schreibe hier");
			Label textLabel = new Label("Schreibe");
			
			textfield.setOnKeyPressed(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					textLabel.setText("Taste gedrückt: "+ event.getText());
					
				}
			});
			
			textfield.setOnKeyReleased(new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					textLabel.setText("Taste losgelassen: "+ event.getText());
					
				}
			});
			
			root.getChildren().addAll(button, mouseLabel, textfield, textLabel);
			GridPane.setConstraints(button, 0, 0);
			GridPane.setConstraints(mouseLabel, 1, 0);
			GridPane.setConstraints(textfield, 0, 1);
			GridPane.setConstraints(textLabel, 1, 1);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Event(Filters)");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}