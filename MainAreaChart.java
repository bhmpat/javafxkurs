package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class MainAreaChart extends Application{
	
	final static String itemA = "Android";
	final static String itemB = "iOS";
	final static String itemC = "Win10";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(new Group());
			
			NumberAxis xAxis = new NumberAxis(2012, 2015, 1);
			NumberAxis yAxis = new NumberAxis(0, 20, 5);
			
			AreaChart<Number, Number> areaChart = new AreaChart<Number, Number>(xAxis, yAxis);
			areaChart.setTitle("Umsatz/Gewinn");
			xAxis.setLabel("in Jahre");
			yAxis.setLabel("in Mio. €");
			xAxis.setForceZeroInRange(true);
			
			XYChart.Series series1 = new XYChart.Series();
			series1.setName("Umsatz");
			series1.getData().add(new XYChart.Data(2012, 10));
			series1.getData().add(new XYChart.Data(2013, 13));
			series1.getData().add(new XYChart.Data(2014, 16));
			series1.getData().add(new XYChart.Data(2015, 18));
			
			XYChart.Series series2 = new XYChart.Series();
			series2.setName("Umsatz");
			series2.getData().add(new XYChart.Data(2012, 2));
			series2.getData().add(new XYChart.Data(2013, 3));
			series2.getData().add(new XYChart.Data(2014, 4));
			series2.getData().add(new XYChart.Data(2015, 5));
			
			areaChart.getData().addAll(series1, series2);
			
			((Group)scene.getRoot()).getChildren().addAll(areaChart);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Area Chart");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}