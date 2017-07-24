package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainLabel extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Image image = new Image(getClass().getResourceAsStream("auSbY.png"));
			Label label = new Label("My Label");
			label.setGraphic(new ImageView(image));
			label.setFont(new Font("Arial", 30));
			label.setTextFill(Color.BLUE);  //bzw. Color.web("#FFFFFF")
			label.setScaleX(1.5);
			label.setScaleY(1.5);
			label.setTranslateX(64);
			label.setTranslateY(20);
			
			Scene scene = new Scene(new Group(label));
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
