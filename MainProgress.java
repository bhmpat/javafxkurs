package application;



import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class MainProgress extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10,10,10,10));
			grid.setVgap(10);
			grid.setHgap(10);
			
			Slider slider = new Slider();
			slider.setMin(0.0);
			slider.setMax(1);
			
			ProgressBar pb = new ProgressBar(0.0);
			ProgressIndicator pi = new ProgressIndicator(0.0);
			
			slider.valueProperty().addListener(new ChangeListener<Number>() {

				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					pb.setProgress(newValue.doubleValue());
					pi.setProgress(newValue.doubleValue());
				}
			});
			
			grid.getChildren().addAll(pb, pi, slider);
			GridPane.setConstraints(pb, 1, 0);
			GridPane.setConstraints(pi, 2, 0);
			GridPane.setConstraints(slider, 0, 0);
			
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

