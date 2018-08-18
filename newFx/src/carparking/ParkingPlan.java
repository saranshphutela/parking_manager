package carparking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ParkingPlan extends Application 
{
	Connection con;
	PreparedStatement pst;
	Label txtFL, txtSL, txtTYPE;
	TextField tfFL, tfSL;
	RadioButton rbTW, rbFW;
	Button btnS, btnC;
	GridPane grid;
	ToggleGroup tgRB;
	HBox hbBTN, hbRB;
	Alert alert;
	public ParkingPlan()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carparking","root","");

		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
	
		txtFL = new Label("Floor No.");
		txtFL.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,25));
		txtFL.setTextFill(Color.RED);
		
		txtSL = new Label("Slots");
		txtSL.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,25));
		txtSL.setTextFill(Color.RED);
		
		txtTYPE = new Label("Type");
		txtTYPE.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,25));
		txtTYPE.setTextFill(Color.RED);
		
		
		tfFL = new TextField();
		/*tfFL.setOnKeyReleased(e->{
			
			String Uname="^[_0-9]{1,2}$";
			if(tfFL.getText().matches(Uname)){
				tfFL.setStyle("-fx-border-color:green");
			}
			else{
				tfFL.setStyle("-fx-border-color:red");
			}
		});*/
		tfFL.setStyle("-fx-font: 15 arial;");
		
		tfSL = new TextField();
		/*tfSL.setOnKeyReleased(e->{
			
			String Uname="^[_0-9]{1,3}$";
			if(tfSL.getText().matches(Uname)){
				tfSL.setStyle("-fx-border-color:green");
			}
			else{
				tfSL.setStyle("-fx-border-color:red");
			}
		});*/
		tfSL.setStyle("-fx-font: 15 arial;");
		
		rbTW = new RadioButton("Two Wheeler");
		rbTW.setStyle("-fx-font: 12 arial;-fx-base:black");

		rbFW = new RadioButton("Four Wheeler");
		rbFW.setStyle("-fx-font: 12 arial;-fx-base:black");
		
		
		rbTW.setPrefSize(100, 30);
		rbFW.setPrefSize(100, 30);
		
		tgRB = new ToggleGroup();
		rbTW.setToggleGroup(tgRB);
		
		rbFW.setToggleGroup(tgRB);
		
		hbRB = new HBox();
		
		hbRB.getChildren().addAll(rbTW, rbFW);
		hbRB.setPadding(new Insets(10));
		hbRB.setSpacing(20);
		
		btnS = new Button("Save");
		btnS.setStyle("-fx-font: 18 arial;-fx-base:forestgreen");

		btnC = new Button("Clear");
		btnC.setStyle("-fx-font: 18 arial;-fx-base:forestgreen");

		hbBTN = new HBox();
		hbBTN.setPrefSize(90, 30);
		hbBTN.setSpacing(20);
		hbBTN.getChildren().addAll(btnS,btnC);
				
		grid = new GridPane();
		

		ImageView logo=new ImageView(new Image(LoginForm.class.getResourceAsStream("1pp.png")));
		logo.setFitWidth(350);
		logo.setFitHeight(80);
		
		txtFL.setFont(Font.font(STYLESHEET_CASPIAN, 16));
		txtSL.setFont(Font.font(STYLESHEET_CASPIAN, 16));
		txtTYPE.setFont(Font.font(STYLESHEET_CASPIAN, 16));
		
		GridPane.setConstraints(logo, 0, 0, 3, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtFL, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtSL, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtTYPE, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		
		GridPane.setConstraints(tfFL, 1, 1, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(tfSL, 1, 2, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		
		GridPane.setConstraints(hbRB, 1, 3, 3, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(hbBTN, 1, 4, 2, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		
		grid.setPadding(new Insets(100));
		grid.getChildren().addAll(logo, txtFL, txtSL,txtTYPE,tfFL,tfSL,hbBTN,hbRB);
		grid.setGridLinesVisible(false);

		grid.setStyle("-fx-background-color:cornflowerblue");

		
		btnS.setOnAction(e->dosave());
		btnC.setOnAction(e->doclear());	
		

		Scene scene = new Scene(grid,550,550);
		Stage stage=new Stage();
		stage.setScene(scene);
		stage.setTitle("PARKING ASSISTANT");
		stage.show();
				
	}
	
	
	public void doclear()
	{
		tfFL.clear();
		tfSL.clear();
		
		if(rbTW.isSelected()==true)
		{
			rbTW.setSelected(false);
		}
		if(rbFW.isSelected()==true)
		{
			rbFW.setSelected(false);
		}
	}

	public void dosave()
	{
		String type = "";
		if(rbTW.isSelected())
		{
			type = "Two Wheeler";
		}
		if(rbFW.isSelected())
		{
			type = "Four Wheeler";
		}
		try
		{
		pst = con.prepareStatement("insert into parkingplan values (?,?,?,0,?)");
		pst.setString(1, tfFL.getText());
		pst.setString(2, tfSL.getText());
		pst.setString(3, type);
		pst.setString(4, tfSL.getText());
		int x = pst.executeUpdate();
		//pst.close();
		if(x==1)
			{		
			alert=new Alert(AlertType.INFORMATION);
			
			alert.setContentText("Record Saved..");
			alert.show();
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
	}	
}
