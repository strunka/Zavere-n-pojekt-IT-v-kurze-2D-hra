package sk.bernardkaminski.Bankomat_simulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Trieda spusta aplikaciu.
 * 
 * @author berni
 *
 */
public class BankomatFX extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("BankomatView.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Bankomat");
			primaryStage.getIcons().add(new Image("obrazky/credit-card.png"));
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
