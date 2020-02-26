import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <h1>Choose Avatar as Profile Picture.</h1> The ChooseAvatarPageController
 * Class which controls the ChooseAvatarPage.fxml
 * 
 * @author Ming and Boris
 * @version 1.0
 * @since 2018-12-03
 */
public class ChooseAvatarPageController {

	@FXML
	private BorderPane chooseAvatarPane;

	private Alert alert = new Alert(AlertType.INFORMATION);

	/**
	 * This method displays an alert box for when the User has selected an
	 * Avatar.
	 */
	public void showAlert() {
		alert.setTitle("Confirmation Message");
		alert.setHeaderText(null);
		alert.setContentText("Selected Avatar has been confirmed! "
				+ "Changes will have effect next time you log in!");
		alert.showAndWait();
	}

	private User curUser;

	/**
	 * This method sets/initializes the current User.
	 */
	@FXML
	public void initialize() {
		curUser = LoginController.getLoggedUser();
	}

	/**
	 * Actions will be made when the user clicks on the button. Sets up
	 * appropriate measures (opens necessary windows, etc) to allow the User to
	 * draw a custom avatar and save it as the preferred profile image.
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 * 
	 */
	@FXML
	public void clickOnDrawAvatar(ActionEvent event) {
		String[] args = null;
		Draw drawing = new Draw();
		// Scene browseAndSearchScene = new Scene(null,
		// Main.BROWSEANDSEARCHPAGE_WIDTH,
		// Main.BROWSEANDSEARCHPAGE_HEIGHT);
		Stage drawingStage = new Stage();
		drawing.start(drawingStage);
		// File image = new File("Avatar" + curUser.getUsername() + ".png");
		String pathToImage = ("Avatar" + curUser.getUsername() + ".png");
		curUser.setProfilePic(pathToImage);
		// showAlert();
	}

	/**
	 * Actions will be made when the user clicks on the button. Selection and
	 * setting of the first profile picture option. Displays appropriate alert
	 * box for indication to User.
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 */
	@FXML
	private void clickOnOK1(ActionEvent event) {
		String pathToImage = "Avatar1.png";
		curUser.setProfilePic(pathToImage);
		showAlert();
	}

	/**
	 * Actions will be made when the user clicks on the button. Selection and
	 * setting of the second profile picture option. Displays appropriate alert
	 * box for indication to User.
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 */
	@FXML
	private void clickOnOK2(ActionEvent event) {
		String pathToImage = "Avatar2.png";
		curUser.setProfilePic(pathToImage);
		showAlert();
	}

	/**
	 * Actions will be made when the user clicks on the button Selection and
	 * setting of the third profile picture option. Displays appropriate alert
	 * box for indication to User.
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 */
	@FXML
	private void clickOnOK3(ActionEvent event) {
		String pathToImage = "Avatar3.png";
		curUser.setProfilePic(pathToImage);
		showAlert();
	}

	/**
	 * Actions will be made when the user clicks on the button. Selection and
	 * setting of the fifth profile picture option. Displays appropriate alert
	 * box for indication to User.
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 */
	@FXML
	private void clickOnOK5(ActionEvent event) {
		String pathToImage = "Avatar5.png";
		curUser.setProfilePic(pathToImage);
		showAlert();
	}

	/**
	 * Actions will be made when the user clicks on the button. Selection and
	 * setting of the fourth profile picture option. Displays appropriate alert
	 * box for indication to User.
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 */
	@FXML
	private void clickOnOk4(ActionEvent event) {
		String pathToImage = "Avatar4.png";
		curUser.setProfilePic(pathToImage);
		showAlert();
	}

	/**
	 * Actions will be made when the user clicks on the button Returns to
	 * previous window by closing the current/most recent one.
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 */
	@FXML
	private void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * Close the window.
	 */
	@FXML
	private void closeWindow() {
		Stage stage = (Stage) chooseAvatarPane.getScene().getWindow();
		stage.close();
	}

}