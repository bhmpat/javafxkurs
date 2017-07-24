package application;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainTreeView extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10,10,10,10));
			grid.setVgap(10);
			grid.setHgap(10);
			
			TreeItem<String> treeroot = new TreeItem<>("Root");
			treeroot.setExpanded(true);
			
			TreeItem<String> item = new TreeItem<>("A");
			treeroot.getChildren().add(item);
			
			item = new TreeItem<>("B");
			treeroot.getChildren().add(item);
			
			item = new TreeItem<>("C");
			TreeItem<String> item2 = new TreeItem<>("CA");
			item.getChildren().add(item2);
			treeroot.getChildren().add(item);
			
			TreeView<String> tree = new TreeView<>(treeroot);
			
			grid.getChildren().addAll(tree);
			GridPane.setConstraints(tree, 0, 0);
			
			Scene scene = new Scene(grid, 300, 250);
			
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