package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
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


public class MainBarChart extends Application{
	
	final static String itemA = "Android";
	final static String itemB = "iOS";
	final static String itemC = "Win10";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(new Group());
			
			CategoryAxis xAxis = new CategoryAxis();
			NumberAxis yAxis = new NumberAxis();
			
			BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
			barChart.setTitle("Verbreitung mobiler OS");
			xAxis.setLabel("Betriebssystem");
			yAxis.setLabel("Verbreitung in %");
			
			XYChart.Series series1 = new XYChart.Series();
			series1.setName("2014");
			series1.getData().add(new XYChart.Data(itemA, 80));
			series1.getData().add(new XYChart.Data(itemB, 15));
			series1.getData().add(new XYChart.Data(itemC, 5));
			
			XYChart.Series series2 = new XYChart.Series();
			series2.setName("2015");
			series2.getData().add(new XYChart.Data(itemA, 83));
			series2.getData().add(new XYChart.Data(itemB, 13));
			series2.getData().add(new XYChart.Data(itemC, 4));
			
			barChart.getData().addAll(series1, series2);
			
			((Group)scene.getRoot()).getChildren().addAll(barChart);
			
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