package application;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainTreeTableView extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10,10,10,10));
			grid.setVgap(10);
			grid.setHgap(10);
			
			TreeItem<String> titem1 = new TreeItem<>("ELement 1");
			TreeItem<String> titem2 = new TreeItem<>("ELement 2");
			TreeItem<String> titem3 = new TreeItem<>("ELement 3");
			
			TreeItem<String> root = new TreeItem<>("Root");
			root.setExpanded(true);
			
			root.getChildren().addAll(titem1, titem2, titem3);
			
			TreeTableColumn<String, String> column = new TreeTableColumn<>("Spalte");
			column.setPrefWidth(120);
			column.setCellValueFactory(
					(CellDataFeatures<String, String> p) -> new ReadOnlyStringWrapper(
						p.getValue().getValue())
					);
			
			TreeTableView<String> treetabview = new TreeTableView<>(root);
			treetabview.getColumns().add(column);
			
			grid.getChildren().addAll(treetabview);
			GridPane.setConstraints(treetabview, 0, 0);
			
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