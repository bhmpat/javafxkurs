package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainFlowPaneLayout extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			FlowPane fp = new FlowPane(Orientation.VERTICAL, 10, 10);
			fp.setPrefWrapLength(400);
			
			for(int i = 0; i < 20; i++) {
				Button b = new Button("Button");
				fp.getChildren().add(b);
			}
			
			Scene scene = new Scene(fp, 300, 300);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("FlowPane");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}