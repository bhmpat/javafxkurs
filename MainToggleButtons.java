package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class MainToggleButtons extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gpane = new GridPane();
			gpane.setPadding(new Insets(10,10,10,10));
			gpane.setVgap(10);
			gpane.setHgap(10);
			
			Label lab = new Label("Welche Augenfarbe hast du?");
			
			ToggleGroup group = new ToggleGroup();
			
			ToggleButton tgl1 = new ToggleButton("Blau");
			tgl1.setToggleGroup(group);
			ToggleButton tgl2 = new ToggleButton("Grün");
			tgl2.setToggleGroup(group);
			ToggleButton tgl3 = new ToggleButton("Braun");
			tgl3.setToggleGroup(group);
			
			Rectangle rec = new Rectangle(180, 50);
			rec.setFill(Color.WHITE);
			
			tgl1.setUserData(Color.BLUE);
			tgl2.setUserData(Color.GREEN);
			tgl3.setUserData(Color.BROWN);
			
			tgl1.setStyle("-fx-base: lightblue");
			tgl2.setStyle("-fx-base: lightgreen");
			tgl3.setStyle("-fx-base: brown");
			
			group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

				@Override
				public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
					if(newValue == null) {
						rec.setFill(Color.WHITE);
					}else {
						rec.setFill( (Paint) group.getSelectedToggle().getUserData());
					}
				}
				
			});
			
			gpane.getChildren().addAll(lab, tgl1, tgl2, tgl3, rec);
			
			GridPane.setConstraints(lab, 0, 0);
			GridPane.setColumnSpan(lab, 3);
			GridPane.setConstraints(tgl1, 0, 1);
			GridPane.setConstraints(tgl2, 1, 1);
			GridPane.setConstraints(tgl3, 2, 1);
			GridPane.setConstraints(rec, 0, 2);
			GridPane.setColumnSpan(rec, 3);
			
			Scene scene = new Scene(gpane, 300, 200);
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

