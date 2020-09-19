package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Database.DB;
import Database.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class SnakeFxController implements Initializable {

	@FXML
	private TextArea textArea;

	private Game game;
	private DB db = new DB();
	private ArrayList<Player> players;
	private String playerName;

	@FXML
	public void btnNewGame(ActionEvent event) {
		playerName = JOptionPane.showInputDialog("Zadaj hracske meno");
		game = new Game(playerName);
		game.run();
		setTextArea();
	}

	@FXML
	public void btnReset(ActionEvent event) {
		for (Player player : players) {
			db.removePlayer(new Player(player.getMeno()));
		}
		setTextArea();
	}

	@FXML
	public void btnRefresh(ActionEvent event) {
		setTextArea();
	}

	@FXML
	public void btnQuit(ActionEvent event) {
		System.exit(0);
	}

	public void setTextArea() {
		players = db.getAllPlayers();
		String result = "";
		int lineCounter = 0;
		for (Player player : players) {
			lineCounter++;
			result += lineCounter + ". 	" + player.getMeno() + "	" + player.getScore() + "\n";
			System.out.println(lineCounter + ". " + player.getMeno() + " " + player.getScore());
		}
		textArea.setText(result);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setTextArea();
	}
}
