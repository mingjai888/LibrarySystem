import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <h1>Display Copies Page Controller. (GUI)</h1> The
 * DisplayCopiesPageController class which controls the
 * DisplayCopiesPageController.fxml
 * 
 * 
 * @author Ming and Boris
 * @version 1.0
 * @since 2018-12-06
 *
 */
public class DisplayCopiesPageController {

	@FXML
	private ListView<String> copyList;

	@FXML
	private BorderPane copyPane;

	private User curUser;
	private Resource resource;
	private static Copy selectedCopy;

	/**
	 * Initialize the controller. Displays appropriate message according to
	 * whether or not a copy of a requested item/resource is available. (Checks
	 * first the status of a resource copy.)
	 */
	@FXML
	private void initialize() {
		curUser = LoginController.getLoggedUser();
		resource = BrowseAndSearchPageController.getSelectedResource();
		String stringCopies = "";
		String borrowed = "";
		for (Copy copy : resource.getCopies()) {
			if (copy.getIsBorrowed()) {
				borrowed = "Borrowed.";
			} else {
				borrowed = "Available.";
			}
			stringCopies = "Copy: " + copy.getCopyId() + "\t\tStatus: "
					+ borrowed + "\n";
			copyList.getItems().add(stringCopies);
		}
	}

	/**
	 * Actions will be carried out when button is clicked to go through the list
	 * of copies (copyList) for display. Appropriate alert boxes pop up when
	 * unexpected/non-existent list item is being pulled or when logged in as a
	 * User without permission (When User is not a Librarian).
	 * 
	 * @param event
	 *            - When the mouse clicks on the check copy history button.
	 */
	@FXML
	void clickOnCheckCopyHistory(ActionEvent event) {
		if (curUser instanceof Librarian) {

			if (copyList.getSelectionModel().getSelectedIndex() < 0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("Error");
				alert.setContentText("Please select a copy");
				alert.showAndWait();

			} else {
				selectedCopy = resource.getCopies()
						.get(copyList.getSelectionModel().getSelectedIndex());
				try {
					FXMLLoader fxmlLoader = new FXMLLoader(
							getClass().getResource("CopyHistoryPage.fxml"));

					BorderPane copyHistory = (BorderPane) fxmlLoader.load();

					Scene copyHistoryScene = new Scene(copyHistory,
							Main.BROWSEANDSEARCHPAGE_WIDTH,
							Main.BROWSEANDSEARCHPAGE_HEIGHT);
					Stage copyHistoryStage = new Stage();

					copyHistoryStage.setScene(copyHistoryScene);
					copyHistoryStage.setTitle("Copy History Page");
					copyHistoryStage.initModality(Modality.APPLICATION_MODAL);
					copyHistoryStage.showAndWait();
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(-1);
				}
			}

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Error!");
			alert.setContentText("You don't have permission to see this!");
			alert.showAndWait();
		}
	}

	/**
	 * Getter method which returns a selected copy.
	 * 
	 * @return selectedCopy A copy item which has been selected.
	 */
	public static Copy getSelectedCopy() {
		return selectedCopy;
	}

	/**
	 * Actions will be made when the user clicks on the button. Returns to
	 * previous window by closing the current/most recent one.
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 */
	@FXML
	void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * Actions will be made when the User clicks on the button. Makes a request
	 * for a copy of an item/resource on behalf of the User.
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 */
	@FXML
	void clickOnRequestACopy(ActionEvent event) {
		curUser.requestItem(resource);
	}

	/**
	 * This method closes the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) copyPane.getScene().getWindow();
		stage.close();
	}
}
