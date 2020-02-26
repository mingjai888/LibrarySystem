import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * <h1>Process borrow requests.</h1> The BorrowRequestPageController Class which
 * controls the BorrowRequestPage.fxml
 * 
 * @author Ming and Boris
 * @version 1.0
 * @since 2018-12-04
 *
 */
public class BorrowRequestPageController {
	private ArrayList<Copy> borrowRequestCopies = new ArrayList<>();

	@FXML
	private BorderPane borrowRequestPane;

	@FXML
	private ListView<String> borrowRequestList;

	/**
	 * This method gets called whenever the borrow request page is opened. It
	 * goes through all users and their requests to borrow items and displays
	 * them.
	 */
	public void initialize() {
		for (User user : Librarian.getUsersList()) {
			for (Copy copy : user.getRequestedItems()) {
				String message = (user.getUsername().toString()
						+ " has requested to borrow "
						+ copy.getResource().getTitle().toString());
				borrowRequestCopies.add(copy);
				borrowRequestList.getItems().add(message);
			}
		}
	}

	/**
	 * When librarian has selected a request to approve and clicks approve this
	 * gets executed. It updates the attributes for the copy of the resource and
	 * the user requesting.
	 * 
	 * @param event
	 *            Clicking the approve button
	 */
	@FXML
	void clickOnApprove(ActionEvent event) {
		int selectedIndex = borrowRequestList.getSelectionModel()
				.getSelectedIndex();

		if (selectedIndex < 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select a book first.");
			alert.showAndWait();
			return;
		}

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Info");
		alert.setHeaderText(null);
		alert.setContentText("Approved!");
		alert.showAndWait();

		Copy currentCopy = borrowRequestCopies.get(selectedIndex);

		boolean yes = true;
		Librarian.approveBorrow(yes, currentCopy);
		borrowRequestList.getItems().remove(selectedIndex);
		borrowRequestCopies.remove(selectedIndex);
	}

	/**
	 * When librarian has selected a request to not approve and clicks not
	 * approve this gets executed. It updates the attributes for the copy of the
	 * resource and the user requesting.
	 * 
	 * @param event
	 *            Clicking not approve.
	 */
	@FXML
	void clickOnNotApprove(ActionEvent event) {
		int selectedIndex = borrowRequestList.getSelectionModel()
				.getSelectedIndex();

		if (selectedIndex < 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select a book first.");
			alert.showAndWait();
			return;
		}

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Info");
		alert.setHeaderText(null);
		alert.setContentText("Not Approved!");
		alert.showAndWait();

		Copy currentCopy = borrowRequestCopies.get(selectedIndex);

		boolean no = false;
		Librarian.approveBorrow(no, currentCopy);
		borrowRequestList.getItems().remove(selectedIndex);
		borrowRequestCopies.remove(selectedIndex);
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
	 * Close the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) borrowRequestPane.getScene().getWindow();
		stage.close();
	}
}