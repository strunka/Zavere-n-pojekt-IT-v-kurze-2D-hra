package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Database.DB;
import Database.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class SnakeFxController implements Initializable {

	@FXML
	private TextArea textArea;

	Game game;
	DB db = new DB();

	@FXML
	public void btnNewGame(ActionEvent event) {
		game = new Game();
		game.run();

		// db.addNewPlayer(new Player("Jozko", 4));
		// db.removePlayer(new Player("Karol", 4));

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<Player> players = db.getAllPlayers();
		String result = "";
		int lineCounter = 0;
		for (Player player : players) {
			lineCounter++;
			result += lineCounter + ". 	" + player.getMeno() + "	" + player.getScore() + "\n";
			System.out.println(lineCounter + ". " + player.getMeno() + " " + player.getScore());
		}
		textArea.setText(result);
	}
}
