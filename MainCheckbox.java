package application;



import java.awt.Checkbox;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainCheckbox extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gpane = new GridPane();
			gpane.setPadding(new Insets(10,10,10,10));
			gpane.setVgap(10);
			gpane.setHgap(10);
			
			Label pzalab = new Label("Was soll auf die Pizza?");
			
			String[] names = new String[] {"Gouda", "Mozarella", "Schinken", "Pilze"};
			Image[] imgs = new Image[names.length];
			ImageView[] imgvs = new ImageView[names.length];
			CheckBox[] boxes = new CheckBox[names.length];
			
			for(int i = 0; i < names.length; i++) {
				final Image image = new Image(getClass().getResourceAsStream(names[i] + ".jpg"));
				final ImageView imgview = imgvs[i] = new ImageView();
				final CheckBox chkbx = boxes[i] = new CheckBox(names[i]);
				
				chkbx.selectedProperty().addListener(new ChangeListener<Boolean>() {

					@Override
					public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue,
							Boolean newValue) {
						imgview.setImage(newValue ? image : null);
					}
					
				});
				
				GridPane.setConstraints(chkbx, i+1, 1);
				GridPane.setConstraints(imgview, i+1, 2);
				gpane.getChildren().add(chkbx);
				gpane.getChildren().add(imgview);
				
				chkbx.setStyle("-fx-border-color: blue;"
						+ "-fx-font-size: 18;"
						+ "-fx-border-style: solid;"
						+ "-fx-border-radius: 5;"
						+ "-fx-border-insets: -5;");
			}
			
			Image pzaimg = new Image(getClass().getResourceAsStream("pizza.png"));
			ImageView pzaview = new ImageView();
			
			pzaview.setImage(pzaimg);
			
			GridPane.setConstraints(pzalab, 0, 0);
			GridPane.setConstraints(pzaview, 0, 1);
			GridPane.setColumnSpan(pzalab, 4);
			gpane.getChildren().add(pzalab);
			gpane.getChildren().add(pzaview);
			
			Scene scene = new Scene(gpane, 800, 400);
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

