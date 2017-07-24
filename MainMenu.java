package application;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;


public class MainMenu extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(new Group(), 400, 400);
			Group root = (Group) scene.getRoot();
			
			TitledPane tp = new TitledPane("Mein Titel", new Button("Button"));
			tp.setCollapsible(false);
			
			root.getChildren().add(tp);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("BorderPane");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}