import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Class the controls the payment history page.
 * 
 * @author Kyriacos Mosphilis and Boris Andreev.
 * @version 1.0
 */
public class PaymentHistoryPageController {

	@FXML
	private ListView<String> paymentHistoryList;

	@FXML
	private BorderPane paymentHistoryPane;

	private User curUser;

	/**
	 * This method is called whenever the window is opened. It goes through the
	 * list of user payments and displays them on the screen.
	 */
	@FXML
	private void initialize() {
		curUser = LoginController.getLoggedUser();
		Collections.reverse(curUser.getPaymentHistory());
		for (String string : curUser.getPaymentHistory()) {
			paymentHistoryList.getItems().add(string);
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
		Stage stage = (Stage) paymentHistoryPane.getScene().getWindow();
		stage.close();
	}
}
