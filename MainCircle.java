package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class MainCircle extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			Circle kreis = new Circle(110, 55, 12, Color.BLACK);
			Arc arc = new Arc();
			arc.setCenterX(100.0f);
			arc.setCenterY(100.0f);
			arc.setRadiusX(75.0f);
			arc.setRadiusY(75.0f);
			arc.setStartAngle(45.0f);
			arc.setLength(270.0f);
			arc.setType(ArcType.ROUND);
			arc.setFill(Color.YELLOW);
			
			root.getChildren().addAll(arc, kreis);
			
			primaryStage.setScene(new Scene(root, 200, 200));
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