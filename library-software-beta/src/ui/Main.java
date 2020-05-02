package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import model.*;

public class Main extends Application{
	
	private LibraryGUI lgui;
	private Library library;
	
	public Main() throws IOException {
		library = new Library();
		lgui = new LibraryGUI(library);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("welcome.fxml"));
		fxmlLoader.setController(lgui);		
		Parent root = fxmlLoader.load();	
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Library Software");
		primaryStage.show();
	}

}
