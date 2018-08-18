package carparking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import JavaPro1.ShowTable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PPT extends Application 
{
	public void start(Stage stage) throws Exception 
	{
	}
	TableView<PP> tbl;
	//TextField txt=new TextField();
	//Button search=new Button("Search");
	Button btnshow=new Button("Show Parking Status");
	
	Connection con;
	PreparedStatement pst;
	void doConnect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("done");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carparking","root","");
			System.out.println("okee");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public PPT()
	{

	

		doConnect();
		// TODO Auto-generated method stub
		tbl=new TableView<>();
		
		TableColumn<PP, String>floor=new TableColumn<>("Floor No.");
		floor.setCellValueFactory(new PropertyValueFactory<>("floor"));
		floor.setMinWidth(100);

		TableColumn<PP, String>slot=new TableColumn<>("Total Slots");
		slot.setCellValueFactory(new PropertyValueFactory<>("slot"));
		slot.setMinWidth(100);

		TableColumn<PP, String>type=new TableColumn<>("Type");
		type.setCellValueFactory(new PropertyValueFactory<>("type"));
		type.setMinWidth(100);

		TableColumn<PP, String>booked=new TableColumn<>("Booked");
		booked.setCellValueFactory(new PropertyValueFactory<>("booked"));
		booked.setMinWidth(100);
		
		TableColumn<PP, String>free=new TableColumn<>("Free");
		free.setCellValueFactory(new PropertyValueFactory<>("free"));
		free.setMinWidth(100);
		
		tbl.getColumns().addAll(floor,slot,type,booked,free);
		tbl.setStyle("-fx-color:tan");
		
		
		ImageView logo=new ImageView(new Image(LoginForm.class.getResourceAsStream("1ppd.png")));
	
		btnshow.setStyle("-fx-font:12 arial;-fx-base:red");
		VBox vbox=new VBox();
		btnshow.setTranslateX(180);
		vbox.setSpacing(30);
		
		logo.setFitWidth(500);
		
		vbox.getChildren().addAll(logo,tbl,btnshow);
		
		btnshow.setOnAction(e->{tbl.setItems(getRows());});
		
		vbox.setStyle("-fx-background-color:slateblue");
		
		Scene scene=new Scene(vbox,500,500);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("PARKING ASSISTANT");
		stage.show();

	}
ObservableList<PP> getRows()
	{
		ObservableList<PP> lst=FXCollections.observableArrayList();
		try
		{
			pst=con.prepareStatement("select * from parkingplan");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				PP ref=new PP(rs.getString("floor"),rs.getString("slot"),rs.getString("type"),rs.getString("booked"),rs.getString("free"));
				lst.add(ref);
			}
			rs.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
}
