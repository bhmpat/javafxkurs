package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainTextField extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gpane = new GridPane();
			gpane.setPadding(new Insets(10,10,10,10));
			gpane.setVgap(10);
			gpane.setHgap(10);
			
			Label name = new Label("Name: ");
			TextField namefeld = new TextField();
			namefeld.setPromptText("Trage deinen Namen ein");
			
			Label alter = new Label("Alter: ");
			TextField alterfeld = new TextField();
			alterfeld.setPromptText("Trage dein Alter ein");
			
			Label pass = new Label("Alter: ");
			PasswordField passfield = new PasswordField();
			passfield.setPromptText("Trage dein Passwort ein");
			
			Label eval = new Label("");
			
			TextArea txtarea = new TextArea();
			txtarea.setPrefRowCount(12);
			txtarea.setPrefColumnCount(120);
			txtarea.setWrapText(true);
			txtarea.setText("Hallo");
			
			Button absenden = new Button("Absenden");
			absenden.setOnAction(e -> {
				if(namefeld.getText() != null && !(namefeld.getText().isEmpty()) &&
						alterfeld.getText() != null && !(alterfeld.getText().isEmpty())) {
					System.out.println("Name ist: "+ namefeld.getText().toString() + ", Alter ist: " + alterfeld.getText().toString());
				}else {
					System.out.println("Bitte beide Felder ausfüllen");
				}
				
				if(passfield.getText().equals("mypass")) {
					eval.setText("Passwort korrekt");
				}else {
					eval.setText("Passwort falsch");
				}
			});
			
			GridPane.setConstraints(name, 0, 0);
			GridPane.setConstraints(namefeld, 1, 0);
			GridPane.setConstraints(alter, 0, 1);
			GridPane.setConstraints(alterfeld, 1, 1);
			GridPane.setConstraints(pass, 0, 2);
			GridPane.setConstraints(passfield, 1, 2);
			GridPane.setConstraints(eval, 0, 3);
			GridPane.setConstraints(txtarea, 0, 4);
			GridPane.setConstraints(absenden, 0, 5);
			GridPane.setColumnSpan(eval, 2);
			GridPane.setColumnSpan(txtarea, 2);
			
			gpane.getChildren().addAll(name, namefeld, alter, alterfeld, absenden, 
					pass, passfield, eval, txtarea);
			
			
			Scene scene = new Scene(gpane, 400, 400);
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

