package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class MainEventHandler extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			Scene scene = new Scene(root, 400, 400);
			
			TextField txtf1 = new TextField();
			txtf1.setPromptText("Schreibe hier");
			TextField txtf2 = new TextField();
			txtf2.setPromptText("Schreibe hier");
			
			EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
				@Override
				public void handle(KeyEvent event) {
					System.out.println("Taste gedrückt!" + event.getCode());
					event.consume();
				}
			};
			
			txtf1.setOnKeyPressed(keyEventHandler);
			txtf2.setOnKeyPressed(keyEventHandler);
			
			root.getChildren().addAll(txtf1, txtf2);
			GridPane.setConstraints(txtf1, 0, 0);
			GridPane.setConstraints(txtf2, 0, 1);
			
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