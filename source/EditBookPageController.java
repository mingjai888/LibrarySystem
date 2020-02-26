import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * The EditBookPageController Class which controls the EditBookPage.fxml. This
 * class allows the user to edit the information about a selected book from the
 * GUI
 * 
 * @author Ming and Boris
 *
 */
public class EditBookPageController {

	@FXML
	private BorderPane editBookPane;

	@FXML
	private TextField title;

	@FXML
	private TextField year;

	@FXML
	private ImageView thumbnailImage;

	@FXML
	private TextField author;

	@FXML
	private TextField publisher;

	@FXML
	private TextField numberOfCopies;

	@FXML
	private TextField genre;

	@FXML
	private TextField language;

	@FXML
	private TextField ISBN;

	private Book bookToEdit;
	private String path;

	/**
	 * This method gets called whenever the window is opened. It gets the
	 * information for the book and then it displays it at the fields so that
	 * the librarian can only edit the things they need to.
	 */
	@FXML
	private void initialize() {
		bookToEdit = (Book) BrowseAndSearchPageController.getResourceToEdit();
		path = bookToEdit.getThumbnailImage();
		this.title.setText(bookToEdit.getTitle());
		this.year.setText(bookToEdit.getYear());
		this.author.setText(bookToEdit.getAuthor());
		this.publisher.setText(bookToEdit.getPublisher());
		this.numberOfCopies
				.setText(Integer.toString(bookToEdit.getNumOfCopies()));
		if (bookToEdit.getGenre() != null) {
			this.genre.setText(bookToEdit.getGenre());
		}
		if (bookToEdit.getISBN() != null) {
			this.ISBN.setText(bookToEdit.getISBN());
		}
		if (bookToEdit.getLanguage() != null) {
			this.language.setText(bookToEdit.getLanguage());
		}
		this.thumbnailImage.setImage(new Image(bookToEdit.getThumbnailImage()));
	}

	/**
	 * This method is called when the confirm button is clicked. It sets the
	 * information about a book to the information entered in the fields.
	 * 
	 * @param event
	 *            Clicking on the confirm button
	 */
	@FXML
	private void clickOnConfirm(ActionEvent event) {
		String title = this.title.getText();
		String year = this.year.getText();
		String author = this.author.getText();
		String publisher = this.publisher.getText();
		try {
			int numberOfCopies = Integer
					.parseInt(this.numberOfCopies.getText());
			if (numberOfCopies > bookToEdit.getNumOfCopies()) {
				bookToEdit.addCopies(numberOfCopies);
			} else {
				bookToEdit.removeCopies(
						bookToEdit.getNumOfCopies() - numberOfCopies);
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Please enter a valid number!");
			alert.setContentText("No valid enter has been entered!");
			alert.showAndWait();
		}
		String genre = this.genre.getText();
		String language = this.language.getText();
		String ISBN = this.ISBN.getText();
		String image = this.path;
		bookToEdit.setTitle(title);
		bookToEdit.setYear(year);
		bookToEdit.setAuthor(author);
		bookToEdit.setPublisher(publisher);
		// bookToEdit.setNumOfCopies();
		bookToEdit.setGenre(genre);
		bookToEdit.setISBN(ISBN);
		bookToEdit.setLanguage(language);
		bookToEdit.setThumbnailImage(path);
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Success!");
		alert.setContentText(
				"This book has been added to the catalogue successfully!");
		alert.showAndWait();
	}

	/**
	 * This method is called when the user clicks on the new image button. It
	 * allows them to select a new thumbnail image for the book.
	 * 
	 * @param event
	 *            Clicking on the new image button.
	 */
	@FXML
	private void clickOnNewImage(ActionEvent event) {
		FileChooser fc = new FileChooser();
		File selectedFile = fc.showOpenDialog(null);
		path = selectedFile.toURI().toString();

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
		Stage stage = (Stage) editBookPane.getScene().getWindow();
		stage.close();
	}
}
