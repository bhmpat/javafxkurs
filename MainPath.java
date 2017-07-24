package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;


public class MainPath extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			QuadCurveTo quadTo = new QuadCurveTo();
			quadTo.setControlX(200.0f);
			quadTo.setControlY(200.0f);
			quadTo.setX(100.0f);
			quadTo.setY(300.0f);
			
			CubicCurveTo cubicTo = new CubicCurveTo();
			cubicTo.setControlX1(0.0f);
			cubicTo.setControlY1(0.0f);
			cubicTo.setControlX2(100.0f);
			cubicTo.setControlY2(100.0f);
			cubicTo.setX(100.0f);
			cubicTo.setY(50.0f);
			
			Path path = new Path();
			path.getElements().add(new MoveTo(100, 100));
			path.getElements().add(cubicTo);
			path.getElements().add(new VLineTo(500));
			path.getElements().add(new ClosePath());
			path.setFill(Color.BLUE);
			path.setStrokeWidth(25);
			
			root.getChildren().addAll(path);
			
			primaryStage.setScene(new Scene(root, 400, 400));
			primaryStage.setTitle("Path");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}