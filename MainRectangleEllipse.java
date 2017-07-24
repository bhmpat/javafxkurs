package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class MainRectangleEllipse extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			Rectangle re = new Rectangle(100, 100, 200, 200);
			re.setArcHeight(25); //Abgerundete Ecken
			re.setArcWidth(25);	//Abgerundete Ecken
			
			Ellipse el = new Ellipse();
			el.setCenterX(150);
			el.setCenterY(150);
			el.setRadiusX(140);
			el.setRadiusY(70);
			
			root.getChildren().addAll(re, el);
			
			primaryStage.setScene(new Scene(root, 400, 400));
			primaryStage.setTitle("Rectangle");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}