package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class MainColorPicker extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10,10,10,10));
			grid.setVgap(10);
			grid.setHgap(10);
			
			ColorPicker color = new ColorPicker();
			
			Rectangle r = new Rectangle(200, 200);
			
			color.setOnAction((ActionEvent t) -> {
				r.setFill(color.getValue());
			});
			
			grid.getChildren().addAll(color, r);
			GridPane.setConstraints(color, 0, 0);
			GridPane.setConstraints(r, 0, 1);
			
			Scene scene = new Scene(grid, 400, 250);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

