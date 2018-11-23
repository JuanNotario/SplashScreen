package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class controller {
	
	@FXML
	Label logoLabel ;

	@FXML
	Pane spinnerPane;

	@FXML
	AnchorPane rootPane;

	@FXML
	Label helloLabel;

	@FXML
	Label nameLabel;
	
	@FXML
	ImageView tiburonIzq;
	
	@FXML
	ImageView tiburonDer;
	
	public void showHome() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("siguientePantalla.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage homeStage = new Stage();
			homeStage.setTitle("Main Menu");
			Scene scene=new Scene(page);
			homeStage.setScene(scene);
			homeStage.show();
	

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialize() {

		TranslateTransition translateTransition = new TranslateTransition(
				Duration.seconds(0.1), logoLabel);
		translateTransition.setByY(700);
		translateTransition.play();

		TranslateTransition translateTransition0 = new TranslateTransition(
				Duration.seconds(0.1), nameLabel);
		translateTransition0.setByY(700);
		translateTransition0.play();

		TranslateTransition translateTransition00 = new TranslateTransition(
				Duration.seconds(0.1), helloLabel);
		translateTransition00.setByY(700);
		translateTransition00.play();
		
		TranslateTransition translateTransI = new TranslateTransition(
				Duration.seconds(0.1), tiburonIzq);
		translateTransI.setByX(-700);
		translateTransI.play();
		
		TranslateTransition translateTransD = new TranslateTransition(
				Duration.seconds(0.1), tiburonDer);
		translateTransD.setByX(+700);
		translateTransD.play();
		
		translateTransition.setOnFinished(event -> {
			TranslateTransition translateTransition1 = new TranslateTransition(
					Duration.seconds(1), logoLabel);
			translateTransition1.setByY(-700);
			
			translateTransition1.play();
			
			translateTransition1.setOnFinished(event1 -> {

				TranslateTransition translateTransition2 = new TranslateTransition(
						Duration.seconds(1), nameLabel);
				translateTransition2.setByY(-700);
				translateTransition2.play();
				
				translateTransition2.setOnFinished(event3 -> {
					TranslateTransition translateTransition111 = new TranslateTransition(
							Duration.seconds(1), helloLabel);
					translateTransition111.setByY(-700);
					translateTransition111.play();
					
					translateTransition111.setOnFinished(event4 -> {
						TranslateTransition translateTransition3 = new TranslateTransition(
								Duration.seconds(1), tiburonIzq);
						translateTransition3.setByX(700);
						translateTransition3.play();
						
						TranslateTransition translateTransition4 = new TranslateTransition(
								Duration.seconds(1), tiburonDer);
						translateTransition4.setByX(-700);
						translateTransition4.play();

					translateTransition3.setOnFinished(event5 -> {

						FadeTransition fadeTransition = new FadeTransition(
								Duration.seconds(3), spinnerPane);
						fadeTransition.setFromValue(0);
						fadeTransition.setToValue(1);
						fadeTransition.play();

						fadeTransition.setOnFinished(event6 -> {

							FadeTransition fadeTransition1 = new FadeTransition(
									Duration.seconds(2), rootPane);
							fadeTransition1.setFromValue(1);
							fadeTransition1.setToValue(0.1);
							fadeTransition1.play();

							fadeTransition1.setOnFinished(event7 -> {
					    	    Stage thisStage = (Stage) rootPane.getScene().getWindow();
					    	    thisStage.close();
								showHome();
							});

						});
					});
					});
				});
			});
		});
	}
}
