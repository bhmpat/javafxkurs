package application;

import java.io.File;
import java.io.FileWriter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class MainFileChooser extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10,10,10,10));
			grid.setVgap(10);
			grid.setHgap(10);
			
			TextArea txta = new TextArea();
			
			FileChooser filech = new FileChooser();
			filech.setTitle("Datei wählen");
			filech.setInitialDirectory(new File(System.getProperty("user.home")));
			
			FileChooser filesave = new FileChooser();
			filesave.setTitle("Datei speichern");
			filesave.setInitialDirectory(new File(System.getProperty("user.home")));
			
			filech.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("All Images", "*.*"),
					new FileChooser.ExtensionFilter("BMP", "*.bmp"),
					new FileChooser.ExtensionFilter("JPG", "*.jpg"),
					new FileChooser.ExtensionFilter("PNG", "*.png")
					);
			
			filesave.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("All Images", "*.*"),
					new FileChooser.ExtensionFilter("BMP", "*.bmp"),
					new FileChooser.ExtensionFilter("JPG", "*.jpg"),
					new FileChooser.ExtensionFilter("PNG", "*.png"),
					new FileChooser.ExtensionFilter("Text", "*.txt")
					);
			
			Label label = new Label("Wähle die gewünschte Datei!");
			Button btn = new Button("Auswählen");
			Label label2 = new Label("Speichere deine Datei!");
			Button btn2 = new Button("Speichern");
			
			btn.setOnAction(e -> {
				filech.showOpenDialog(primaryStage);
			});
			
			btn2.setOnAction(e -> {
				File file = filesave.showSaveDialog(primaryStage);
				System.out.println(file);
				
				try {
					FileWriter fw = new FileWriter(file);
					fw.write(txta.getText().toString());
					fw.close();
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			
			grid.getChildren().addAll(label, btn, label2, btn2, txta);
			GridPane.setConstraints(txta, 0, 0);
			GridPane.setConstraints(label, 0, 1);
			GridPane.setConstraints(btn, 1, 1);
			GridPane.setConstraints(label2, 0, 2);
			GridPane.setConstraints(btn2, 1, 2);
			
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

