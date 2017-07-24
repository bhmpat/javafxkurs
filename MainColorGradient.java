package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class MainColorGradient extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			int red = 50;
			int green = 100;
			int blue = 50;
			
			Rectangle rec = new Rectangle(50, 50, 300, 300);
			//Circle c = new Circle(200, 200, 150);
			//rec.setFill(Color.rgb(red, green, blue, 0.5));
			//rec.setFill(Color.hsb(200, 1.0, 1.0, 1.0));
			//rec.setFill(Color.web("#000000"));
			
			Stop[] stops = new Stop[] {new Stop(0, Color.BLUE), new Stop(1, Color.RED), new Stop(.5, Color.WHITE)};
			//je nachdem, wie 0 und 1 verteilt sind, verändert sich die Fließrichtung des Gradient
			LinearGradient lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
			
			rec.setFill(lg);
			//c.setFill(lg);
			
			root.getChildren().addAll(rec);
			//root.getChildren().addAll(c);
			
			primaryStage.setScene(new Scene(root, 400, 400));
			primaryStage.setTitle("Gradient");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}