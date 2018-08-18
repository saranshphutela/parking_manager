package carparking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginForm extends Application 
{

	static Connection con;
	PreparedStatement pst;
public static void main(String[] args)
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
	
	launch(args);
}
	
GridPane grid;
TextField txtUid;
PasswordField txtPwd;

@Override
public void start(Stage primaryStage) 
	{
		grid=new GridPane();
		grid.setGridLinesVisible(false);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(100,20,20,50));

		ImageView logo=new ImageView(new Image(LoginForm.class.getResourceAsStream("1LOG.png")));
		logo.setFitWidth(300);
		logo.setFitHeight(60);
		
		Text lblUid,lblPwd;
		Button btnLog,btnClose,btnFP;
		
		lblUid=new Text("User Id");
		lblUid.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,15));
		lblUid.setFill(Color.ROYALBLUE);
		
		txtUid=new TextField();
		txtUid.setPromptText("Enter your User-Id");
		txtUid.setStyle("-fx-font: 15 arial;;");
	

		lblPwd=new Text("Password");
		lblPwd.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,15));
		lblPwd.setFill(Color.ROYALBLUE);
		
		txtPwd=new PasswordField();
		txtPwd.setStyle("-fx-font: 15 arial;");
		txtPwd.setPromptText("Enter your Password");

		btnLog=new Button("Login");
		btnLog.setPrefSize(90, 20);
		btnLog.setStyle("-fx-font: 18 arial;-fx-base:maroon");
		
		btnClose=new Button("Exit");
		btnClose.setStyle("-fx-font: 18 arial;-fx-base:maroon");
		
		btnFP=new Button("Forgot Password ?"); 
		btnFP.setPrefSize(160, 20);
		btnFP.setStyle("-fx-font: 16 arial;-fx-base:maroon");

		GridPane.setConstraints(lblUid, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER, null, null,new Insets(10));
		grid.setConstraints(logo, 0, 0, 5, 1, HPos.CENTER, VPos.CENTER,null, null, new Insets(10));
		grid.setConstraints(btnFP, 1, 7, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(0));
		grid.getChildren().addAll(lblUid,logo,btnFP);
		grid.add(txtUid, 1, 1);
		grid.add(lblPwd, 0, 2);
		grid.add(txtPwd, 1, 2);

		//add buttons
		HBox hbox=new HBox();
		HBox.setMargin(btnClose, new Insets(0,0,0,10)); 
		hbox.getChildren().addAll(btnLog,btnClose);
		grid.add(hbox, 1, 5);
		
		//events
		btnClose.setOnAction(e->System.exit(0));
		btnLog.setOnAction(e->doLogin(primaryStage));
		btnFP.setOnAction(e->sendSMS());
		
		grid.setStyle("-fx-background-color:lightgreen");

		Scene scene=new Scene(grid,450,450);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("Parking Assistant");
	}
	
	void doLogin(Stage stage)
	{
		try
		{
			pst=con.prepareStatement("select * from login");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				if(txtUid.getText().equals(rs.getString("uid")) && txtPwd.getText().equals(rs.getString("password")))
				{
					Dashboard d=new Dashboard();
					d.start(stage);
				}
				else
				{
					Alert alert =new Alert(AlertType.WARNING);
					alert.setTitle("Alert");
					alert.setHeaderText("Oops!Something went wrong...");
					alert.setContentText("Please Enter Correct Password...");
					alert.show();
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	void sendSMS()
	{
	
		String msg=  sms.bceSunSoftSend("8264301657","Your Password is - welcomeadmin");
		System.out.println( msg);
	}
}