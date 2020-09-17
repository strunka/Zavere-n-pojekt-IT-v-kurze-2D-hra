package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class SnakeFxController implements Initializable {

	@FXML
	private TextArea textAreaScore;

	Game game;

	@FXML
	public void btnNewGame(ActionEvent event) {
		game = new Game(textAreaScore);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
