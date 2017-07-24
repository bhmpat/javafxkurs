package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainVBoxLayout extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane bp = new BorderPane();
			
			VBox vb = new VBox();
			vb.setPadding(new Insets(10, 10, 10, 10));
			vb.setSpacing(10);
			
			Button b = new Button("mehr");
			
			vb.getChildren().add(b);
			
			b.setOnAction(e -> {
				Button newb = new Button("neu");
				vb.getChildren().add(newb);
			});
			
			Scene scene = new Scene(vb, 300, 300);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("VBox");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}