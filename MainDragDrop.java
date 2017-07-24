package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


public class MainDragDrop extends Application{
	
	private ArrayList<Shape> nodes;
	private double mainSceneX, mainSceneY;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root, 400, 400);
			
			Rectangle toMove = new Rectangle(50, 50, 50, 50);
			Rectangle target = new Rectangle(150, 150, 100, 100);
			
			nodes = new ArrayList<>();
			nodes.add(toMove);
			nodes.add(target);
			
			toMove.setOnMousePressed(t ->{
				this.mainSceneX = t.getSceneX();
				this.mainSceneY = t.getSceneY();
				
				Rectangle r = (Rectangle)t.getSource();
				r.toFront();
			});
			
			toMove.setOnMouseDragged(t -> {
				double offsetX = t.getSceneX() - this.mainSceneX;
				double offsetY = t.getSceneY() - this.mainSceneY;
				
				Rectangle r = (Rectangle)t.getSource();
				r.setX(r.getX() + offsetX);
				r.setY(r.getY() + offsetY);
				
				this.mainSceneX = t.getSceneX();
				this.mainSceneY = t.getSceneY();
				
				checkBounds(target);
			});
			
			toMove.setOnMouseReleased(t ->{
				toMove.setFill(Color.BLACK);
			});
			
			root.getChildren().addAll(toMove, target);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Drag and Drop");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void checkBounds(Shape block) {
		boolean collisionDetected = false;
		
		for(Shape static_block : this.nodes) {
			if(static_block != block) {
				static_block.setFill(Color.YELLOW);
				
				if(block.getBoundsInParent().intersects(static_block.getBoundsInParent())) {
					collisionDetected = true;
				}
			}
		}
		
		if(collisionDetected) {
			block.setFill(Color.GREEN);
		}else {
			block.setFill(Color.BLUE);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}