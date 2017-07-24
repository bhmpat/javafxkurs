package application;



import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainScrollPane extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			Image img = new Image(getClass().getResourceAsStream("flsh.png"));
			ScrollPane sp = new ScrollPane();
			sp.setContent(new ImageView(img));
			
			//Aktiviert oder deaktiviert horizontales Scrolling
			//sp.setHbarPolicy(ScrollBarPolicy.NEVER);
			
			sp.vvalueProperty().addListener(new ChangeListener<Number>() {

				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					System.out.println("Alter Wert: "+oldValue.toString() + " neuer Wert: "+newValue.toString());
				}
				
			});
			
			Scene scene = new Scene(sp, 300, 300);
			
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

