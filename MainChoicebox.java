package application;



import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainChoicebox extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gpane = new GridPane();
			gpane.setPadding(new Insets(10,10,10,10));
			gpane.setVgap(10);
			gpane.setHgap(10);
			
			ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList("Norden", "Osten", "Süden", "Westen"));
			String[] verbindungen = new String[] {"Dänemark", "Polen", "Schweiz", "Niederlande"};
			
			Label label = new Label("");
			
			cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					label.setText(verbindungen[newValue.intValue()]);
				}
			});
			
			cb.setTooltip(new Tooltip("Wähle die Himmelsrichtung"));
			
			GridPane.setConstraints(cb, 0, 0);
			GridPane.setConstraints(label, 1, 0);
			gpane.getChildren().addAll(cb, label);
			
			Scene scene = new Scene(gpane, 250, 100);
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

