import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The UserBorrowedItemsPageController which controls the
 * UserBorrowedItemsPage.fxml
 * 
 * @author Ming and Boris
 *
 */
public class UserBorrowedItemsPageController {
	private ArrayList<Copy> returnRequestCopies = new ArrayList<>();
	@FXML
	private BorderPane borrowedItemsPane;

	@FXML
	private ListView<String> borrowedItemsList;

	@FXML
	private Button requestToReturn;

	private User curUser;

	/**
	 * This method gets called whenever the user wants to see which items they
	 * have borrowed. It goes through their list of borrowed items and displays
	 * every item they have currently taken home. If some of the items have a
	 * due date set then this is shown as well.
	 */
	public void initialize() {
		curUser = LoginController.getLoggedUser();
		for (Copy copy : curUser.getBorrowedItems()) {
			returnRequestCopies.add(copy);
			Resource copyOf = copy.getResource();
			String copyProperties = (copyOf.getTitle() + ", " + copyOf.getYear()
					+ ". You have borrowed this on " + copy.getDateBorrowed());
			if (copy.getDueDate() != null) {
				copyProperties += ("\nThis item should be returned by "
						+ copy.getDueDateString());
			}
			borrowedItemsList.getItems().add(copyProperties);
		}
	}

	/**
	 * If the user decides that they want to request a return of an item they
	 * click the request to return button and the item selected by them in the
	 * gui is requested to return/
	 * 
	 * @param event
	 *            Clicking on the request to return button.
	 */
	@FXML
	private void clickOnRequestToReturn(ActionEvent event) {
		int selectedIndex = borrowedItemsList.getSelectionModel()
				.getSelectedIndex();

		if (selectedIndex < 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select an item first.");
			alert.showAndWait();
			return;
		}

		Copy currentCopy = returnRequestCopies.get(selectedIndex);
		curUser.requestReturn(currentCopy);
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Request successful");
		alert.setHeaderText(
				"You have successfully requested to return the item!");
		// alert.setContentText("Approved!");
		alert.showAndWait();

	}

	/**
	 * This method calls the method that closes the window.
	 * 
	 * @param event
	 *            Clicking on the back button
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
		Stage stage = (Stage) borrowedItemsPane.getScene().getWindow();
		stage.close();
	}
}
