package sk.bernardkaminski.Bankomat_simulator;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * Podla MVC modelu trieda BankomatController nastavuje a pridava funkcionalitu,
 * styl a ovladanie Bankomatu.
 * 
 * @author berni
 *
 */
public class BankomatController implements Initializable {

	@FXML
	private AnchorPane anchor;
	@FXML
	private TextField textField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private TextArea obrazovka;

	@FXML
	private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
	@FXML
	private Button btnDot, btnCE;
	@FXML
	private Button btnA, btnB, btnC;

	@FXML
	private Button ONsvetlo;
	@FXML
	private Button OFFsvetlo;

	private Banka banka = new Banka();
	private Bankomat bankomat = new Bankomat(banka);

	/**
	 * Ziskava udaje/cisla z obrazovky.
	 * 
	 * @param event event klavesnica
	 */
	@FXML
	public void handleButtonAction(ActionEvent event) {

		if (event.getSource() == btn1) {
			textField.setText(textField.getText() + btn1.getText());
			passwordField.setText(passwordField.getText() + btn1.getText());
		} else if (event.getSource() == btn2) {
			textField.setText(textField.getText() + btn2.getText());
			passwordField.setText(passwordField.getText() + btn2.getText());
		} else if (event.getSource() == btn3) {
			textField.setText(textField.getText() + btn3.getText());
			passwordField.setText(passwordField.getText() + btn3.getText());
		} else if (event.getSource() == btn4) {
			textField.setText(textField.getText() + btn4.getText());
			passwordField.setText(passwordField.getText() + btn4.getText());
		} else if (event.getSource() == btn5) {
			textField.setText(textField.getText() + btn5.getText());
			passwordField.setText(passwordField.getText() + btn5.getText());
		} else if (event.getSource() == btn6) {
			textField.setText(textField.getText() + btn6.getText());
			passwordField.setText(passwordField.getText() + btn6.getText());
		} else if (event.getSource() == btn7) {
			textField.setText(textField.getText() + btn7.getText());
			passwordField.setText(passwordField.getText() + btn7.getText());
		} else if (event.getSource() == btn8) {
			textField.setText(textField.getText() + btn8.getText());
			passwordField.setText(passwordField.getText() + btn8.getText());
		} else if (event.getSource() == btn9) {
			textField.setText(textField.getText() + btn9.getText());
			passwordField.setText(passwordField.getText() + btn9.getText());
		} else if (event.getSource() == btn0) {
			textField.setText(textField.getText() + btn0.getText());
			passwordField.setText(passwordField.getText() + btn0.getText());
		} else if (event.getSource() == btnCE) {
			textField.setText("");
			passwordField.setText("");
		} else if (event.getSource() == btnDot) {
			if (!textField.getText().contains(".") && !textField.getText().isEmpty())
				textField.setText(textField.getText() + btnDot.getText());
		}
	}

	@FXML
	public void btnA(ActionEvent event) {
		if (bankomat.getStav() == Bankomat.START) {
			bankomat.nastavKlientskeCislo(Integer.parseInt(textField.getText()));
			textField.setText("");
			nastavObrazovku();
			textField.setVisible(false);
			passwordField.setVisible(true);
			passwordField.setText("");
		} else if (bankomat.getStav() == Bankomat.PIN) {
			bankomat.nastavKlienta(Integer.parseInt(passwordField.getText()));
			textField.setText("");
			passwordField.setVisible(false);
			textField.setVisible(true);
			nastavObrazovku();
		} else if (bankomat.getStav() == Bankomat.UCET) {
			bankomat.nastavTypUctu(Bankomat.BEZNY);
			textField.setText("");
			nastavObrazovku();
		} else if (bankomat.getStav() == Bankomat.TRANSAKCIA) {
			bankomat.vyber(Double.parseDouble(textField.getText()));
			bankomat.nastavPredchadzajuciStav();
			textField.setText("");
			nastavObrazovku();
		}
	}

	@FXML
	public void btnB(ActionEvent event) {
		if (bankomat.getStav() == Bankomat.UCET) {
			bankomat.nastavTypUctu(Bankomat.SPORIACI);
			textField.setText("");
			nastavObrazovku();
		} else if (bankomat.getStav() == Bankomat.TRANSAKCIA) {
			bankomat.vloz(Double.parseDouble(textField.getText()));
			bankomat.nastavPredchadzajuciStav();
			textField.setText("");
			nastavObrazovku();
		}
	}

	@FXML
	public void btnC(ActionEvent event) {
		if (bankomat.getStav() == Bankomat.UCET) {
			bankomat.reset();
			textField.setText("");
			nastavObrazovku();
		} else if (bankomat.getStav() == Bankomat.TRANSAKCIA) {
			bankomat.nastavPredchadzajuciStav();
			textField.setText("");
			nastavObrazovku();
		}
	}

	/**
	 * Meni farbu na obrazovke a na klavesnicy.
	 * 
	 * @param event event tlac/zmena farby
	 */
	@FXML
	public void ONsvetlo(ActionEvent event) {
		obrazovka.setStyle(
				"-fx-control-inner-background:#80FF00; -fx-font-family: Consolas; -fx-highlight-fill: #425A44; "
						+ "-fx-highlight-text-fill: #9CD2B2; -fx-text-fill: #425A44; ");
		textField.setStyle(
				"-fx-control-inner-background:#80FF00; -fx-font-family: Consolas; -fx-highlight-fill: #425A44; "
						+ "-fx-highlight-text-fill: #9CD2B2; -fx-text-fill: #425A44; ");
		passwordField.setStyle(
				"-fx-control-inner-background:#80FF00; -fx-font-family: Consolas; -fx-highlight-fill: #425A44; "
						+ "-fx-highlight-text-fill: #9CD2B2; -fx-text-fill: #425A44; ");

		btn1.setStyle("-fx-text-fill: #9CD2B2;");
		btn2.setStyle("-fx-text-fill: #9CD2B2;");
		btn3.setStyle("-fx-text-fill: #9CD2B2;");
		btn4.setStyle("-fx-text-fill: #9CD2B2;");
		btn5.setStyle("-fx-text-fill: #9CD2B2;");
		btn6.setStyle("-fx-text-fill: #9CD2B2;");
		btn7.setStyle("-fx-text-fill: #9CD2B2;");
		btn8.setStyle("-fx-text-fill: #9CD2B2;");
		btn9.setStyle("-fx-text-fill: #9CD2B2;");
		btn0.setStyle("-fx-text-fill: #9CD2B2;");
		btnCE.setStyle("-fx-text-fill: #9CD2B2;");
		btnDot.setStyle("-fx-text-fill: #9CD2B2;");
	}

	/**
	 * Meni farbu na obrazovke a na klavesnicy.
	 * 
	 * @param event event tlac/zmena farby
	 */
	@FXML
	void OFFsvetlo(ActionEvent event) {
		obrazovka.setStyle(
				"-fx-control-inner-background:#787D69; -fx-font-family: Consolas; -fx-highlight-fill: #425A44; "
						+ "-fx-highlight-text-fill: #9CD2B2; -fx-text-fill: #425A44; ");
		textField.setStyle(
				"-fx-control-inner-background:#787D69; -fx-font-family: Consolas; -fx-highlight-fill: #425A44; "
						+ "-fx-highlight-text-fill: #9CD2B2; -fx-text-fill: #425A44; ");
		passwordField.setStyle(
				"-fx-control-inner-background:#787D69; -fx-font-family: Consolas; -fx-highlight-fill: #425A44; "
						+ "-fx-highlight-text-fill: #9CD2B2; -fx-text-fill: #425A44; ");

		btn1.setStyle("-fx-text-fill: #425A44;");
		btn2.setStyle("-fx-text-fill: #425A44;");
		btn3.setStyle("-fx-text-fill: #425A44;");
		btn4.setStyle("-fx-text-fill: #425A44;");
		btn5.setStyle("-fx-text-fill: #425A44;");
		btn6.setStyle("-fx-text-fill: #425A44;");
		btn7.setStyle("-fx-text-fill: #425A44;");
		btn8.setStyle("-fx-text-fill: #425A44;");
		btn9.setStyle("-fx-text-fill: #425A44;");
		btn0.setStyle("-fx-text-fill: #425A44;");
		btnCE.setStyle("-fx-text-fill: #425A44;");
		btnDot.setStyle("-fx-text-fill: #425A44;");
	}

	/**
	 * nastavy text na obrazovke.
	 */
	private void nastavObrazovku() {
		int stav = bankomat.getStav();
		if (stav == Bankomat.START)
			obrazovka.setText("Zadaj klientske cislo\nA = OK");
		if (stav == Bankomat.PIN)
			obrazovka.setText("Zadaj PIN\nA = OK");
		if (stav == Bankomat.UCET)
			obrazovka.setText("Zvol ucet:\nA = Bezny ucet\nB = Sporiaci ucet\nC = Koniec");
		if (stav == Bankomat.TRANSAKCIA)
			obrazovka.setText("Aktualny zostatok: " + bankomat.getAktualnyZostatok()
					+ " EUR\nZadaj ciastku a zvol operaciu:\nA = Vyber\nB = Vklad\nC = Krok spat");
	}

	/**
	 * Nastavy a na stiluje tlacitka a, b, c.
	 */
	public void tlacitkaStyl() {
		btnA.setStyle("-fx-background-color: #07954A; -fx-background-radius: 8,7,6;");
		btnB.setStyle("-fx-background-color: #C6B900; -fx-background-radius: 8,7,6;");
		btnC.setStyle("-fx-background-color: #CB2026; -fx-background-radius: 8,7,6;");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			tlacitkaStyl();
			obrazovka.setText("Zadaj klientske cislo\nA = OK");
			banka.nacitajKlientov("klienti.txt");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Subor sa nenasiel.");
			System.exit(0);
		}
	}

}
