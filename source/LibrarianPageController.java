import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The LibrarianPage Class which controls the LibrarianPage.fxml
 * 
 * @author Ming and Boris
 */
public class LibrarianPageController {

	@FXML
	private BorderPane librarianPane;

	/**
	 * This method opens the create new resources window.
	 * 
	 * @param event
	 *            Clicking on the create new resources button
	 */
	@FXML
	private void clickOnCreateNewResources(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("ChooseCreateTypePage.fxml"));

			BorderPane chooseCreateType = (BorderPane) fxmlLoader.load();

			Scene chooseCreateTypeScene = new Scene(chooseCreateType,
					Main.CHOOSECREATETYPEPAGE_WIDTH,
					Main.CHOOSECREATETYPEPAGE_HEIGHT);
			Stage chooseCreateTypeStage = new Stage();

			chooseCreateTypeStage.setScene(chooseCreateTypeScene);
			chooseCreateTypeStage.setTitle(Main.CHOOSECREATETYPEPAGE_TITLE);
			chooseCreateTypeStage.initModality(Modality.APPLICATION_MODAL);
			chooseCreateTypeStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method opens the search and browse window.
	 * 
	 * @param event
	 *            Clicking on the browse and search button
	 */
	@FXML
	private void clickOnBrowseAndSearch(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("BrowseAndSearchPage.fxml"));

			BorderPane browseAndSearch = (BorderPane) fxmlLoader.load();

			Scene browseAndSearchScene = new Scene(browseAndSearch,
					Main.BROWSEANDSEARCHPAGE_WIDTH,
					Main.BROWSEANDSEARCHPAGE_HEIGHT);
			Stage browseAndSearchStage = new Stage();

			browseAndSearchStage.setScene(browseAndSearchScene);
			browseAndSearchStage.setTitle(Main.BROWSEANDSEARCHPAGE_TITLE);
			browseAndSearchStage.initModality(Modality.APPLICATION_MODAL);
			browseAndSearchStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method opens the loan copy window.
	 * 
	 * @param event
	 *            Clicking on the loan a copy button.
	 */
	@FXML
	private void clickOnLoanCopy(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("LoanCopyPage.fxml"));

			BorderPane loanCopy = (BorderPane) fxmlLoader.load();

			Scene loanCopyScene = new Scene(loanCopy, Main.LOANCOPYPAGE_WIDTH,
					Main.LOANCOPYPAGE_HEIGHT);
			Stage loanCopyStage = new Stage();

			loanCopyStage.setScene(loanCopyScene);
			loanCopyStage.setTitle(Main.LOANCOPYPAGE_TITLE);
			loanCopyStage.initModality(Modality.APPLICATION_MODAL);
			loanCopyStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method opens the receive return window.
	 * 
	 * @param event
	 *            Clicking on teh receive return button
	 */
	@FXML
	private void clickOnRecieveReturn(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("RecieveReturnPage.fxml"));

			BorderPane recieveReturn = (BorderPane) fxmlLoader.load();

			Scene recieveReturnScene = new Scene(recieveReturn,
					Main.RECIEVERETURNPAGE_WIDTH,
					Main.RECIEVERETURNPAGE_HEIGHT);
			Stage recieveReturnStage = new Stage();

			recieveReturnStage.setScene(recieveReturnScene);
			recieveReturnStage.setTitle(Main.RECIEVERETURNPAGE_TITLE);
			recieveReturnStage.initModality(Modality.APPLICATION_MODAL);
			recieveReturnStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method opens the create new user window.
	 * 
	 * @param event
	 *            Clicking on the new create new user button.
	 */
	@FXML
	private void clickOnCreateNewUser(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("CreateNewUserPage.fxml"));

			BorderPane createNewUser = (BorderPane) fxmlLoader.load();

			Scene createNewUserScene = new Scene(createNewUser,
					Main.CREATENEWUSERPAGE_WIDTH,
					Main.CREATENEWUSERPAGE_HEIGHT);
			Stage createNewUserStage = new Stage();

			createNewUserStage.setScene(createNewUserScene);
			createNewUserStage.setTitle(Main.CREATENEWUSERPAGE_TITLE);
			createNewUserStage.initModality(Modality.APPLICATION_MODAL);
			createNewUserStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method opens the fine payment page.
	 * 
	 * @param event
	 *            Clicking on the fine payment button.
	 */
	@FXML
	private void clickOnFinePayment(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("FinePaymentPage.fxml"));

			BorderPane FinePayment = (BorderPane) fxmlLoader.load();

			Scene FinePaymentScene = new Scene(FinePayment,
					Main.LIBRARIAN_FINEPAYMENTPAGE_WIDTH,
					Main.LIBRARIAN_FINEPAYMENTPAGE_HEIGHT);
			Stage FinePaymentStage = new Stage();

			FinePaymentStage.setScene(FinePaymentScene);
			FinePaymentStage.setTitle(Main.LIBRARIAN_FINEPAYMENTPAGE_TITLE);
			FinePaymentStage.initModality(Modality.APPLICATION_MODAL);
			FinePaymentStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method opens the transaction history window.
	 * 
	 * @param event
	 *            Clicking on the transaction history button.
	 */
	@FXML
	private void clickOnTransactionHistory(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("TransactionHistoryPage.fxml"));

			BorderPane transactionHistory = (BorderPane) fxmlLoader.load();

			Scene transactionHistoryScene = new Scene(transactionHistory,
					Main.TRANSACTIONHISTORYPAGE_WIDTH,
					Main.TRANSACTIONHISTORYPAGE_HEIGHT);
			Stage transactionHistoryStage = new Stage();

			transactionHistoryStage.setScene(transactionHistoryScene);
			transactionHistoryStage.setTitle(Main.TRANSACTIONHISTORYPAGE_TITLE);
			transactionHistoryStage.initModality(Modality.APPLICATION_MODAL);
			transactionHistoryStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method opens the borrowing requests window.
	 * 
	 * @param event
	 *            Clicking on the borrowing requst button.
	 */
	@FXML
	private void clickOnBorrowingRequest(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("BorrowRequestPage.fxml"));

			BorderPane userBorrowing = (BorderPane) fxmlLoader.load();

			Scene userBorrowingScene = new Scene(userBorrowing,
					Main.BORROWREQUESTPAGE_WIDTH,
					Main.BORROWREQUESTPAGE_HEIGHT);
			Stage userBorrowingStage = new Stage();

			userBorrowingStage.setScene(userBorrowingScene);
			userBorrowingStage.setTitle(Main.BORROWREQUESTPAGE_TITLE);
			userBorrowingStage.initModality(Modality.APPLICATION_MODAL);
			userBorrowingStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method opens the return request window.
	 * 
	 * @param event
	 *            Clicking on the return request button.
	 */
	@FXML
	private void clickOnReturningRequest(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("ReturnRequestPage.fxml"));

			BorderPane userReturning = (BorderPane) fxmlLoader.load();

			Scene userReturningScene = new Scene(userReturning,
					Main.RETURNREQUESTPAGE_WIDTH,
					Main.RETURNREQUESTPAGE_HEIGHT);
			Stage userReturningStage = new Stage();

			userReturningStage.setScene(userReturningScene);
			userReturningStage.setTitle(Main.RETURNREQUESTPAGE_TITLE);
			userReturningStage.initModality(Modality.APPLICATION_MODAL);
			userReturningStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method opens the overdue resources window.
	 * 
	 * @param event
	 *            Clicking the overdue resources button.
	 */
	@FXML
	private void clickOnViewOverdueResources(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("ViewOverdueResourcesPage.fxml"));

			BorderPane overdueResources = (BorderPane) fxmlLoader.load();

			Scene overdueResourcesScene = new Scene(overdueResources,
					Main.OVERDUERESOURCESPAGE_WIDTH,
					Main.OVERDUERESOURCESPAGE_HEIGHT);
			Stage overdueResourcesStage = new Stage();

			overdueResourcesStage.setScene(overdueResourcesScene);
			overdueResourcesStage.setTitle(Main.OVERDUERESOURCESPAGE_TITLE);
			overdueResourcesStage.initModality(Modality.APPLICATION_MODAL);
			overdueResourcesStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Calls the method which closes the window and saves everything to the
	 * database.
	 * 
	 * @param event
	 *            Clicking on the log out button
	 */
	@FXML
	private void clickOnLogOut(ActionEvent event) {
		closeWindow();
		Database.saveData();
	}

	/**
	 * Closes the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) librarianPane.getScene().getWindow();
		stage.close();
	}
}
