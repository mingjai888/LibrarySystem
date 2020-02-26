import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class controls the GUI, it gets inputs from the GUI and does operations
 * which then displays the information.
 * 
 * @author Kyriacos
 * @version 1.0.0
 *
 */
public class FinePaymentPageController {

	@FXML
	private BorderPane finePaymentPane;

	@FXML
	private Label showCurrentBalanceBox;

	@FXML
	private TextField username;

	@FXML
	private TextField payAmount;

	private User curUser;

	/**
	 * When the show current balance is clicked the current balance of the user
	 * whose username is input is displayed.
	 * 
	 * @param event
	 *            Clicking the show current balance button or pressing enter.
	 * @throws IOException
	 *             Exception if the balance is null.
	 */
	@FXML
	private void clickOnShowCurrentBalance(ActionEvent event)
			throws IOException {
		String username = this.username.getText();
		if (username.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("No input!");
			alert.setContentText("Please input a username.");
			alert.showAndWait();
		} else { // The case when the librarian fill in their LibrarianID
					// correctly
			ArrayList<User> usersList = new ArrayList<>();
			usersList.addAll(Librarian.getUsersList());
			int index = 0;
			boolean flag = true;
			do {
				if (username.equals(usersList.get(index).getUsername())) {
					curUser = usersList.get(index);
					flag = false;
				}
				index++;
			} while (index != usersList.size() && flag);
			if (username.equals(curUser.getUsername())) {
				String balance = String.valueOf(curUser.getBalance());
				showCurrentBalanceBox.setText(balance);
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setHeaderText("No such user!");
				alert.setContentText("Wrong username or no such user exists!");
				alert.showAndWait();
			}
		}
	}

	/**
	 * Clicking on the confirm button calls this method which then deducts the
	 * double (payment) input from the users current balance.
	 * 
	 * @param event
	 *            clicking on the confirm button
	 */
	@FXML
	private void clickOnConfirm(ActionEvent event) {
		Double amount = 0.0;
		try {
			amount = Double.parseDouble(this.payAmount.getText());
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Not a valid number");
			alert.setContentText("Please enter a valid number!");
			alert.showAndWait();
		}

		if (amount != 0.0) {
			curUser.payFine(amount);
			curUser.setPaymentHistory(Copy.getDateNow(), amount);
			Alert alert1 = new Alert(AlertType.CONFIRMATION);
			alert1.setHeaderText("Success");
			alert1.setContentText("Fine payment successful!");
			alert1.showAndWait();
		}
	}

	/**
	 * Calls the method which closes the window.
	 * 
	 * @param event
	 *            clicking on the back button.
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
		Stage stage = (Stage) finePaymentPane.getScene().getWindow();
		stage.close();
	}
}