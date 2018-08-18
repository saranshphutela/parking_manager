package carparking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PHT extends Application
{
	public void start(Stage stage) throws Exception 
	{
	}
	GridPane grd;
	Label lblvno,lbldf,lbldt;
	TextField dp,dp1,vno;
	Button btnsd,btnf; 
	//ComboBox<String>vno;
	TableView<PH>tbl;
	
	Connection con;
	PreparedStatement pst;
	
	public PHT() throws ClassNotFoundException, FileNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		try 
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carparking","root","");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		tbl=new TableView<>();
		
		TableColumn<PH,String>veh=new TableColumn<>("Vehicle No");
		veh.setCellValueFactory(new PropertyValueFactory<>("veh"));
		veh.setMinWidth(100);
		
		TableColumn<PH,String>type=new TableColumn<>("Wheeler Type");
		type.setCellValueFactory(new PropertyValueFactory<>("type"));
		type.setMinWidth(100);
		
		TableColumn<PH,String>mob=new TableColumn<>("Mobile No");
		mob.setCellValueFactory(new PropertyValueFactory<>("mob"));
		mob.setMinWidth(100);
		
		TableColumn<PH,String>floor=new TableColumn<>("Floor No.");
		floor.setCellValueFactory(new PropertyValueFactory<>("floor"));
		floor.setMinWidth(100);
		
		TableColumn<PH,Date>indate=new TableColumn<>("In Date");
		indate.setCellValueFactory(new PropertyValueFactory<>("indate"));
		indate.setMinWidth(100);
		
		TableColumn<PH,Time>intime=new TableColumn<>("In Time");
		intime.setCellValueFactory(new PropertyValueFactory<>("intime"));
		intime.setMinWidth(100);
		
		
		TableColumn<PH,Date>outdate=new TableColumn<>("Out Date");
		outdate.setCellValueFactory(new PropertyValueFactory<>("outdate"));
		outdate.setMinWidth(100);
		
		TableColumn<PH,Time>outtime=new TableColumn<>("Out Time");
		outtime.setCellValueFactory(new PropertyValueFactory<>("outtime"));
		outtime.setMinWidth(100);
		
		TableColumn<PH,String>amount=new TableColumn<>("Amount");
		amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
		amount.setMinWidth(100);
		
		TableColumn<PH,Integer>status=new TableColumn<>("Status");
		status.setCellValueFactory(new PropertyValueFactory<>("status"));
		status.setMinWidth(100);
		
		tbl.getColumns().addAll(veh,type,mob,floor,indate,intime,outdate,outtime,amount,status);
		
		ImageView img=new ImageView(new Image(new FileInputStream(new File("2ph.png"))));
		img.setFitWidth(600);
		
		grd=new GridPane();
		grd.setHgap(20);
		grd.setVgap(20);
		grd.setGridLinesVisible(false);
		grd.setAlignment(Pos.CENTER);
		
		btnsd=new Button("Show Details");
		btnsd.setPrefSize(100, 30);
		btnsd.setStyle("-fx-font: 12 arial;-fx-base:maroon");
		
		btnf=new Button("Fetch");
		btnf.setPrefSize(100, 30);
		btnf.setStyle("-fx-font: 18 arial;-fx-base:maroon");
		lblvno=new Label("Vehicle No");
		lblvno.setFont(Font.font("Arial",FontWeight.BOLD,15));
		lblvno.setTextFill(Color.ROYALBLUE);
		
		lbldf=new Label("Date From");
		lbldf.setFont(Font.font("Arial",FontWeight.BOLD,15));
		lbldf.setTextFill(Color.ROYALBLUE);
		
		lbldt=new Label("Date To");
		lbldt.setFont(Font.font("Arial",FontWeight.BOLD,15));
		lbldt.setTextFill(Color.ROYALBLUE);
		
		dp=new TextField();
		dp.setPromptText("date from...");
		dp1=new TextField();
		dp1.setPromptText("date to...");
		
		vno=new TextField();
		vno.setPromptText("vehicle number is..");
		btnsd.setOnAction(e->{dofetch();});
		btnf.setOnAction(e->{tbl.setItems(getRows());});
		

		GridPane.setConstraints(img,0,0,5,1,HPos.RIGHT,VPos.CENTER,null,null,new Insets(10));
		GridPane.setConstraints(lblvno,1,1,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(10));
		GridPane.setConstraints(lbldf,1,2,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(10));
		GridPane.setConstraints(lbldt,1,3,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(10));
		GridPane.setConstraints(btnsd,3,1,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(10));
		GridPane.setConstraints(btnf,3,3,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(10));
		GridPane.setConstraints(dp,2,2,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(10));
		GridPane.setConstraints(dp1,2,3,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(10));
		GridPane.setConstraints(vno,2,1,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(10));
		GridPane.setConstraints(tbl,1,4,5,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(10));
		
		grd.getChildren().addAll(img,tbl,lblvno,lbldf,lbldt,btnsd,btnf,vno,dp,dp1);
		grd.setStyle("-fx-background-color:moccasin");
		Scene scene=new Scene(grd,800,500);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("PARKING ASSISTANT");
		stage.setMaximized(true);
		stage.show();
	}
	
	ArrayList<String> ary=new ArrayList<String>();
	
	
	void dofetch()
	{
		try{
			pst=con.prepareStatement("select * from vehicleentry where veh=?");
			pst.setString(1, vno.getText());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				String df=rs.getString("indate");
				String dt=rs.getString("outdate");
				
				dp.setText(df);
				dp1.setText(dt);
			}
			else
			{
				System.out.println("invalid id");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	ObservableList<PH>getRows()
	{
		ObservableList<PH>lst=FXCollections.observableArrayList();
		try{
			pst=con.prepareStatement("select * from vehicleentry where veh=?");
			pst.setString(1,vno.getText());
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				PH ref=new PH(rs.getString("veh"),rs.getString("type"),rs.getString("mob"),rs.getString("floor"),rs.getDate("indate"),rs.getTime("intime"),rs.getDate("outdate"),rs.getTime("outtime"),rs.getString("amount"),rs.getInt("status"));
				lst.add(ref);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return lst;
	}


}