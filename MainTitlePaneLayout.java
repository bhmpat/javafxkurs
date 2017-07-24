package application;

import java.awt.event.ActionEvent;
import java.sql.Savepoint;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainTitlePaneLayout extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			
			MenuBar menubar = new MenuBar();
			
			Menu filemenu = new Menu("Datei");
			
			MenuItem exit = new MenuItem("Schließen");
			exit.setOnAction(actionEvent -> {
				Platform.exit();
			});
			
			MenuItem neup = new MenuItem("Neues Projekt...");
			neup.setOnAction(actionEvent -> {
				System.out.println("Neues Projekt angelegt");
			});
			
			Menu savemenu = new Menu("Speichern als...");
			savemenu.getItems().addAll(
					new CheckMenuItem("TXT"),
					new CheckMenuItem("DOC"),
					new CheckMenuItem("PDF")
					);
			
			filemenu.getItems().add(neup);
			filemenu.getItems().add(new MenuItem("Datei öffnen"));
			filemenu.getItems().add(savemenu);
			filemenu.getItems().add(new SeparatorMenuItem());
			filemenu.getItems().add(exit);
			
			Menu editmenu = new Menu("Bearbeiten");
			editmenu.getItems().add(new MenuItem("Rückgängig"));
			editmenu.getItems().add(new MenuItem("Wiederholen"));
			editmenu.getItems().add(new MenuItem("Einfügen"));
			
			menubar.getMenus().addAll(filemenu, editmenu);
			
			root.setTop(menubar);
			
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