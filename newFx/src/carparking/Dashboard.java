package carparking;

import java.io.FileNotFoundException;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Dashboard extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}
	
	Label lblTitle,lblADDCUST,lblPP,lblVEHENT,lblVEHEXIT,lblPPT,lblPHT,lblAboutUs,lblLogOut;
	public void start(Stage stage) throws Exception
	{
		Circle cir1 = new Circle(250,200,80);
		cir1.setStroke(Color.SEAGREEN);
		cir1.setFill(Color.SNOW); 
		cir1.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));

		Circle cir2 = new Circle(250,200,80); 
		cir2.setStroke(Color.SEAGREEN); 
		cir2.setFill(Color.SNOW); 
		cir2.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));

		Circle cir3 = new Circle(250,200,80); 
		cir3.setStroke(Color.SEAGREEN); 
		cir3.setFill(Color.SNOW); 
		cir3.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));

		Circle cir4 = new Circle(250,200,80); 
		cir4.setStroke(Color.SEAGREEN); 
		cir4.setFill(Color.SNOW); 
		cir4.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));

		Circle cir5 = new Circle(250,200,80); 
		cir5.setStroke(Color.SEAGREEN); 
		cir5.setFill(Color.SNOW); 
		cir5.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));

		Circle cir6 = new Circle(250,200,80); 
		cir6.setStroke(Color.SEAGREEN); 
		cir6.setFill(Color.SNOW);

		Circle cir7 = new Circle(250,200,80); 
		cir7.setStroke(Color.SEAGREEN); 
		cir7.setFill(Color.SNOW);
		cir7.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));

		Circle cir8 = new Circle(250,200,80); 
		cir8.setStroke(Color.SEAGREEN); 
		cir8.setFill(Color.SNOW);
		cir8.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));


		cir1.setFill(new ImagePattern(new Image(Dashboard.class.getResourceAsStream("ccl.png"))));
		cir2.setFill(new ImagePattern(new Image(Dashboard.class.getResourceAsStream("pp.png"))));
		cir3.setFill(new ImagePattern(new Image(Dashboard.class.getResourceAsStream("ven.png"))));
		cir4.setFill(new ImagePattern(new Image(Dashboard.class.getResourceAsStream("vex.png"))));
		cir5.setFill(new ImagePattern(new Image(Dashboard.class.getResourceAsStream("pps.png"))));
		cir6.setFill(new ImagePattern(new Image(Dashboard.class.getResourceAsStream("lph.png"))));
		cir7.setFill(new ImagePattern(new Image(Dashboard.class.getResourceAsStream("lout.png"))));
		cir8.setFill(new ImagePattern(new Image(Dashboard.class.getResourceAsStream("a.png"))));
		
		DropShadow ds = new DropShadow();

		ds.setOffsetX(3.0f);
		ds.setOffsetY(3.0f);

		lblTitle=new Label("Dashboard");
		lblTitle.setFont(Font.font("AR BONNIE", 48));
		lblTitle.setEffect(ds);
		lblTitle.setTextFill(Color.WHITE);
		
		lblADDCUST=new Label("Customer Console",cir1);
		lblADDCUST.setFont(Font.font("AR BONNIE", 20));
		lblADDCUST.setContentDisplay(ContentDisplay.TOP);
		lblADDCUST.setTextFill(Color.WHITE);
				
		lblPP=new Label("Parking Planner",cir2);
		lblPP.setFont(Font.font("AR BONNIE", 20));
		lblPP.setContentDisplay(ContentDisplay.TOP);
		lblPP.setTextFill(Color.WHITE);
		
		lblVEHENT=new Label("Vehicle Entry",cir3);
		lblVEHENT.setFont(Font.font("AR BONNIE", 20));
		lblVEHENT.setContentDisplay(ContentDisplay.TOP);
		lblVEHENT.setTextFill(Color.WHITE);
		
		lblVEHEXIT=new Label("Vehicle Exit",cir4);
		lblVEHEXIT.setFont(Font.font("AR BONNIE", 20));
		lblVEHEXIT.setContentDisplay(ContentDisplay.TOP);
		lblVEHEXIT.setTextFill(Color.WHITE);
		
		lblPPT=new Label("Parking Plan Table",cir5);
		lblPPT.setFont(Font.font("AR BONNIE", 20));
		lblPPT.setContentDisplay(ContentDisplay.TOP);
		lblPPT.setTextFill(Color.WHITE);
		
		lblPHT=new Label("Parking History Table",cir6);
		lblPHT.setFont(Font.font("AR BONNIE", 20));
		lblPHT.setContentDisplay(ContentDisplay.TOP);;
		lblPHT.setTextFill(Color.WHITE);
		
		lblLogOut=new Label("Log Out",cir7);
		lblLogOut.setFont(Font.font("AR BONNIE", 20));
		lblLogOut.setContentDisplay(ContentDisplay.TOP);
		lblLogOut.setTextFill(Color.WHITE);
		
		lblAboutUs=new Label("About Us",cir8);
		lblAboutUs.setFont(Font.font("AR BONNIE", 20));
		lblAboutUs.setContentDisplay(ContentDisplay.TOP);
		lblAboutUs.setTextFill(Color.WHITE);
		
		GridPane grid=new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 20, 10, 20));
		grid.setAlignment(Pos.CENTER);
		GridPane.setConstraints(lblTitle, 0, 0, 4, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 35, 5, 35));
		grid.getChildren().add(lblTitle);
		GridPane.setConstraints(lblADDCUST, 0, 2, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblADDCUST);
		GridPane.setConstraints(lblPP, 1, 2, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblPP);
		GridPane.setConstraints(lblVEHENT, 2, 2, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblVEHENT);
		GridPane.setConstraints(lblVEHEXIT, 3, 2, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblVEHEXIT);
		GridPane.setConstraints(lblPHT, 0, 3, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblPHT);
		GridPane.setConstraints(lblPPT, 1, 3, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblPPT);
		GridPane.setConstraints(lblLogOut, 2, 3, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblLogOut);
		GridPane.setConstraints(lblAboutUs, 3, 3, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(5, 10, 5, 10));
		grid.getChildren().add(lblAboutUs);
		
		grid.setStyle("-fx-background-color:black");
		
		Scene scene = new Scene(grid,900,600);
		stage.setScene(scene);
		stage.show();

		lblADDCUST.setOnMouseEntered(new EventHandler()
		{
			public void handle(Event arg0)
			{
				scene.setCursor(Cursor.HAND);
				new Timeline(
						new KeyFrame(Duration.seconds(0),new KeyValue(lblADDCUST.opacityProperty(),.5)),
						new KeyFrame(Duration.seconds(1),new KeyValue(lblADDCUST.opacityProperty(),.5))).play();
			}
		});

		lblADDCUST.setOnMouseExited(new EventHandler()
		{
			@Override
			public void handle(Event event)
			{
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(new KeyFrame(Duration.seconds(0),new KeyValue(lblADDCUST.opacityProperty(),1)),
							new KeyFrame(Duration.seconds(1),new KeyValue(lblADDCUST.opacityProperty(),1))).play();
			}
		});

		lblPP.setOnMouseEntered(new EventHandler()
		{
			public void handle(Event arg0) 
			{
				scene.setCursor(Cursor.HAND);
				new Timeline(new KeyFrame(Duration.seconds(0),new KeyValue(lblPP.opacityProperty(),.5)),
							new KeyFrame(Duration.seconds(1),new KeyValue(lblPP.opacityProperty(),.5))).play();
			}
		});

		lblPP.setOnMouseExited(new EventHandler()
		{
			@Override
			public void handle(Event event) 
			{
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(new KeyFrame(Duration.seconds(0),new KeyValue(lblPP.opacityProperty(),1)),
							new KeyFrame(Duration.seconds(1),new KeyValue(lblPP.opacityProperty(),1))).play();
			}
		});

		lblVEHENT.setOnMouseEntered(new EventHandler()
		{
			public void handle(Event arg0) 
			{
				scene.setCursor(Cursor.HAND);
				new Timeline(new KeyFrame(Duration.seconds(0),new KeyValue(lblVEHENT.opacityProperty(),.5)),
							new KeyFrame(Duration.seconds(1),new KeyValue(lblVEHENT.opacityProperty(),.5))).play();
			}
		});
		
		lblVEHENT.setOnMouseExited(new EventHandler()
		{
			@Override
			public void handle(Event event) 
			{
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(new KeyFrame(Duration.seconds(0),new KeyValue(lblVEHENT.opacityProperty(),1)),
							new KeyFrame(Duration.seconds(1),new KeyValue(lblVEHENT.opacityProperty(),1))).play();
			}
		});

		lblVEHEXIT.setOnMouseEntered(new EventHandler()
		{
			public void handle(Event arg0) 
			{
				scene.setCursor(Cursor.HAND);
				new Timeline(new KeyFrame(Duration.seconds(0),new KeyValue(lblVEHEXIT.opacityProperty(),.5)),
							new KeyFrame(Duration.seconds(1),new KeyValue(lblVEHEXIT.opacityProperty(),.5))).play();
			}
		});

		lblVEHEXIT.setOnMouseExited(new EventHandler() 
		{
			@Override
			public void handle(Event event) 
			{
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(new KeyFrame(Duration.seconds(0),new KeyValue(lblVEHEXIT.opacityProperty(),1)),
							new KeyFrame(Duration.seconds(1),new KeyValue(lblVEHEXIT.opacityProperty(),1))).play();
			}
		});

		lblPPT.setOnMouseEntered(new EventHandler() 
		{
			public void handle(Event arg0) 
			{
				scene.setCursor(Cursor.HAND);
				new Timeline(new KeyFrame(Duration.seconds(0),new KeyValue(lblPPT.opacityProperty(),.5)),
							new KeyFrame(Duration.seconds(1),new KeyValue(lblPPT.opacityProperty(),.5))).play();
			}
		});

		lblPPT.setOnMouseExited(new EventHandler() 
		{
			@Override
			public void handle(Event event) 
			{
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(new KeyFrame(Duration.seconds(0),new KeyValue(lblPPT.opacityProperty(),1)),
							new KeyFrame(Duration.seconds(1),new KeyValue(lblPPT.opacityProperty(),1))).play();
			}
		});
		
		lblPHT.setOnMouseEntered(new EventHandler() 
		{
			public void handle(Event arg0) 
			{
				scene.setCursor(Cursor.HAND);
				new Timeline(new KeyFrame(Duration.seconds(0),new KeyValue(lblPHT.opacityProperty(),.5)),
							new KeyFrame(Duration.seconds(1),new KeyValue(lblPHT.opacityProperty(),.5))).play();
			}
		});

		lblPHT.setOnMouseExited(new EventHandler() 
		{
			@Override
			public void handle(Event event) 
			{
				scene.setCursor(Cursor.DEFAULT);
				new Timeline(new KeyFrame(Duration.seconds(0),new KeyValue(lblPHT.opacityProperty(),1)),
							new KeyFrame(Duration.seconds(1),new KeyValue(lblPHT.opacityProperty(),1))).play();
			}
		});

lblAboutUs.setOnMouseEntered(new EventHandler() {
public void handle(Event arg0) {
scene.setCursor(Cursor.HAND);
new Timeline(
new KeyFrame(Duration.seconds(0),new KeyValue(lblAboutUs.opacityProperty(),.5)),
new KeyFrame(Duration.seconds(1),new KeyValue(lblAboutUs.opacityProperty(),.5))).play();
}
});
lblAboutUs.setOnMouseExited(new EventHandler() {
@Override
public void handle(Event event) {
scene.setCursor(Cursor.DEFAULT);
new Timeline(
new KeyFrame(Duration.seconds(0),new KeyValue(lblAboutUs.opacityProperty(),1)),
new KeyFrame(Duration.seconds(1),new KeyValue(lblAboutUs.opacityProperty(),1))).play();
}
});
lblLogOut.setOnMouseEntered(new EventHandler() {
public void handle(Event arg0) {
scene.setCursor(Cursor.HAND);
new Timeline(
new KeyFrame(Duration.seconds(0),new KeyValue(lblLogOut.opacityProperty(),.5)),
new KeyFrame(Duration.seconds(1),new KeyValue(lblLogOut.opacityProperty(),.5))).play();
}
});
lblLogOut.setOnMouseExited(new EventHandler() {
@Override
public void handle(Event event) {
scene.setCursor(Cursor.DEFAULT);
new Timeline(
new KeyFrame(Duration.seconds(0),new KeyValue(lblLogOut.opacityProperty(),1)),
new KeyFrame(Duration.seconds(1),new KeyValue(lblLogOut.opacityProperty(),1))).play();
}
});

lblADDCUST.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent event) {
// TODO Auto-generated method stub
try {
stage.setIconified(true);
new AddCustomer();
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
});
lblPP.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent event) {
// TODO Auto-generated method stub
try {
stage.setIconified(true);
new ParkingPlan();
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
});
lblVEHENT.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent event) {
// TODO Auto-generated method stub
try {
stage.setIconified(true);
new RoutineCustomerEntry();
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
});
lblVEHEXIT.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent event) {
// TODO Auto-generated method stub
try {
stage.setIconified(true);
new VehicleExit();
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
});
lblPPT.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent event) {
// TODO Auto-generated method stub
try {
stage.setIconified(true);
new PPT();
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
});
lblPHT.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent event) {
// TODO Auto-generated method stub
try {
stage.setIconified(true);
new PHT();
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
});

lblAboutUs.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent event) {
// TODO Auto-generated method stub
stage.setIconified(true);
try {
	new aboutus();
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
});
lblLogOut.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent event) {
// TODO Auto-generated method stub
stage.setIconified(true);
System.exit(0);
}
});
}
	
}