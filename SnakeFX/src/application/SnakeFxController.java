package application;

import java.net.URL;
import java.util.ResourceBundle;

import Database.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class SnakeFxController implements Initializable {

	@FXML
	private TextArea textAreaScore;

	Game game;
	DB db = new DB();

	@FXML
	public void btnNewGame(ActionEvent event) {
		game = new Game();
		game.run();

		db.addPlayer("Rolo", 2);

		db.showPlayersMeta();
		System.out.println();
		db.showAllPlayers();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
