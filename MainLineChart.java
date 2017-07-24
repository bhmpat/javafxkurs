package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class MainLineChart extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(new Group());
			
			CategoryAxis xAxis = new CategoryAxis();
			NumberAxis yAxis = new NumberAxis();
			
			xAxis.setLabel("Jahr");
			
			LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
			lineChart.setTitle("Verbreitung Cartoons");
			
			XYChart.Series<String, Number> series1 = new XYChart.Series<>();
			series1.setName("Anzahl neuer Angry Birds");
			series1.getData().add(new XYChart.Data<String, Number>("2011", 15));
			series1.getData().add(new XYChart.Data<String, Number>("2012", 25));
			series1.getData().add(new XYChart.Data<String, Number>("2013", 13));
			series1.getData().add(new XYChart.Data<String, Number>("2014", 12));
			series1.getData().add(new XYChart.Data<String, Number>("2015", 17));
			
			XYChart.Series<String, Number> series2 = new XYChart.Series<>();
			series2.setName("Anzahl neuer Minions");
			series2.getData().add(new XYChart.Data<String, Number>("2011", 30));
			series2.getData().add(new XYChart.Data<String, Number>("2012", 22));
			series2.getData().add(new XYChart.Data<String, Number>("2013", 18));
			series2.getData().add(new XYChart.Data<String, Number>("2014", 27));
			series2.getData().add(new XYChart.Data<String, Number>("2015", 30));
			
			lineChart.getData().add(series1);
			lineChart.getData().add(series2);
			
			((Group)scene.getRoot()).getChildren().addAll(lineChart);
			
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