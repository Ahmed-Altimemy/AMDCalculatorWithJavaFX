package application;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorControler {

	private String op = "";

	@FXML
	private TextField txtWrite;
	@FXML
	private TextField txtView;
	@FXML
	private Label lblMemory;
	@FXML
	private Label lblHistory;
	@FXML
	private Label lblTitle;
	@FXML
	private Button btnCE;
	@FXML
	private Button btnC;
	@FXML
	private Button btnDivision;
	@FXML
	private Button btnMultiplication;
	@FXML
	private Button btnSubtraction;
	@FXML
	private Button btnAddition;
	@FXML
	private Button btnEqual;
	@FXML
	private Button btnDot;
	@FXML
	private Button btn0;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btn7;
	@FXML
	private Button btn8;
	@FXML
	private Button btn9;
	@FXML
	private Button btnClearHistory;

	@FXML
	protected void getButtonID(ActionEvent e) throws ScriptException {
		Button btn = (Button) e.getSource();
		String id = btn.getId();
		String btntxt = btn.getText();
		String txtW = txtWrite.getText();
		String txtV = txtView.getText();

		switch (id) {
		case "btnCE":
			txtWrite.setText("");
			op = "";
			break;
		case "btnC":
			txtWrite.setText("");
			txtView.setText("");
			break;

		case "btnEqual":
			if (!txtWrite.getText().equals("")) {
				txtWrite.setText("");
				txtView.setText(txtV + txtW);
				ScriptEngineManager mgr = new ScriptEngineManager();
				ScriptEngine engine = mgr.getEngineByName("JavaScript");
				String expression = txtView.getText();
				Object Result = engine.eval(expression);
				txtView.setText(Result.toString());
				if (lblMemory.getText().trim().isEmpty())
					lblMemory.setText(expression + " = " + txtView.getText());
				else {
					lblMemory.setText(expression + " = " + txtView.getText() + "\r\n" + "==================" + "\r\n" + lblMemory.getText());
				}
				txtView.setText("");
				lblHistory.setVisible(true);
			}
			break;

		case "btnDivision":
		case "btnMultiplication":
		case "btnSubtraction":
		case "btnAddition":
			if (!txtWrite.getText().equals("")) {
				if (!btntxt.equals("") || btntxt.equals("/") || btntxt.equals("*") || btntxt.equals("-")
						|| btntxt.equals("+") || !btntxt.equals(".")) {
					txtWrite.setText("");
					op = btn.getText();

					txtV = txtView.getText();
					txtView.setText(txtV + txtW + op);
				}
			}
			break;
		case "btnDot":
		case "btn0":
		case "btn1":
		case "btn2":
		case "btn3":
		case "btn4":
		case "btn5":
		case "btn6":
		case "btn7":
		case "btn8":
		case "btn9":
			txtW = txtW + btntxt;
			txtWrite.setText(txtW);
			break;
		case "btnClearHistory":
			lblMemory.setText("");
			lblHistory.setVisible(false);
			break;
		default:
			break;
		}
	}

}
