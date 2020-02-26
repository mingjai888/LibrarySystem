
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * <h1>User Requested Items Page Controller for GUI.</h1> The
 * UserRequestedItemsPageController Class which controls the
 * UserRequestedItemsPage.fxml
 * 
 * @author Ming and Boris
 * @version 1.0
 * @since 2018-12-05
 */
public class UserRequestedItemsPageController {

	@FXML
	private BorderPane requestedItemsPane;

	@FXML
	private ListView<String> requestedItemsList;

	private User curUser;

	/**
	 * This method gets called whenever the requested items paged is opened. It
	 * goes through the list of requested items of the user and displays them
	 * all.
	 */
	public void initialize() {
		curUser = LoginController.getLoggedUser();
		for (Copy copy : curUser.getRequestedItems()) {
			// returnRequestCopies.add(copy);
			Resource copyOf = copy.getResource();
			String copyProperties = (copyOf.getTitle() + ", " + copyOf.getYear()
					+ ". You have requested this on "
					+ copy.getDateRequested());
			requestedItemsList.getItems().add(copyProperties);
		}
	}

	/**
	 * Calls the method which closes the window.
	 * 
	 * @param event
	 *            Clicking on the back button.
	 */
	@FXML
	void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * This method closes the window.
	 */
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) requestedItemsPane.getScene().getWindow();
		stage.close();
	}
}
