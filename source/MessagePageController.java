import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * <h1>Message Pane Controller class for the GUI.</h1> The MessagePaneController
 * class controls the MessagePage.fxml
 * 
 * @author Ming
 * @version 1.0
 * @since 2018-12-05
 */
public class MessagePageController {

	@FXML
	private BorderPane messagePane;

	@FXML
	private ListView<String> messageList;

	private User curUser;

	/**
	 * Obtains all all user messages accordingly and stores them into
	 * log/messageList.
	 */
	public void initialize() {
		curUser = LoginController.getLoggedUser();
		Collections.reverse(curUser.getMessages());
		for (int i = 0; i < curUser.getMessages().size(); i++) {
			messageList.getItems().add(curUser.getMessages().get(i));
		}
	}

	/**
	 * Actions will be made when the user clicks on the button. Returns to
	 * previous window by closing the current/most recent one.
	 * 
	 * @param event
	 */
	@FXML
	private void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * This method closes the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) messagePane.getScene().getWindow();
		stage.close();
	}
}
