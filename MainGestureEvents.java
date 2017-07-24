package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.SwipeEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class MainGestureEvents extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			Scene scene = new Scene(root, 400, 400);
			
			Rectangle rec = new Rectangle();
			rec.setWidth(200);
			rec.setHeight(200);
			root.getChildren().add(rec);
			
			rec.setOnTouchPressed(new EventHandler<TouchEvent>() {
				@Override
				public void handle(TouchEvent event) {
					System.out.println("Viereck gedrückt bei: "+event.getTouchPoints().toString());
					event.consume();
				}
			});
			
			rec.setOnTouchReleased(new EventHandler<TouchEvent>() {
				@Override
				public void handle(TouchEvent event) {
					System.out.println("Viereck wurde losgelassen");
					event.consume();
				}
			});
			
			rec.setId("1");
			long touchID = 1;
			double touchX = rec.getX();
			double touchY = rec.getY();
			
			rec.setOnTouchMoved(new EventHandler<TouchEvent>() {
				@Override
				public void handle(TouchEvent event) {
					if(event.getTouchPoint().getId() == touchID) {
						rec.setTranslateX(event.getTouchPoint().getSceneX() - touchX);
						rec.setTranslateY(event.getTouchPoint().getSceneY() - touchY);
					}
					event.consume();
				}
			});
			
			rec.setOnZoom(new EventHandler<ZoomEvent>() {
				@Override
				public void handle(ZoomEvent event) {
					rec.setScaleX(rec.getScaleX() * event.getZoomFactor());
					rec.setScaleY(rec.getScaleY() * event.getZoomFactor());
					System.out.println("Viereck: Zoom Event" + ", inertia: " + event.isInertia() + ", direct: " + event.isDirect());
					event.consume();
				}
			});
			
			rec.setOnZoomStarted(new EventHandler<ZoomEvent>() {
				@Override
				public void handle(ZoomEvent event) {
					System.out.println("Viereck: Zoom Event started");
					event.consume();
				}
			});
			
			rec.setOnZoomFinished(new EventHandler<ZoomEvent>() {
				@Override
				public void handle(ZoomEvent event) {
					System.out.println("Viereck: Zoom Event finished");
					event.consume();
				}
			});
			
			rec.setOnScroll(new EventHandler<ScrollEvent>() {
				@Override
				public void handle(ScrollEvent event) {
					if(!event.isInertia()) {
						rec.setTranslateX(rec.getTranslateX() + event.getDeltaX());
						rec.setTranslateY(rec.getTranslateY() + event.getDeltaY());
					}
					System.out.println("Viereck: Scroll Event" + ", inertia: " + event.isInertia() + ", direct: " + event.isDirect());
					event.consume();
				}
			});
			
			rec.setOnScrollStarted(new EventHandler<ScrollEvent>() {
				@Override
				public void handle(ScrollEvent event) {
					System.out.println("Scroll Event begonnen");
					event.consume();
				}
			});
			
			rec.setOnScrollFinished(new EventHandler<ScrollEvent>() {
				@Override
				public void handle(ScrollEvent event) {
					System.out.println("Scroll Event finished");
					event.consume();
				}
			});
			
			rec.setOnRotate(new EventHandler<RotateEvent>() {
				@Override
				public void handle(RotateEvent event) {
					rec.setRotate(rec.getRotate() + event.getAngle());
					System.out.println("Viereck: Rotate Event" + ", inertia: " + event.isInertia() + ", direct: " + event.isDirect());
					event.consume();
				}
			});
			
			rec.setOnRotationStarted(new EventHandler<RotateEvent>() {
				@Override
				public void handle(RotateEvent event) {
					System.out.println("Rotate Event begonnen");
					event.consume();
				}
			});
			
			rec.setOnRotationFinished(new EventHandler<RotateEvent>() {
				@Override
				public void handle(RotateEvent event) {
					System.out.println("Rotate Event finished");
					event.consume();
				}
			});
			
			rec.setOnSwipeUp(new EventHandler<SwipeEvent>() {
				@Override
				public void handle(SwipeEvent event) {
					System.out.println("Swipe Event UP");
					event.consume();
				}
			});
			
			rec.setOnSwipeDown(new EventHandler<SwipeEvent>() {
				@Override
				public void handle(SwipeEvent event) {
					System.out.println("Swipe Event DOWN");
					event.consume();
				}
			});
			
			rec.setOnSwipeLeft(new EventHandler<SwipeEvent>() {
				@Override
				public void handle(SwipeEvent event) {
					System.out.println("Swipe Event LEFT");
					event.consume();
				}
			});
			
			rec.setOnSwipeRight(new EventHandler<SwipeEvent>() {
				@Override
				public void handle(SwipeEvent event) {
					System.out.println("Swipe Event RIGHT");
					event.consume();
				}
			});
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Event(Filters)");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}