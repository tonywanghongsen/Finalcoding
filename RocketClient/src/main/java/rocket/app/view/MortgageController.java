package rocket.app.view;


import java.awt.Button;
import java.awt.TextField;

import com.sun.xml.ws.org.objectweb.asm.Label;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

public class MortgageController {

	private MainApp mainApp;
	
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	
	//		TextBox  - 	
	//		TextBox  - 	
	//		TextBox  - 	
	//		ComboBox -	
	//		Labels   -  
	//		Button   -  
	//		Label    -  
	@FXML
    private TextField txtIncome;
	@FXML
    private TextField txtExpenses;
	@FXML
    private TextField txtCreditScore;
	@FXML
    private TextField txtHouseCost;
	@FXML
    private TextField txtDownPayment;
	@FXML
    private ComboBox<Integer> cmbTerm;
	@FXML
    private Label lblMortgagePayment;

	@FXML
	private Label Showerrow;
	@FXML
	private Button Loanpayment;
	@FXML
	private Button btnPayment;
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	
	@FXML
	private void initialize(){
		cmbTerm.getItems().addAll(15,30);
	}
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		
		lq.setdIncome(Double.parseDouble(txtIncome.getText()));
		lq.setdExpenses(Double.parseDouble(txtExpenses.getText()));
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		lq.setiTerm((int)cmbTerm.getSelectionModel().getSelectedItem());
		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		lq.setiDownPayment(Integer.parseInt(txtDownPayment.getText()));

		a.setLoanRequest(lq);

		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		double Piti;
		if(lRequest.getdIncome()*0.36- lRequest.getdExpenses()> lRequest.getdIncome()*0.28 ){
			Piti =  ((lRequest.getdIncome() * 0.36) - lRequest.getdExpenses());
		}
		else{
			Piti = lRequest.getdIncome()*0.28;
		}
		double payment = lRequest.getdPayment();
		String print;
		print = new DecimalFormat("#.##").format(payment);
		if(Piti>payment){
			Showerrow.setText(" you payment will be "+ print , "Your APR is" + String.valueOf(lRequest.getdRate())+"%");
		}else{
			Showerrow.setText(print);
		}
		ObservableList<String> list = FXCollections.observableArrayList("15 Year","30 Year");


		
		
		
	}
}
