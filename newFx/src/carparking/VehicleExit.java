package carparking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class VehicleExit extends Application
{
	
	Text txtTYPE,txtVEH,txtMOB,txtINDATE,txtOUTDATE,txtTWR,txtFWR,txtAMT;
	Button btnBILL,btnPRTBILL,btnCLEAR,btnSMS;
	RadioButton rbTW,rbFW;
	TextField tfMOB,tfTWR,tfFWR,tfAMT, tfINDATE;
	ComboBox<String> cbVEH;
	GridPane grd;
	DatePicker dp1;
	Connection con;
	PreparedStatement pst,pst1;
	
	public VehicleExit() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carparking","root","");
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar cal=Calendar.getInstance();
		//show current date
		/*dp=new DatePicker(LocalDate.of(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE)));

		dp.setStyle("-fx-font-size:12");
		dp.setPromptText("Select Date");
		
		dp.setLayoutX(50);
		dp.setLayoutY(50);*/
		
		dp1=new DatePicker(LocalDate.of(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE)));

		dp1.setStyle("-fx-font-size:12");
		dp1.setPromptText("Select Date");
		
		dp1.setLayoutX(50);
		dp1.setLayoutY(50);
		
		//dp1.setOnAction(value);
		
		grd=new GridPane();
		grd.setHgap(15);
		grd.setVgap(15);
		grd.setAlignment(Pos.CENTER);
		
		txtINDATE=new Text("In Date");
		txtINDATE.setFont(Font.font("ARIAL", FontWeight.BOLD, 18));
		txtINDATE.setFill(Color.ROYALBLUE);
		
		txtOUTDATE=new Text("Out Date");
		txtOUTDATE.setFont(Font.font("ARIAL", FontWeight.BOLD, 18));
		txtOUTDATE.setFill(Color.ROYALBLUE);
		
		txtVEH=new Text("Vehicle No.");
		txtVEH.setFont(Font.font("ARIAL", FontWeight.BOLD, 18));
		txtVEH.setFill(Color.ROYALBLUE);
		
		txtMOB=new Text("Mobile No./ID");
		txtMOB.setFont(Font.font("ARIAL", FontWeight.BOLD, 18));
		txtMOB.setFill(Color.ROYALBLUE);
		
		txtTWR=new Text("Two Wheeler Rate");
		txtTWR.setFont(Font.font("ARIAL", FontWeight.BOLD, 18));
		txtTWR.setFill(Color.ROYALBLUE);
		
		txtFWR=new Text("Four Wheeler Rate");
		txtFWR.setFont(Font.font("ARIAL", FontWeight.BOLD, 18));
		txtFWR.setFill(Color.ROYALBLUE);
		
		txtTYPE=new Text("Type");
		txtTYPE.setFont(Font.font("ARIAL", FontWeight.BOLD, 18));
		txtTYPE.setFill(Color.ROYALBLUE);
		
		txtAMT=new Text("Amount");
		txtAMT.setFont(Font.font("ARIAL", FontWeight.BOLD, 18));
		txtAMT.setFill(Color.ROYALBLUE);
		
		tfINDATE= new TextField();
		tfINDATE.setPromptText("Vehicle Entry Date");
		tfAMT=new TextField();
		tfAMT.setPromptText("Amount");
		tfMOB=new TextField();
		tfMOB.setPromptText("Mobile No.");
		tfTWR=new TextField();
		tfTWR.setPromptText("Two Wheeler Rate");
		tfFWR=new TextField();
		tfFWR.setPromptText("Four Wheeler Rate");
		
		ImageView logo=new ImageView(new Image(LoginForm.class.getResourceAsStream("1vex.png")));
		logo.setFitWidth(600);
		logo.setFitHeight(80);

		
		rbTW=new RadioButton("Two Wheeler");
		rbTW.setTextFill(Color.ROYALBLUE);
		
		rbFW=new RadioButton("Four Wheeler");
		rbFW.setTextFill(Color.ROYALBLUE);
		
		ToggleGroup grp=new ToggleGroup();
		rbTW.setToggleGroup(grp);
		rbFW.setToggleGroup(grp);
		
		rbTW.setStyle(("-fx-font: 15 arial;"));
		rbFW.setStyle("-fx-font: 15 arial;");
		
		cbVEH=new ComboBox<String>();
		cbVEH.setPromptText("select any vehicle number");
		
		btnBILL=new Button("Bill");
		btnBILL.setPrefSize(80,20);
		btnBILL.setStyle("-fx-font: 18 arial;-fx-base:maroon");
		
		btnPRTBILL=new Button("Print Bill");
		btnPRTBILL.setPrefSize(120,20);
		btnPRTBILL.setStyle("-fx-font: 18 arial;-fx-base:maroon");
		
		btnCLEAR=new Button("Clear");
		btnCLEAR.setPrefSize(80,20);
		btnCLEAR.setStyle("-fx-font: 18 arial;-fx-base:maroon");
		
		btnSMS = new Button("Send bill as SMS");
		btnSMS.setStyle("-fx-font: 18 arial;-fx-base:maroon");
				
		GridPane.setConstraints(logo,2,0,5,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(txtVEH,1,2,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(txtTYPE,1,1,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(txtMOB,1,3,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(txtINDATE,1,4,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(txtOUTDATE,3,4,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(tfINDATE,2,4,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(dp1,4,4,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(txtTWR,1,5,1,1,HPos.LEFT,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(txtFWR,3,5,1,1,HPos.LEFT,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(txtAMT,1,8,1,1,HPos.LEFT,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(btnBILL,2,7,1,1,HPos.LEFT,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(btnPRTBILL,2,9,1,1,HPos.LEFT,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(btnSMS, 4, 9, 1, 1, HPos.LEFT, VPos.CENTER, null, null, new Insets(15));
		GridPane.setConstraints(cbVEH,2,2,1,1,HPos.LEFT,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(rbTW,2,1,1,1,HPos.LEFT,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(rbFW,3,1,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(tfAMT,2,8,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(tfMOB,2,3,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(tfTWR,2,5,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(tfFWR,4,5,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		GridPane.setConstraints(btnCLEAR,3,9,1,1,HPos.CENTER,VPos.CENTER,null,null,new Insets(15));
		
		
		grd.getChildren().addAll(btnSMS,txtINDATE,txtOUTDATE,dp1,btnCLEAR,logo,txtVEH,txtMOB,txtTYPE,txtTWR,txtFWR,txtAMT,rbTW,rbFW,cbVEH,btnBILL,btnPRTBILL,tfAMT,tfMOB,tfTWR,tfFWR,tfINDATE);
		grd.setStyle("-fx-background-color:lightgreen");

		btnCLEAR.setOnAction(e->{doclear();});
		btnBILL.setOnAction(e->{calcbill();});
		rbTW.setOnAction(e->{showtw();});
		rbFW.setOnAction(e->{showfw();});
		
	
		
		cbVEH.setOnAction(e->{fetchmobdate();});
		
		Scene scene=new Scene(grd,900,600);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("PARKING ASSISTANT");
		stage.show();	
		stage.setMaximized(true);
		
		WritableImage image = scene.snapshot(null);
		btnPRTBILL.setOnAction(e->{print(image,stage);});
		btnSMS.setOnAction(e->{sendSMS();});
		rbTW.requestFocus();
	}
	public void showtw()
	{
		ArrayList<String> ary=new ArrayList<String>();
		cbVEH.getItems().clear();
		
		if(rbTW.isSelected()==true)
		{
			tfFWR.setDisable(true);
			tfTWR.setDisable(false);
		}

		try
		{
			pst = con.prepareStatement("select * from vehicleentry where type=? and status=1");
			pst.setString(1, rbTW.getText());
			ArrayList<String> arylist = new ArrayList<String>();
			ResultSet rs = pst.executeQuery();
		
			while(rs.next())
			{
				String veh = rs.getString("veh");			
				arylist.add(veh);
			}
			cbVEH.getItems().addAll(arylist);
			rs.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}		
	}

	public void showfw()
	{
		cbVEH.getItems().clear();
		
		if(rbFW.isSelected()==true)
		{
			tfTWR.setDisable(true);
			tfFWR.setDisable(false);
		}
		
		try
		{
			pst = con.prepareStatement("select * from vehicleentry where type=? and status=1");
			pst.setString(1, rbFW.getText());
			ArrayList<String> arylist = new ArrayList<String>();
			ResultSet rs = pst.executeQuery();
		
			while(rs.next())
			{
				String veh = rs.getString("veh");			
				arylist.add(veh);
			}
			cbVEH.getItems().addAll(arylist);
			rs.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}		
	}

	public void fetchmobdate()
	{
		try
		{
			pst = con.prepareStatement("select * from vehicleentry where veh=?");
			pst.setString(1, cbVEH.getSelectionModel().getSelectedItem());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				String mob = rs.getString("mob");
				tfMOB.setText(mob);
				
				String indate = rs.getString("indate");
				tfINDATE.setText(indate);
			}
			rs.close();			
		}
		catch(SQLException e)
		{
			
		}
	}
	
	public void calcbill()
	{
		try
		{
			LocalDate local = dp1.getValue();
			doSave(local);
			pst = con.prepareStatement("select datediff(outdate,indate) as days from vehicleentry");
			ResultSet rs = pst.executeQuery();
			int d=0;
			if(rs.next())
			{
			 d = Integer.parseInt(rs.getString("days"));
			}
			String bill ="";
			System.out.println(d);
			if(d==0)
			{				
				pst = con.prepareStatement("update vehicleentry set amount=? where mob=?");
				pst.setString(2, tfMOB.getText());
				if(rbTW.isSelected()==true)
				{
					bill = tfTWR.getText();
					tfAMT.setText(bill);
					pst.setString(1, bill);
				}
				if(rbFW.isSelected()==true)
				{
					bill = tfFWR.getText();
					tfAMT.setText(bill);
					pst.setString(1, bill);
				}
				pst.executeUpdate();
			}
			if(d>0)
			{
				int tot;
				pst = con.prepareStatement("update vehicleentry set amount=? where mob=?");
				pst.setString(2, tfMOB.getText());
				if(rbTW.isSelected()==true)
				{
					int twr = Integer.parseInt(tfTWR.getText());
					tot = d * twr;
					bill = String.valueOf(tot); 
					tfAMT.setText(bill);
					pst.setString(1, bill);
				}
				if(rbFW.isSelected()==true)
				{
					int fwr = Integer.parseInt(tfFWR.getText());
					tot = d * fwr;
					bill = String.valueOf(tot); 
					tfAMT.setText(bill);
					pst.setString(1, bill);
				}
				pst.executeUpdate();
			}
			pst = con.prepareStatement("update vehicleentry set status=0, floor=? where veh=?");
			pst.setString(1, null);
			pst.setString(2, cbVEH.getSelectionModel().getSelectedItem());
			pst.executeUpdate();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
		
	void doSave(LocalDate local)
	{
		try 
		{
			pst = con.prepareStatement("update vehicleentry set outdate=?,outtime=curtime() where mob=?");
			pst.setString(2, tfMOB.getText());
			java.sql.Date outd=java.sql.Date.valueOf(local);
			pst.setDate(1, outd);
			pst.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	void doclear()
	{
		cbVEH.getItems().clear();
		tfMOB.clear();
		tfTWR.clear();
		tfFWR.clear();
		tfAMT.clear();
		rbTW.setSelected(false);
		rbFW.setSelected(false);
	}
 	
	void sendSMS()
	{
	
		String msg=  sms.bceSunSoftSend(tfMOB.getText(), "YOUR BILL AMOUNT IS:"+tfAMT.getText());
		System.out.println(msg);
	}
	
	public void print(WritableImage writableImage, Stage primaryStage) {
        ImageView imageView =new ImageView(writableImage);
        Printer printer = Printer.getDefaultPrinter();
        PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
        double scaleX = pageLayout.getPrintableWidth() / imageView.getBoundsInParent().getWidth();
        double scaleY = pageLayout.getPrintableHeight() / imageView.getBoundsInParent().getHeight();
        imageView.getTransforms().add(new Scale(scaleX, scaleY));

        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            boolean successPrintDialog = job.showPrintDialog(primaryStage.getOwner());
            if(successPrintDialog){
                boolean success = job.printPage(pageLayout,imageView);
                if (success) {
                    job.endJob();
                }
            }
        }
   
    }
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}