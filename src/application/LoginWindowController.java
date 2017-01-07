package application;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LoginWindowController {
	
	@FXML private Button close_button;
	@FXML private Button minimize_button;
	@FXML private Button maximize_button;
	
	@FXML private TextField username_field;
	@FXML private PasswordField password_field;
	
	@FXML private Button login_button;
	@FXML private HBox titlebar;
	
	private static final double LOGIN_BUTTON_ORIGINAL_OPACITY = 1;
	private static final double LOGIN_BUTTON_HOVER_OPACITY = 0.75;
	
	private static final String USER = "testuser";
	private static final String PASS = "testpassword";
	
	public void registerStage(Stage stage) {
		EffectUtilities.makeDraggable(stage, titlebar);
	}
	
	@FXML
	private void loginButtonLighter() {
		FadeTransition ft = new FadeTransition(Duration.millis(250), login_button);
		ft.setFromValue(LOGIN_BUTTON_ORIGINAL_OPACITY);
		ft.setToValue(LOGIN_BUTTON_HOVER_OPACITY);
		ft.setCycleCount(1);
		ft.play();
	}
	
	@FXML
	private void loginButtonDarker() {
		FadeTransition ft = new FadeTransition(Duration.millis(250), login_button);
		ft.setFromValue(LOGIN_BUTTON_HOVER_OPACITY);
		ft.setToValue(LOGIN_BUTTON_ORIGINAL_OPACITY);
		ft.setCycleCount(1);
		ft.play();
	}
	
	@FXML
	private void handleKeyPress(KeyEvent event) {
		if(event.getCode() == KeyCode.ENTER)
			login();
	}
	
	@FXML
	private void login() {
		System.out.println("log in attempt...");
		System.out.println("Username: " + username_field.getText());
		System.out.println("Password: " + password_field.getText());
		if(username_field.getText().equals(USER) && password_field.getText().equals(PASS))
			System.out.println("Login successful!");
		else
			System.out.println("Login failed.");
	}
	
	@FXML
	private void close() {
		Stage stage = (Stage) close_button.getScene().getWindow();
	    // save/close/flush whatever resources
		System.out.println("close attempt");
	    stage.close();
	}
	
	@FXML
	private void minimize() {
		Stage stage = (Stage) minimize_button.getScene().getWindow();
	    // save/close/flush whatever resources
		System.out.println("minimize attempt");
	    stage.setIconified(true);
	}
	
	@FXML
	private void maximize() {
		Stage stage = (Stage) maximize_button.getScene().getWindow();
	    // save/close/flush whatever resources
		System.out.println("maximize attempt");
	    stage.setMaximized(true);
	}
}
