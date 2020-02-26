
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CopyHistoryPageController {

	@FXML
	private ListView<String> copyHistoryList;

	@FXML
	private BorderPane copyHistoryPane;

	private Copy selectedCopy;

	/**
	 * This is called whenever the copy history page is opened. It goes through
	 * the list containing the copys history and displays it.
	 * 
	 */

	@FXML
	private void initialize() {
		selectedCopy = DisplayCopiesPageController.getSelectedCopy();
		for (int i = 0; i < selectedCopy.getCopyHistory().size(); i++) {
			String copyHistory = selectedCopy.getCopyHistory().get(i);
			copyHistoryList.getItems().add(copyHistory);
		}
	}

	/**
	 * Method to close the window.
	 * 
	 * @param event
	 *            Mouse click on Back button.
	 */

	@FXML
	void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * Method to close the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) copyHistoryPane.getScene().getWindow();
		stage.close();
	}
}
