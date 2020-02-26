import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

/**
 * The UserPageController Class which controls the UserPage on the GUI. It gets
 * the correct user information from the login controller and displays the
 * correct information for the specific user logging in.
 * 
 * @author Ming and Boris
 *
 */
public class UserPageController {

	@FXML
	private Label showCurrentBalanceBox;

	@FXML
	private BorderPane userPagePane;

	@FXML
	private ImageView profilePicture = new ImageView();

	@FXML
	private Label welcomeMessage = new Label();

	private static User curUser;

	/**
	 * This method is called whenever a user logs in. It sets the welcome
	 * message to greet the specific user and also displays their profile
	 * picture and their current negative balance.
	 */
	@FXML
	public void initialize() {
		curUser = LoginController.getLoggedUser();
		welcomeMessage.setText("Welcome to Tawe Lib, " + curUser.getUsername());
		Image image = new Image(curUser.getProfilePic());
		curUser.checkFineHistory();
		profilePicture.setImage(image);
		showCurrentBalanceBox.setText(
				"Current Balance: " + Double.toString(curUser.getBalance()));
		for (Resource resource : SearchBrowse.getResources()) {
			try {
				Copy.checkCopy(resource);
			} catch (NoSuchElementException e) {

			}
		}
	}

	/**
	 * This method loads the search and browse page where the user can see and
	 * request the resources.
	 * 
	 * @param event
	 *            Clicking on the browse and search button.
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
	 * This method loads the messages page of the user.
	 * 
	 * @param event
	 *            Clicking on the notifications button.
	 */
	@FXML
	private void clickOnNotification(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("MessagePage.fxml"));

			BorderPane message = (BorderPane) fxmlLoader.load();

			Scene messageScene = new Scene(message, Main.MESSAGEPAGE_WIDTH,
					Main.MESSAGEPAGE_HEIGHT);
			Stage messageStage = new Stage();

			messageStage.setScene(messageScene);
			messageStage.setTitle(Main.MESSAGEPAGE_TITLE);
			messageStage.initModality(Modality.APPLICATION_MODAL);
			messageStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);

		}
	}

	/**
	 * This method loads the borrowed items page of the user.
	 * 
	 * @param event
	 *            Clicking on the borrowed items button
	 */
	@FXML
	private void clickOnBorrowedItems(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("UserBorrowedItemsPage.fxml"));

			BorderPane borrowedItems = (BorderPane) fxmlLoader.load();

			Scene borrowedItemsScene = new Scene(borrowedItems,
					Main.USER_BORROWEDITEMSPAGE_WIDTH,
					Main.USER_BORROWEDITEMSPAGE_HEIGHT);
			Stage userBorrowedItemsStage = new Stage();

			userBorrowedItemsStage.setScene(borrowedItemsScene);
			userBorrowedItemsStage.setTitle(Main.USER_BORROWEDITEMSPAGE_TITLE);
			userBorrowedItemsStage.initModality(Modality.APPLICATION_MODAL);
			userBorrowedItemsStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method loads the requested items page of the user.
	 * 
	 * @param event
	 *            Clicking on the requested items button
	 */
	@FXML
	private void clickOnRequestedItems(ActionEvent event) { // Jump to the
															// Requested Items
															// Page after the
															// user click the
															// button
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("UserRequestedItemsPage.fxml"));

			BorderPane requestedItems = (BorderPane) fxmlLoader.load();

			Scene requestedItemsScene = new Scene(requestedItems,
					Main.USER_REQUESTEDITEMSPAGE_WIDTH,
					Main.USER_REQUESTEDITEMSPAGE_HEIGHT);
			Stage userRequestedItemsStage = new Stage();

			userRequestedItemsStage.setScene(requestedItemsScene);
			userRequestedItemsStage
					.setTitle(Main.USER_REQUESTEDITEMSPAGE_TITLE);
			userRequestedItemsStage.initModality(Modality.APPLICATION_MODAL);
			// Show the edit scene and wait for it to be closed
			userRequestedItemsStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method loads the reserved for the user items
	 * 
	 * @param event
	 *            Clicking on the reserved items button
	 */
	@FXML
	private void clickOnReservedItems(ActionEvent event) { // Jump to the
															// Reserved Items
															// Page after the
															// user click the
															// button
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("UserReservedItemsPage.fxml"));

			BorderPane reservedItems = (BorderPane) fxmlLoader.load();

			Scene reservedItemsScene = new Scene(reservedItems,
					Main.USER_RESERVEDITEMSPAGE_WIDTH,
					Main.USER_RESERVEDITEMSPAGE_HEIGHT);
			Stage userReservedItemsStage = new Stage();

			userReservedItemsStage.setScene(reservedItemsScene);
			userReservedItemsStage.setTitle(Main.USER_RESERVEDITEMSPAGE_TITLE);
			userReservedItemsStage.initModality(Modality.APPLICATION_MODAL);
			userReservedItemsStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method loads the page from where the user decides which if the
	 * histories he wants displayed
	 * 
	 * @param event
	 *            Clicking on the transaction history button
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
			Stage userTransactionHistoryStage = new Stage();

			userTransactionHistoryStage.setScene(transactionHistoryScene);
			userTransactionHistoryStage
					.setTitle(Main.TRANSACTIONHISTORYPAGE_TITLE);
			userTransactionHistoryStage
					.initModality(Modality.APPLICATION_MODAL);
			userTransactionHistoryStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method loads the window from where the user chooses a profile
	 * picture.
	 * 
	 * @param event
	 *            Clicking on choose avatar button
	 */
	@FXML
	private void clickOnChooseAvatar(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("ChooseAvatarPage.fxml"));

			BorderPane chooseAvatar = (BorderPane) fxmlLoader.load();

			Scene chooseAvatarScene = new Scene(chooseAvatar,
					Main.CHOOSEAVATARPAGE_WIDTH, Main.CHOOSEAVATARPAGE_HEIGHT);
			Stage chooseAvatarStage = new Stage();

			chooseAvatarStage.setScene(chooseAvatarScene);
			chooseAvatarStage.setTitle(Main.CHOOSEAVATARPAGE_TITLE);
			chooseAvatarStage.initModality(Modality.APPLICATION_MODAL);
			chooseAvatarStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * This method loads the page where the users information is displayed
	 * 
	 * @param event
	 *            Clicking on the profile button
	 */
	@FXML
	private void clickOnProfile(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("UserProfilePage.fxml"));

			BorderPane profileInfo = (BorderPane) fxmlLoader.load();

			Scene profileInfoScene = new Scene(profileInfo,
					Main.CHOOSEAVATARPAGE_WIDTH, Main.CHOOSEAVATARPAGE_HEIGHT);
			Stage profileInfoStage = new Stage();

			profileInfoStage.setScene(profileInfoScene);
			profileInfoStage.setTitle(Main.CHOOSEPROFILEPAGE_TITLE);
			profileInfoStage.initModality(Modality.APPLICATION_MODAL);
			profileInfoStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Calls the method which closes the window and saves the information in the
	 * database
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
		Stage stage = (Stage) userPagePane.getScene().getWindow();
		stage.close();
	}

}