import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The LoanCopyPageController which controls the LoanCopyPage.fxml. This class
 * allows the librarian to loan an item to an user.
 * 
 * @author Ming
 *
 */
public class LoanCopyPageController {

	@FXML
	private BorderPane loanCopyPane;

	@FXML
	private TextField userID;

	@FXML
	private TextField item;

	/**
	 * This method is called whenever the loan button is clicked. It takes to
	 * strings for username and item name and calls loan a copy method in the
	 * librarian class.
	 * 
	 * @param event
	 *            Clicking on the loan button.
	 */
	@FXML
	private void clickOnLoan(ActionEvent event) {
		String username = this.userID.getText();
		String item = this.item.getText();
		Librarian.loanACopy(username, item);
	}

	/**
	 * Calls the method which closes the window.
	 * 
	 * @param event
	 *            Clicking on the back button.
	 */
	@FXML
	private void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * Closes the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) loanCopyPane.getScene().getWindow();
		stage.close();
	}
}
