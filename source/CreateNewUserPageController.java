import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The CreateNewUserPageController Class which controls the
 * CreateNewUserPage.fxml This class creates a new user object thought the gui
 * and sets a default profile picture
 * 
 * @author Ming and Boris
 *
 */
public class CreateNewUserPageController {

	@FXML
	private BorderPane createNewUserPane;

	@FXML
	private TextField userID;

	@FXML
	private TextField name;

	@FXML
	private TextField mobileNumber;

	@FXML
	private TextField houseNumber;

	@FXML
	private TextField streetName;

	@FXML
	private TextField postcode;

	/**
	 * Calls the method which closes the window.
	 * 
	 * @param event
	 *            Clicking on the back button
	 */
	@FXML
	private void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * This method is called when the confirm button is clicked. It creates a
	 * new user object with the information filled in the text boxes.
	 * 
	 * @param event
	 */
	@FXML
	private void clickOnConfirm(ActionEvent event) {
		String username = this.userID.getText();
		String name = this.name.getText();
		String mobileNumber = this.mobileNumber.getText();
		String houseNumber = this.houseNumber.getText();
		String streetName = this.streetName.getText();
		String postcode = this.postcode.getText();
		String profilePic = "Avatar5.png";
		if (!Librarian.checkUserName(username)) {
			Librarian.addUser(new User(username, name, mobileNumber,
					houseNumber, streetName, postcode, profilePic));
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Done");
			alert.setContentText("New user created!");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Problem Found");
			alert.setContentText("This username already exist!\n"
					+ "Please change username!");
			alert.showAndWait();
		}

	}

	/**
	 * This method closes the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) createNewUserPane.getScene().getWindow();
		stage.close();
	}

}
