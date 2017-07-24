package application;



import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;


public class Maindatepicker extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10,10,10,10));
			grid.setVgap(10);
			grid.setHgap(10);
			
			DatePicker startdate = new DatePicker(LocalDate.now());
			DatePicker endate = new DatePicker();
			
			Label startlabel = new Label("Startdatum: ");
			Label endlabel = new Label("Enddatum: ");
			
			Callback<DatePicker, DateCell> DayCellFactory = new Callback<DatePicker, DateCell>(){

				@Override
				public DateCell call(DatePicker param) {
					return new DateCell() {
						@Override
						public void updateItem(LocalDate item, boolean empty) {
							super.updateItem(item, empty);
							
							long days = ChronoUnit.DAYS.between(startdate.getValue(), item);
							setTooltip(new Tooltip("Du bleibst "+days+" Tage"));
						}
					};
				}
			};
			
			startdate.setDayCellFactory(DayCellFactory);
			
			grid.getChildren().addAll(startdate, startlabel, endate, endlabel);
			GridPane.setConstraints(startdate, 1, 0);
			GridPane.setConstraints(startlabel, 0, 0);
			GridPane.setConstraints(endate, 1, 1);
			GridPane.setConstraints(endlabel, 0, 1);
			
			Scene scene = new Scene(grid, 400, 150);
			
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

