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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MainTableView extends Application{

	private final ObservableList<Person> data = FXCollections.observableArrayList(
				new Person("Denis", "Panjuta", 28),
				new Person("Max", "Mustermann", 25),
				new Person("Dieter", "Mieter", 35)
			);
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10,10,10,10));
			grid.setVgap(10);
			grid.setHgap(10);
			
			TableView<Person> tv = new TableView<>();
			TableColumn tcv = new TableColumn("Vorname");
			TableColumn tcn = new TableColumn("Nachname");
			TableColumn tca = new TableColumn("Alter");
			
			tv.getColumns().addAll(tcv, tcn, tca);
			
			tcv.setCellValueFactory(new PropertyValueFactory<>("vorname"));
			tcv.setMinWidth(100);
			tcv.setMaxWidth(100);
			
			tcn.setCellValueFactory(new PropertyValueFactory<>("nachname"));
			tcn.setMinWidth(100);
			tcn.setMaxWidth(100);
			
			tca.setCellValueFactory(new PropertyValueFactory<>("alter"));
			tca.setMinWidth(100);
			tca.setMaxWidth(100);
			
			tv.setItems(data);
			
			grid.getChildren().addAll(tv);
			GridPane.setConstraints(tv, 0, 0);
			
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
	
	public static class Person {
		private final SimpleStringProperty vorname;
		private final SimpleStringProperty nachname;
		private final SimpleIntegerProperty alter;
		
		public Person(String vname, String nname, int alter) {
			this.vorname = new SimpleStringProperty(vname);
			this.nachname = new SimpleStringProperty(nname);
			this.alter = new SimpleIntegerProperty(alter);
		}
		
		public String getVorname() {
			return vorname.get();
		}
		
		public String getNachname() {
			return nachname.get();
		}
		
		public int getAlter() {
			return alter.get();
		}
	}
}