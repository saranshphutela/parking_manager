package carparking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class aboutus
{
	public static void main(String args[])
	{
		
	}

	aboutus() throws FileNotFoundException
	{
	
	GridPane grd;
	Text my,rj;
	VBox v1,v2;
	HBox h1,h2;
	Scene scene;
	Stage stage;
	
		final String words=("I, Saransh Phutela has made this project under the guidance of Mr.Rajesh K. Bansal"
					+" to solve some real life problems. In this digital age, we have an opportunity to transform "
					+" lives of people in ways that was hard to imagine a couple of decades ago. We must ensure that"
					+" technology is accessible,affordable and beneficial for routine life.");
	
	final String words1=("Mr.Rajesh K. Bansal is the Founder and Director of Banglore Computer Education(BCE), "
			+"Training Head at Sun-Soft Technologies and also the Author of the book 'Real Java'. He is involved "
			+"in professional training field for more than 18 years.");
	
	
	grd=new GridPane();
	grd.setPadding(new Insets(100));
	grd.setVgap(15);
	grd.setHgap(15);
	grd.setGridLinesVisible(false);
	
	
	Label label1 = new Label(words);
	label1.setWrapText(true);
	label1.setStyle("-fx-font-family: \"Arial\"; -fx-font-size: 20; -fx-text-fill: green;");
	
	Label label2 = new Label(words1);
	label2.setWrapText(true);
	label2.setStyle("-fx-font-family: \"Arial\"; -fx-font-size: 20; -fx-text-fill: green;");
	
	my=new Text("Saransh Phutela");
	my.setFont(Font.font("Arial",FontWeight.BOLD,20));
	my.setFill(Color.MAROON);	
	
	
	rj=new Text("Mr.Rajesh K.Bansal");
	rj.setFont(Font.font("Arial",FontWeight.BOLD,20));
	rj.setFill(Color.MAROON);
	
	
	ImageView img1=new ImageView(new Image(new FileInputStream(new File("2as.png"))));
	ImageView img2=new ImageView(new Image(new FileInputStream(new File("my.png"))));
	ImageView img3=new ImageView(new Image(new FileInputStream(new File("sir.jpg"))));
	
	img1.setFitWidth(400);
	img1.setFitHeight(100);
	
	img2.setFitHeight(160);
	img2.setFitWidth(160);
	img2.setStyle("-fx-border-color:black");
	
	img3.setFitHeight(160);
	img3.setFitWidth(160);
	img3.setStyle("-fx-border-color:black");
	
	v1=new VBox();
	v1.setSpacing(0);
	v1.getChildren().addAll(img2,my);
	

	v2=new VBox();
	v2.setSpacing(0);
	v2.getChildren().addAll(img3,rj);
	
	h1=new HBox();
	h1.setSpacing(20);
	h1.getChildren().add(v1);
	
	h2=new HBox();
	h2.setSpacing(20);
	h2.getChildren().add(v2);
	
	GridPane.setConstraints(img1,2,0,6,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(10));
	GridPane.setConstraints(label1,1,0,9,3,HPos.CENTER,VPos.BOTTOM,null,null,new Insets(0,0,70,0));
	GridPane.setConstraints(label2,3,2,6,3,HPos.CENTER,VPos.CENTER,null,null,new Insets(10));
	GridPane.setConstraints(h1,0,1,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(10));
	GridPane.setConstraints(h2,9,3,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(0));
	
	img1.setTranslateX(120);
	grd.getChildren().addAll(img1,h1,h2,label1,label2);
	grd.setStyle("-fx-background-color:moccasin");
	
	
	
	scene=new Scene(grd,700,700);
	stage=new Stage();
	stage.setScene(scene);
	stage.show();
	stage.setTitle("PARKING ASSISTANT");
	stage.setMaximized(true);

	}
}