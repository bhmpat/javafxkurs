package application;



import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainCombobox extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane gpane = new GridPane();
			gpane.setPadding(new Insets(10,10,10,10));
			gpane.setVgap(10);
			gpane.setHgap(10);

			ComboBox cbox = new ComboBox(FXCollections.observableArrayList("Option1", "Option2", "Option3"));
			cbox.getItems().addAll("a", "b");

			cbox.setEditable(true);

			//gibt ausgewählten wert zurück
			cbox.getValue();

			GridPane.setConstraints(cbox,  0,  0);
			gpane.getChildren().addAll(cbox);

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