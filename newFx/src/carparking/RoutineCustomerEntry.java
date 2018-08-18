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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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

public class RoutineCustomerEntry extends Application
{
	Connection con;
	PreparedStatement pst,pst2;
	public void start(Stage stage) throws Exception
	{
	
	}
	
	Label txtVEH, txtTYPE, txtMOB, txtFL, txtTOT, txtEMPTY;
	TextField tfMOB, tfTOT, tfEMPTY;
	ComboBox<String> cbFL,tfVEH;
	Button btnDONE, btnFETCH, btnNEW;
	ToggleGroup tgRB;
	RadioButton rbTW, rbFW;
	GridPane grid;
	HBox hbDONE, hbRB, hbFETCH;
	Alert alert;
	int count=0;
	
	public RoutineCustomerEntry()
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
		
		
		ImageView logo=new ImageView(new Image(LoginForm.class.getResourceAsStream("1ce.png")));
		logo.setFitWidth(500);
		logo.setFitHeight(80);
		
		txtVEH = new Label("Vehicle No.");
		txtTYPE = new Label("Type");
		txtMOB = new Label("Mobile");
		txtFL = new Label("Floor No.");
		txtTOT = new Label("Total Slots");
		txtEMPTY = new Label("Empty Slots");
		
		txtVEH.setStyle("-fx-font: 18 arial;");
		txtTYPE.setStyle("-fx-font: 18 arial;");
		txtMOB.setStyle("-fx-font: 18 arial;");
		txtFL.setStyle("-fx-font: 18 arial;");
		txtTOT.setStyle("-fx-font: 18 arial;");
		txtEMPTY.setStyle("-fx-font: 18 arial;");
		
		txtVEH.setTextFill(Color.ROYALBLUE);
		txtTYPE.setTextFill(Color.ROYALBLUE);
		txtMOB.setTextFill(Color.ROYALBLUE);
		txtFL.setTextFill(Color.ROYALBLUE);
		txtTOT.setTextFill(Color.ROYALBLUE);
		txtEMPTY.setTextFill(Color.ROYALBLUE);
		
		
		rbTW = new RadioButton("Two Wheeler");
		rbTW.setFont(Font.font(STYLESHEET_CASPIAN));
		rbFW = new RadioButton("Four Wheeler");
		rbFW.setFont(Font.font(STYLESHEET_CASPIAN));
		
		rbTW.setTextFill(Color.ROYALBLUE);
		rbFW.setTextFill(Color.ROYALBLUE);
		
		rbTW.setStyle(("-fx-font: 12 arial;"));
		rbFW.setStyle("-fx-font: 12 arial;");
		
		
		tfVEH = new ComboBox<String>();
		tfMOB = new TextField();
		tfTOT = new TextField();
		tfTOT.setPrefWidth(60); 
		tfEMPTY = new TextField();
		tfEMPTY.setPrefWidth(60);
		
		tgRB = new ToggleGroup();
		
		cbFL = new ComboBox<String>();
		cbFL.setEditable(true);
		
		btnDONE = new Button("Done");
		btnFETCH = new Button("Fetch");
		btnNEW = new Button("New");
		
		btnDONE.setStyle("-fx-font: 18 arial;-fx-base:maroon");
		btnFETCH.setStyle("-fx-font: 18 arial;-fx-base:maroon");
		btnNEW.setStyle("-fx-font: 18 arial;-fx-base:maroon");
		
		grid = new GridPane();
		
		hbDONE = new HBox();
		hbDONE.setPrefSize(150, 30);
		hbDONE.setSpacing(50);
		hbDONE.getChildren().addAll(btnDONE,btnNEW);
		
		hbFETCH = new HBox();
		hbFETCH.setPrefSize(60, 30);
		hbFETCH.getChildren().add(btnFETCH);
		
		hbRB= new HBox();
		rbTW.setToggleGroup(tgRB);
		rbFW.setToggleGroup(tgRB);
		hbRB.setPrefSize(300, 30);
		hbRB.getChildren().setAll(rbTW, rbFW);
		hbRB.setSpacing(20);
		
		GridPane.setConstraints(logo, 0, 0, 3, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtVEH, 0, 1, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtTYPE, 0, 2, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtMOB, 0, 3, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtFL, 0, 4, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtTOT, 0, 5, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(txtEMPTY, 1, 5, 1, 1, HPos.RIGHT, VPos.CENTER, null, null, new Insets(10));
		
		
		GridPane.setConstraints(tfVEH, 1, 1, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(tfMOB, 1, 3, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(tfTOT, 1, 5, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(0,120,0,10));
		GridPane.setConstraints(tfEMPTY, 2, 5, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(0,120,0,10));
		
		GridPane.setConstraints(hbDONE, 1, 6, 2, 1, HPos.CENTER, VPos.CENTER, null, null, new Insets(10,0,10,60));
		GridPane.setConstraints(hbRB, 1, 2, 2, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		GridPane.setConstraints(hbFETCH, 2, 1, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		
		GridPane.setConstraints(cbFL, 1, 4, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(10));
		
		
		grid.getChildren().addAll( hbRB,tfVEH,tfMOB,tfTOT,tfEMPTY,cbFL,logo,txtVEH,txtTYPE,txtMOB,txtFL,txtTOT,txtEMPTY,hbDONE,hbFETCH);
		grid.setGridLinesVisible(false);
		grid.setPadding(new Insets(100));
		grid.setStyle("-fx-background-color:palegreen");
		
		btnFETCH.setOnAction(e->dofetch());
		cbFL.setOnAction(e->showslots());
		btnDONE.setOnAction(e->dodone());
		btnNEW.setOnAction(e->donew());
		tfVEH.setOnAction(e->{dofillveh();});
		tfVEH.setEditable(true);
		
		Scene scene = new Scene(grid,650,550);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("PARKING ASSISTANT");
		stage.show();		
	}
	
	void dofillveh()
	{
		//int i=0;
		ArrayList<String>ary=new ArrayList<String>();
		try
		{tfVEH.getEditor().getText();
			tfVEH.getItems().clear();
			//String ss=tfVEH.getEditor().getText();
			
			tfVEH.show();
			//System.out.println("-"+ss);
			pst=con.prepareStatement("select distinct veh from vehicleentry where veh like '%"+tfVEH.getEditor().getText()+"%'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String veh=rs.getString("veh");
				ary.add(veh);
				System.out.println(veh);
			}
			
			tfVEH.getItems().addAll(ary);
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public void donew()
	{
		
		
		tfVEH.getSelectionModel().clearSelection();
		tfMOB.clear();
		tfEMPTY.clear();
		tfTOT.clear();
		cbFL.getSelectionModel().clearSelection();
		cbFL.getItems().clear();
		rbTW.setSelected(false);
		rbFW.setSelected(false);
		
		System.out.println("\n\nCleared..\n\n");
		
		alert = new Alert(AlertType.INFORMATION);
		alert.setContentText("Cleared..");
		alert.show();
	}

	public void dodone()
	{
		try
		{
			String type ="";
			if(rbTW.isSelected())
			{
				type="Two Wheeler";
			}
			if(rbFW.isSelected())
			{
				type="Four Wheeler";
			}
			pst=con.prepareStatement("insert into vehicleentry(mob,veh,type,indate,intime,status,floor) values(?,?,?,curdate(),curtime(),?,?)");
			pst.setString(1, tfMOB.getText());
			pst.setString(2, tfVEH.getSelectionModel().getSelectedItem());
			pst.setString(3, type);
			pst.setString(4, "1");
			pst.setString(5, cbFL.getSelectionModel().getSelectedItem());
			int rrr=pst.executeUpdate();
			if(rrr==1)
			{
				System.out.println("inserted");
				pst = con.prepareStatement("update parkingplan set booked=booked+1,free=free-1 where floor=? and slot>booked");
				pst.setString(1, cbFL.getSelectionModel().getSelectedItem());

				int res=pst.executeUpdate();
				if(res==1)	
					{
						System.out.println("Booked ");
					}
			}
		}
		catch (SQLException e)
		{
			System.out.println("Vehicle is parked already..");
			alert = new Alert(AlertType.WARNING);
			alert.setContentText("Vehicle already exist..");
			alert.show();
			//e.printStackTrace();
		}
	}

	public void showslots()
	{
		try
		{
			pst = con.prepareStatement("select * from parkingplan where floor=? ");
			pst.setString(1, cbFL.getSelectionModel().getSelectedItem());
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
					String slots = rs.getString("slot");
					tfTOT.setText(slots);
					String freee = rs.getString("free");
					tfEMPTY.setText(freee);
			}			
		}		
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void dotw_fl()
	{
		cbFL.getItems().clear();
		try
		{
			pst = con.prepareStatement("select * from parkingplan where type=? and slot>booked");
			pst.setString(1, rbTW.getText());
			ArrayList<String> arylist = new ArrayList<String>();
			ResultSet rs = pst.executeQuery();
		
			while(rs.next())
			{
				String floor = rs.getString("floor");			
				arylist.add(floor);
			}
			cbFL.getItems().addAll(arylist);
			rs.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}		
	}

	public void dofw_fl()
	{
		cbFL.getItems().clear();
		try
		{
			pst = con.prepareStatement("select * from parkingplan where type=?");
			pst.setString(1, rbFW.getText());
			ArrayList<String> arylist = new ArrayList<String>();
			ResultSet rs = pst.executeQuery();
		
			while(rs.next())
			{
				String floor = rs.getString("floor");			
				arylist.add(floor);
			}
			cbFL.getItems().addAll(arylist);
			rs.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}		
	}

	public void dofetch()
	{
		
		try 
		{
			pst = con.prepareStatement("select * from customerconsole where veh=?");						
			pst.setString(1, tfVEH.getSelectionModel().getSelectedItem());
			
			ResultSet rs = pst.executeQuery();
			//ResultSet rs2 = pst2.executeQuery();
			
			if(rs.next())
			{
				String type = rs.getString("type");
				if(type.equals("Two Wheeler"))
				{
					rbTW.setSelected(true);
					dotw_fl();
				}
				if(type.equals("Four Wheeler"))
				{
					rbFW.setSelected(true);
					dofw_fl();
				}
					
				String mob = rs.getString("mob");
				tfMOB.setText(mob);
				
				if(rbTW.isSelected()==true)
				{
					rbFW.setDisable(true);
				}
				if(rbFW.isSelected()==true)
				{
					rbTW.setDisable(true);
				}
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
			e.printStackTrace();
		}				
	}	
}