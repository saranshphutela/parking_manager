package carparking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddCustomer extends Application
{
	Connection con;
	PreparedStatement pst;

	Text  txtMOB, txtNAME, txtADD, txtCITY, txtVEH, txtEID;
	TextArea tfADD;
	ComboBox<String> cbMOB;
	TextField  tfNAME, tfCITY, tfPIC, tfVEH, tfEID;
	RadioButton rbTW, rbFW;
	Button btnN, btnS, btnU, btnD,btnSearch;
	ImageView ivN, ivS, ivU, ivD,logo;
	GridPane grid;
	HBox hbRB, hbPIC,hbBtn;
	ToggleGroup tgRB;
	Alert alert;
	public AddCustomer()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carparking","root","");
			System.out.println("connected");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
			
		txtMOB = new Text("Mobile");
		txtNAME = new Text("Name");
		txtADD = new Text("Address");
		txtCITY = new Text("City");
		txtVEH = new Text("Vehicle No.");
		txtEID = new Text("E-Mail ID");
		
		txtMOB.setStyle("-fx-font: 18 arial;");
		txtNAME.setStyle("-fx-font: 18 arial;");
		txtADD.setStyle("-fx-font: 18 arial;");
		txtCITY.setStyle("-fx-font: 18 arial;");
		txtVEH.setStyle("-fx-font: 18 arial;");
		txtEID.setStyle("-fx-font: 18 arial;");

		
		txtMOB.setFill(Color.ROYALBLUE);
		txtNAME.setFill(Color.ROYALBLUE);
		txtADD.setFill(Color.ROYALBLUE);
		txtCITY.setFill(Color.ROYALBLUE);
		txtVEH.setFill(Color.ROYALBLUE);
		txtEID.setFill(Color.ROYALBLUE);

		
		cbMOB = new ComboBox<String>();
		tfNAME = new TextField();
		tfNAME.setOnKeyReleased(e->{
			
			String Uname="^[_a-zA-Z]{2,50}$";
			if(tfNAME.getText().matches(Uname)){
				tfNAME.setStyle("-fx-border-color:green");
			}
			else{
				tfNAME.setStyle("-fx-border-color:red");
			}
		});
		tfADD = new TextArea();
		tfADD.setPrefSize(100, 80);
		tfCITY = new TextField();
		tfPIC = new TextField();
		tfVEH = new TextField();
		tfEID = new TextField();
		
		rbTW = new RadioButton("Two Wheeler");
		rbFW = new RadioButton("Four Wheeler");
		
		rbTW.setStyle("-fx-font: 16 arial;");
		rbFW.setStyle("-fx-font: 16 arial;");
		
		rbTW.setTextFill(Color.ROYALBLUE);
		rbFW.setTextFill(Color.ROYALBLUE);
		
		
		btnN = new Button("New");
		btnS = new Button("Save");
		btnU = new Button("Update");
		btnD = new Button("Delete");
		btnSearch = new Button("Search");
		
		btnN.setStyle("-fx-font: 14 arial;-fx-base:maroon");
		btnS.setStyle("-fx-font: 14 arial;-fx-base:maroon");
		btnU.setStyle("-fx-font: 14 arial;-fx-base:maroon");
		btnD.setStyle("-fx-font: 14 arial;-fx-base:maroon");
		btnSearch.setStyle("-fx-font: 18 arial;-fx-base:maroon");
		
		
		grid = new GridPane();
		
		ImageView logo=new ImageView(new Image(LoginForm.class.getResourceAsStream("1cc.png")));
		logo.setFitWidth(600);
		logo.setFitHeight(80);
		
		hbBtn=new HBox();
		hbRB = new HBox();
		hbPIC = new HBox();
		tgRB = new ToggleGroup();
	
		hbBtn.getChildren().addAll(btnN,btnS,btnU,btnD);
		hbBtn.setSpacing(30);
		
		cbMOB.setEditable(true);
		cbMOB.getSelectionModel().select(0);
		
		grid.setGridLinesVisible(true);
		GridPane.setConstraints(txtMOB, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtNAME, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtADD, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtCITY, 0, 4, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		//GridPane.setConstraints(txtPIC, 0, 5, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtVEH, 0, 5, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtEID, 0, 8, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(btnSearch, 2,1, 1, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(10,0,10,0));
		//GridPane.setConstraints(btnCAP, 1,5, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10,0,10,0));
		GridPane.setConstraints(logo, 0, 0, 3, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(cbMOB, 1, 1, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10,0,10,0));
		GridPane.setConstraints(tfNAME, 1, 2, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10,0,10,0));
		GridPane.setConstraints(tfADD, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(0,0,0,0));
		GridPane.setConstraints(tfCITY, 1, 4, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10,0,10,0));
		GridPane.setConstraints(tfVEH, 1, 5, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10,0,10,0));
		GridPane.setConstraints(tfEID, 1, 8, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10,0,10,0));
				
		rbTW.setToggleGroup(tgRB);
		rbFW.setToggleGroup(tgRB);
		
		hbRB.setPrefSize(300, 30);
		hbRB.getChildren().setAll(rbTW, rbFW);
		hbRB.setSpacing(20);
		
		hbBtn.setPrefSize(300, 30);
		hbBtn.getChildren().setAll(btnN,btnS,btnU,btnD);
		hbBtn.setSpacing(20);
		
		
		GridPane.setConstraints(hbRB, 0, 11, 2, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(hbBtn, 0, 12, 2, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(10));

		grid.getChildren().addAll(logo, txtMOB, txtNAME, txtADD, txtCITY, txtVEH, txtEID, cbMOB, tfNAME, tfADD, tfCITY, tfVEH, tfEID, hbRB,hbBtn,btnSearch);
		grid.setGridLinesVisible(false);
		grid.setPadding(new Insets(100));
		grid.setStyle("-fx-background-color : moccasin");
		
		btnN.setOnAction(e->doclear());
		btnS.setOnAction(e->dosave());
		btnU.setOnAction(e->doupdate());
		btnSearch.setOnAction(e->dosearch());
		btnD.setOnAction(e->dodelete());
		fillmob();
		
		Scene scene = new Scene(grid, 700, 650);
		Stage stage=new Stage();
		stage.setScene(scene);
		stage.setTitle("PARKING ASSISTANT");
		stage.show();
	}
	
	void dodelete()
	{
		try
		{
			pst=con.prepareStatement("delete from customerconsole where mob=?");
			pst.setString(1, cbMOB.getSelectionModel().getSelectedItem());
			tfNAME.clear();
			tfCITY.clear();
			tfADD.clear();
			tfVEH.clear();
			tfEID.clear();
			rbFW.setSelected(false);
			rbTW.setSelected(false);
			
			int x = pst.executeUpdate();
			if(x==1)
			{
				alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("Record Deleted..");
				alert.show();
			}
			fillmob();
			System.out.println("Record Deleted..");
			pst.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	void dosearch()
	{
		
		try
		{
			pst = con.prepareStatement("select * from customerconsole where mob=?");
			pst.setString(1, cbMOB.getSelectionModel().getSelectedItem());
			ResultSet rs = pst.executeQuery();
		
			if(rs.next())
			{
				String name = rs.getString("name");
				String add = rs.getString("address");
				String city = rs.getString("city");
				String veh = rs.getString("veh");
				String eid = rs.getString("eid");
				String type = rs.getString("type");
				if(type.equals("Two Wheeler"))
					rbTW.setSelected(true);
				if(type.equals("Four Wheeler"))
					rbFW.setSelected(true);
				
				tfNAME.setText(name);
				tfADD.setText(add);
				tfCITY.setText(city);
				tfVEH.setText(veh);
				tfEID.setText(eid);
								
			}
			else
			{
				alert = new Alert(AlertType.WARNING);
				alert.setContentText("Invalid Mobile No...");
				alert.show();
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	void fillmob()
	{
		ArrayList<String>ary=new ArrayList<String>();
		try
		{
			pst=con.prepareStatement("select distinct mob from customerconsole" );
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String mob=rs.getString("mob");
				ary.add(mob);
				System.out.println(mob);
			}
			cbMOB.getItems().addAll(ary);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	void doupdate()
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
			pst = con.prepareStatement("update customerconsole set name=?,address=?,city=?,veh=?,eid=?,type=? where mob=?");
			pst.setString(7, cbMOB.getSelectionModel().getSelectedItem());
			pst.setString(1, tfNAME.getText());
			pst.setString(2, tfADD.getText());
			pst.setString(3, tfCITY.getText());
			pst.setString(4, tfVEH.getText());
			pst.setString(5, tfEID.getText());
			pst.setString(6, type);
			int x = pst.executeUpdate();
			if(x==1)
				{		
					alert=new Alert(AlertType.INFORMATION);
					alert.setContentText("Record Updated");
					alert.show();
				}
			
			pst.close();
			System.out.println("Record Updated...");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
		
	}
	
	public void doclear()
	{
		tfNAME.clear();
		tfCITY.clear();
		tfADD.clear();
		tfVEH.clear();
		tfEID.clear();
		cbMOB.getSelectionModel().clearSelection();
		cbMOB.setValue(null);
		if(rbTW.isSelected()==true)
		{
			rbTW.setSelected(false);
		}
		if(rbFW.isSelected()==true)
		{
			rbFW.setSelected(false);
		}
		System.out.println("Cleared..");
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
		pst = con.prepareStatement("insert into customerconsole values (?,?,?,?,?,?,?)");
		pst.setString(1, cbMOB.getSelectionModel().getSelectedItem());
		pst.setString(2, tfNAME.getText());
		pst.setString(3, tfADD.getText());
		pst.setString(4, tfCITY.getText());
		pst.setString(5, tfVEH.getText());
		pst.setString(6, tfEID.getText());
		pst.setString(7, type);
		int x = pst.executeUpdate();
		//pst.close();
		if(x==1)
			{		
				alert=new Alert(AlertType.INFORMATION);			
				alert.setContentText("Record Saved..");
				alert.show();
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Record Saved..");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}