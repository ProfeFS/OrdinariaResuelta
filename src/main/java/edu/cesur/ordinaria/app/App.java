package edu.cesur.ordinaria.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;
	private static final String PATH="/edu/cesur/ordinaria/vista/";

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(PATH+"Inicio.fxml"));
		Parent root = fxmlLoader.load();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
	
	@Override
		public void stop() throws Exception {
			System.out.println("Cerrando app");
			super.stop();
		}

}