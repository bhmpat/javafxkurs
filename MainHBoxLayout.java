package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class MainHBoxLayout extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			HBox hb = new HBox();
			hb.setPadding(new Insets(10, 10, 10, 10));
			hb.setSpacing(10);
			
			Button b = new Button("mehr");
			
			hb.getChildren().add(b);
			
			b.setOnAction(e -> {
				Button newb = new Button("neu");
				hb.getChildren().add(newb);
			});
			
			Scene scene = new Scene(hb, 300, 300);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("HBox");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}