import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * A class that lets the user choose which of his 2 transaction histories they
 * want to access.
 * 
 * @author Boris Andreev and Kyriacos Mosphilis
 *
 */
public class TransactionHistoryPageController {

	@FXML
	private BorderPane transacationHistoryPane;

	/**
	 * Calls the method that closes the stage.
	 * 
	 * @param event
	 *            Clicking on the back button on the GUI.
	 */
	@FXML
	void clickOnBack(ActionEvent event) {
		closeWindow();
	}

	/**
	 * Shows the GUI for the fine history of the user.
	 * 
	 * @param event
	 *            Click on the fine history button
	 */
	@FXML
	void clickOnFineHistory(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("FineHistoryPage.fxml"));

			BorderPane fineHistory = (BorderPane) fxmlLoader.load();

			Scene fineHistoryScene = new Scene(fineHistory,
					Main.TRANSACTIONHISTORYPAGE_WIDTH,
					Main.TRANSACTIONHISTORYPAGE_HEIGHT);
			Stage fineHistoryStage = new Stage();

			fineHistoryStage.setScene(fineHistoryScene);
			fineHistoryStage.setTitle(Main.TRANSACTIONHISTORYPAGE_TITLE);
			fineHistoryStage.initModality(Modality.APPLICATION_MODAL);
			fineHistoryStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Shows the GUI for the payment history of the user
	 * 
	 * @param event
	 *            Clicking on the payment history button
	 */
	@FXML
	void clickOnPaymentHistory(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("PaymentHistoryPage.fxml"));

			BorderPane paymentHistory = (BorderPane) fxmlLoader.load();

			Scene paymentHistoryScene = new Scene(paymentHistory,
					Main.TRANSACTIONHISTORYPAGE_WIDTH,
					Main.TRANSACTIONHISTORYPAGE_HEIGHT);
			Stage paymentHistoryStage = new Stage();

			paymentHistoryStage.setScene(paymentHistoryScene);
			paymentHistoryStage.setTitle(Main.TRANSACTIONHISTORYPAGE_TITLE);
			paymentHistoryStage.initModality(Modality.APPLICATION_MODAL);
			paymentHistoryStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method closes the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) transacationHistoryPane.getScene().getWindow();
		stage.close();
	}
}
