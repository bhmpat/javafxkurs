package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;


public class MainLineHouse extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Group g = new Group();
			Canvas c = new Canvas(300, 300);
			
			GraphicsContext gc = c.getGraphicsContext2D();
			
			gc.strokeLine(100, 300, 300, 300);
			gc.strokeLine(100, 300, 100, 150);
			gc.strokeLine(100, 150, 300, 150);
			gc.strokeLine(300, 150, 300, 300);
			gc.strokeLine(100, 150, 200, 50);
			gc.strokeLine(200, 50, 300, 150);
			
			g.getChildren().addAll(c);
			
			primaryStage.setScene(new Scene(g));
			primaryStage.setTitle("Line");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}