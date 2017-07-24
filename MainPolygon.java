package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;


public class MainPolygon extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			Polygon p = new Polygon();
			p.getPoints().addAll(new Double[] {
				0.0, 0.0,
				300.0, 200.0,
				50.0, 300.0,
				100.0, 200.0,
				200.0, 30.0
			});
			
			p.setFill(Color.RED);
			
			Polyline pl = new Polyline();
			pl.getPoints().addAll(new Double[] {
				0.0, 0.0,
				300.0, 200.0,
				50.0, 300.0,
				100.0, 200.0,
				200.0, 30.0,
				0.0, 0.0
			});
			
			root.getChildren().addAll(p, pl);
			
			primaryStage.setScene(new Scene(root, 400, 400));
			primaryStage.setTitle("Polygon");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}