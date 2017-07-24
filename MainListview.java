package application;

import java.io.File;
import java.io.FileWriter;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class MainListview extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10,10,10,10));
			grid.setVgap(10);
			grid.setHgap(10);
			
			Label label = new Label("Bitte wähle eines der Tiere");
			
			ListView<String> lv = new ListView<String>();
			ObservableList<String> items = FXCollections.observableArrayList(
					"Hund", "Katze", "Maus", "Vogel"
					);
			lv.setItems(items);
			lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			lv.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					label.setText("Angewählt: "+ newValue);
				}
			});
			
			
			grid.getChildren().addAll(label, lv);
			GridPane.setConstraints(lv, 0, 0);
			GridPane.setConstraints(label, 0, 1);
			
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

