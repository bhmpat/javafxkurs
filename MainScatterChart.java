package application;

import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class MainScatterChart extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(new Group());
			
			NumberAxis xAxis = new NumberAxis(0, 100, 5);
			NumberAxis yAxis = new NumberAxis(0, 50, 5);
			
			ScatterChart<Number, Number> scatterChart = new ScatterChart<Number, Number>(xAxis, yAxis);
			scatterChart.setTitle("Heatmap");
			xAxis.setForceZeroInRange(true);
			
			XYChart.Series series1 = new XYChart.Series();
			series1.setName("Spieler");
			
			Random rnd = new Random();
			
			for(int i = 0; i < 250; i++) {
				series1.getData().add(new XYChart.Data<Number, Number>(rnd.nextDouble()*100, rnd.nextDouble()*50));
			}
			
			scatterChart.getData().addAll(series1);
			
			((Group)scene.getRoot()).getChildren().addAll(scatterChart);
			
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