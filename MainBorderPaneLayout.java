package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class MainBorderPaneLayout extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane bp = new BorderPane();
			
			Label label = new Label("Der Text ist oben");
			
			VBox left = new VBox();
			VBox right = new VBox();
			
			HTMLEditor html = new HTMLEditor();
			html.setPrefHeight(250);
			
			WebView browser = new WebView();
			
			TextArea htmlcode = new TextArea();
			htmlcode.setWrapText(true);
			
			Button showhtml = new Button("Zeige HTML");
			
			showhtml.setOnAction(e -> {
				htmlcode.setText(html.getHtmlText());
			});
			
			left.getChildren().add(new Button("Button"));
			right.getChildren().add(showhtml);
			
			bp.setTop(label);
			bp.setCenter(html);
			bp.setLeft(left);
			bp.setRight(right);
			bp.setBottom(htmlcode);
			
			Scene scene = new Scene(bp, 800, 500);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("BorderPane");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}