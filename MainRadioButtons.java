package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class MainRadioButtons extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gpane = new GridPane();
			gpane.setPadding(new Insets(10,10,10,10));
			gpane.setVgap(10);
			gpane.setHgap(10);
			
			RadioButton rad1 = new RadioButton();
			rad1.setText("Play");
			RadioButton rad2 = new RadioButton();
			rad2.setText("Pause");
			RadioButton rad3 = new RadioButton();
			rad3.setText("Stop");
			
			ToggleGroup group = new ToggleGroup();
			
			rad1.setToggleGroup(group);
			rad1.setSelected(true);
			rad2.setToggleGroup(group);
			rad3.setToggleGroup(group);
			
			rad1.setUserData("play.jpg");
			rad2.setUserData("pause.jpg");
			rad3.setUserData("stop.jpg");
			
			ImageView imgview = new ImageView();
			Image img = new Image(getClass().getResourceAsStream(group.getSelectedToggle().
					getUserData().toString()));
			
			imgview.setImage(img);
			imgview.setFitHeight(64.0);
			imgview.setFitWidth(64.0);
			
			group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

				@Override
				public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
					Image img = new Image(getClass().getResourceAsStream(group.getSelectedToggle().
							getUserData().toString()));
					
					imgview.setImage(img);
				}
				
			});
			
			gpane.getChildren().addAll(rad1, rad2, rad3, imgview);
			
			GridPane.setConstraints(rad1, 0, 0);
			GridPane.setConstraints(rad2, 0, 1);
			GridPane.setConstraints(rad3, 0, 2);
			GridPane.setConstraints(imgview, 1, 0);
			GridPane.setRowSpan(imgview, 5);
			
			Scene scene = new Scene(gpane, 200, 150);
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

