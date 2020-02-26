import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This class is the controller for FineHistoryPage.fxml. It shows the user
 * their history of fines.
 * 
 * @author Boris Andreev
 *
 */
public class FineHistoryPageController {

	@FXML
	private ListView<String> fineHistoryList;

	@FXML
	private BorderPane fineHistoryPane;

	private User curUser;

	/**
	 * This method is called whenever the window is opened. It populates the
	 * list view with the strings from the user fine history list and displays
	 * them.
	 */
	@FXML
	private void initialize() {
		curUser = LoginController.getLoggedUser();
		Collections.reverse(curUser.getFineHistory());
		for (String string : curUser.getFineHistory()) {
			fineHistoryList.getItems().add(string);
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
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) fineHistoryPane.getScene().getWindow();
		stage.close();
	}
}
