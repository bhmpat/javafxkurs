package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;


public class MainLine extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			HBox hb = new HBox();
			Scene scene = new Scene(hb, 400, 400);
			
			Line line = new Line(0, 0, 200, 200);
			line.setStroke(Color.RED);
			line.setStrokeWidth(25.0);
			line.getStrokeDashArray().addAll(10d, 20d);
			line.setStrokeLineCap(StrokeLineCap.ROUND);
			
			Line line2 = new Line();
			line2.setStartX(100);
			line2.setStartY(100);
			line2.setEndX(200);
			line2.setEndY(400);
			
			hb.getChildren().addAll(line, line2);
			
			primaryStage.setScene(scene);
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