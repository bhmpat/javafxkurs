package application;



import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class MainSlider extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10,10,10,10));
			grid.setVgap(10);
			grid.setHgap(10);
			
			Rectangle rec = new Rectangle();
			rec.setWidth(200);
			rec.setHeight(200);
			
			Label[] labels = new Label[3];
			Slider[] sliders = new Slider[3];
			
			for(int i = 0; i < 3; i++) {
				sliders[i] = new Slider();
				sliders[i].setMin(0.0);
				sliders[i].setMax(255.0);
				sliders[i].setValue(40.0);
				sliders[i].setShowTickMarks(true);
				sliders[i].setMinorTickCount(5);
				sliders[i].setMajorTickUnit(50);
				sliders[i].setBlockIncrement(10);
				sliders[i].setShowTickLabels(true);
				
				labels[i] = new Label();
				
				grid.getChildren().add(sliders[i]);
				GridPane.setConstraints(sliders[i], 0, i);
				
				grid.getChildren().add(labels[i]);
				GridPane.setConstraints(labels[i], 1, i);
			}
			
			labels[0].setText("Rot");
			labels[1].setText("Grün");
			labels[2].setText("Blau");
			
			rec.setFill(Color.rgb((int)sliders[0].getValue(), (int)sliders[1].getValue(), (int)sliders[2].getValue()));
			
			for(int i = 0; i < 3; i++) {
				sliders[i].valueProperty().addListener(new ChangeListener<Number>() {

					@Override
					public void changed(ObservableValue<? extends Number> observable, Number oldValue,
							Number newValue) {
						rec.setFill(Color.rgb((int)sliders[0].getValue(), (int)sliders[1].getValue(), (int)sliders[2].getValue()));
					}
				});
			}
			
			grid.getChildren().add(rec);
			grid.setConstraints(rec, 0, 3);
			
			Scene scene = new Scene(grid, 300, 300);
			
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

