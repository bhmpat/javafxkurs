package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MainPieChart extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(new Group());
			HBox root = new HBox();
			
			ObservableList pieChartData = FXCollections.observableArrayList(
					new PieChart.Data("Java", 25),
					new PieChart.Data("Swift", 15),
					new PieChart.Data("PHP", 10),
					new PieChart.Data("C#", 20),
					new PieChart.Data("Andere", 30)
					);
			
			PieChart pie = new PieChart(pieChartData);
			pie.setTitle("Verbreitung Programmiersprachen 07.2017");
			
			Label details = new Label();
			details.setTextFill(Color.BLACK);
			details.setStyle("-fx-font: 20 arial;");
			
			for(final PieChart.Data data : pie.getData()) {
				data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
					details.setTranslateX(event.getSceneX());
					details.setTranslateY(event.getSceneY());
					details.setText(String.valueOf(data.getPieValue()) + "%");
				});
			}
			
			((Group)scene.getRoot()).getChildren().addAll(pie, details);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Pie Chart");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}