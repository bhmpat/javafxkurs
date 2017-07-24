package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainLambdaUndSimpleClicks extends Application {

	Stage fenster;
	Scene szene1, szene2;
	Button button1, button2;
	Label label1, label2;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			fenster = primaryStage;
			
			label1 = new Label("Das ist die erste Szene");
			button1 = new Button("Zur 2. Szene wechseln");
			
			//Innere Klasse
			/**button1.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					fenster.setScene(szene2);
					fenster.show();
				}
				
			});**/
			//Oder einfacher und klarer mit Lambda Expressions
			button1.setOnAction(event -> {
					fenster.setScene(szene2);
					fenster.show();
			});
			
			VBox layout1 = new VBox(30);
			layout1.getChildren().addAll(button1, label1);
			
			szene1 = new Scene(layout1, 250, 250);
			
			label2 = new Label("Das ist die zweite Szene");
			button2 = new Button("Zur 1. Szene wechseln");
			button2.setOnAction(event -> {
					fenster.setScene(szene1);
					fenster.show();
			});
			
			VBox layout2 = new VBox(30);
			layout2.getChildren().addAll(button2, label2);
			
			szene2 = new Scene(layout2, 250, 250);
			
			primaryStage.setScene(szene1);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

