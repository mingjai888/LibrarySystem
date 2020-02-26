import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This class is used to display all the items reserved for the currently logged
 * user.
 * 
 * @author Ming and Boris
 * @version 1.0
 * @since 2018-12-04
 */
public class UserReservedItemsPageController {

	@FXML
	private BorderPane reservedItemsPane;

	@FXML
	private ListView<String> reservedItemsList = new ListView<>();

	private User curUser;

	/**
	 * This method is called whenever the reserved items page is opened. It goes
	 * through all the items that have been reserved for the user and displays
	 * them all.
	 */
	public void initialize() {
		curUser = LoginController.getLoggedUser();
		for (Copy copy : curUser.getReservedFor()) {
			// returnRequestCopies.add(copy);
			Resource copyOf = copy.getResource();
			String copyProperties = (copyOf.getTitle() + ", " + copyOf.getYear()
					+ ". This has been reserved for you on "
					+ copy.getDateRequested());
			reservedItemsList.getItems().add(copyProperties);
		}
	}

	/**
	 * Calls the method which closes the window.
	 * 
	 * @param event
	 *            Clicking the back button.
	 */
	@FXML
	void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * This method closes the window.
	 */
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) reservedItemsPane.getScene().getWindow();
		stage.close();
	}
}