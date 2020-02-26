import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Class which checks for all overdue items and displays them.
 * 
 * @author Ming and Kyriacos
 *
 */
public class ViewOverdueResourcesPageController {

	@FXML
	private BorderPane overdueResourcesPane;

	@FXML
	private ListView<String> overdueResourcesList;

	/**
	 * This method is called whenever the check overdue window is opened. It
	 * goes through all of the users and through all of their borrowed items to
	 * check if they have items that are overdue and displays them.
	 */
	public void initialize() {
		for (User user : Librarian.getUsersList()) {
			if (user.getBorrowedItems() != null) {
				for (Copy copy : user.getBorrowedItems()) {
					if (copy.getDueDate() != null) {
						int totalDays = Fine
								.findDays(copy.getDueDate(), Copy.getDateNow())
								.getDays();
						if (totalDays > 0) {
							String message = "This "
									+ copy.getResource().getTitle()
									+ " copy, with number " + copy.getCopyId()
									+ " should have been returned from "
									+ copy.getBorrowedBy().getUsername()
									+ " by " + copy.getDueDateString() + ".";
							overdueResourcesList.getItems().add(message);
						}
					}
				}
			}
		}
	}

	@FXML
	private void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) overdueResourcesPane.getScene().getWindow();
		stage.close();
	}
}
