import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Class the controls the Receive Return Page.
 * 
 * @author Kyriacos Mosphilis and Boris Andreev.
 * @version 1.0
 */
public class RecieveReturnPageController {

	@FXML
	private BorderPane recieveReturnPane;

	@FXML
	private TextField userID;

	@FXML
	private TextField item;

	/**
	 * This method is called whenever the librarian clicks on the receive
	 * button. It checks if the strings entered in the fields are correct and if
	 * the user has this item borrowed. If everything is correct the
	 * receiveReturn method is called in the librarian class.
	 * 
	 * @param event
	 *            Mouse click on Receive button.
	 */
	@FXML
	private void clickOnRecieve(ActionEvent event) {
		String username = this.userID.getText();
		String item = this.item.getText();
		try {
			Librarian.receiveReturn(username, item);
		} catch (NullPointerException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Error!");
			alert.setContentText("This user does not have this item!");
			alert.showAndWait();
		}
	}

	/**
	 * Method to close the window.
	 * 
	 * @param event
	 *            Mouse click on Back button.
	 */
	@FXML
	private void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * Method to close the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) recieveReturnPane.getScene().getWindow();
		stage.close();
	}
}
