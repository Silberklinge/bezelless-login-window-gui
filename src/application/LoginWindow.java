package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader root = new FXMLLoader(getClass().getResource("LoginWindow.fxml"));
        Scene scene = new Scene((Parent) root.load(), 600, 600);

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        
        LoginWindowController controller = (LoginWindowController) root.getController();
        controller.registerStage(primaryStage);
        
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
