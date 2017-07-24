package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class MainHTMLEditor extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10,10,10,10));
			grid.setVgap(10);
			grid.setHgap(10);
			
			HTMLEditor htmle = new HTMLEditor();
			htmle.setPrefHeight(250);
			
			WebView web = new WebView();
			web.setPrefSize(300, 200);
			
			WebEngine we = web.getEngine();
			
			TextArea html = new TextArea();
			html.setWrapText(true);
			
			Button showhtml = new Button("Zeige HTML Code in Browser");
			showhtml.setOnAction(e -> {
				html.setText(htmle.getHtmlText());
				we.loadContent(htmle.getHtmlText());
			});
			
			grid.getChildren().addAll(htmle, html, showhtml, web);
			GridPane.setConstraints(htmle, 0, 0);
			GridPane.setConstraints(html, 0, 1);
			GridPane.setConstraints(showhtml, 0, 2);
			GridPane.setConstraints(web, 0, 3);
			
			Scene scene = new Scene(grid, 500, 700);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("HTML Editor Java FX");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}