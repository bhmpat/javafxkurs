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


public class MainScrollbar extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			ScrollBar scroll = new ScrollBar();
			Image[] bilder = new Image[5];
			ImageView[] pics = new ImageView[5];
			
			VBox vb = new VBox();

			Scene scene = new Scene(root, 250, 100);
			
			scroll.setLayoutX(scene.getWidth() - scroll.getWidth());
			scroll.setMin(0.0);
			scroll.setMax(600.0);
			scroll.setOrientation(Orientation.VERTICAL);
			scroll.setPrefSize(10, 300);
			
			for(int i = 0; i < 5; i++) {
				Image img = bilder[i]= new Image(getClass().getResourceAsStream("bild" + (i+1) + ".jpg"));
				ImageView v = pics[i] = new ImageView(bilder[i]);
				
				v.setFitHeight(64.0);
				v.setFitHeight(64.0);
				
				vb.getChildren().add(v);
			}
			
			scroll.valueProperty().addListener(new ChangeListener<Number>() {

				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					vb.setLayoutY(newValue.doubleValue());
				}
				
			});
			
			root.getChildren().addAll(scroll, vb);
			
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