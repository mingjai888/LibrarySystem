import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * <h1>Make desired changes on to a DVD resource.</h1> The EditDVDPageController
 * Class which controls the EditDVDPage.fxml. This class allows the user to edit
 * the information about a selected DVD from the GUI.
 * 
 * @author Ming and Boris
 * @version 1.0
 * @since 2018-12-03
 */
public class EditDVDPageController {

	@FXML
	private Button newImage;

	@FXML
	private BorderPane editDVDPane;

	@FXML
	private TextField year;

	@FXML
	private TextField numOfCopies;

	@FXML
	private TextField director;

	@FXML
	private TextField runtime;

	@FXML
	private TextField language;

	@FXML
	private TextField title;

	@FXML
	private ImageView thumbnailImage;

	@FXML
	private TextField availavleSubtitles;

	private DVD dvdToEdit;
	private String path;

	/**
	 * This method gets called whenever the window is opened. It gets the
	 * information for the DVD and then it displays it at the fields so that the
	 * librarian can only edit the things they need to.
	 */
	@FXML
	private void initialize() {
		dvdToEdit = (DVD) BrowseAndSearchPageController.getResourceToEdit();
		path = dvdToEdit.getThumbnailImage();
		this.title.setText(dvdToEdit.getTitle());
		this.year.setText(dvdToEdit.getYear());
		this.runtime.setText(dvdToEdit.getRuntime());
		this.director.setText(dvdToEdit.getDirector());
		this.numOfCopies.setText(Integer.toString(dvdToEdit.getNumOfCopies()));
		this.title.setText(dvdToEdit.getTitle());
		if (dvdToEdit.getLanguage() != null) {
			this.language.setText(dvdToEdit.getLanguage());
		} else {
			this.language.setText("");
		}
		if (dvdToEdit.getSubtitles() != null) {
			this.availavleSubtitles.setText(dvdToEdit.getSubtitles());
		} else {
			this.language.setText("");
		}
		this.thumbnailImage.setImage(new Image(dvdToEdit.getThumbnailImage()));
	}

	/**
	 * This method is called when the user clicks on the new image button. It
	 * allows them to select a new thumbnail image for the DVD.
	 * 
	 * @param event
	 *            Clicking on the new image button.
	 */
	@FXML
	void clickOnNewImage(ActionEvent event) {
		FileChooser fc = new FileChooser();
		File selectedFile = fc.showOpenDialog(null);
		path = selectedFile.toURI().toString();
	}

	/**
	 * This method is called when the confirm button is clicked. It sets the
	 * information about the DVD to the information entered in the fields.
	 * 
	 * @param event
	 *            Clicking on the confirm button
	 */
	@FXML
	private void clickOnConfirm(ActionEvent event) {
		String title = this.title.getText();
		String year = this.year.getText();
		String runtime = this.runtime.getText();
		String director = this.director.getText();
		try {
			int numberOfCopies = Integer.parseInt(this.numOfCopies.getText());
			if (numberOfCopies > dvdToEdit.getNumOfCopies()) {
				dvdToEdit.addCopies(numberOfCopies);
			} else {
				dvdToEdit.removeCopies(
						dvdToEdit.getNumOfCopies() - numberOfCopies);
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Please enter a valid number!");
			alert.setContentText("No valid enter has been entered!");
			alert.showAndWait();
		}
		String language = this.language.getText();
		String image = this.path;
		dvdToEdit.setTitle(title);
		dvdToEdit.setYear(year);
		dvdToEdit.setDirector(director);
		dvdToEdit.setRuntime(runtime);
		// dvdToEdit.setNumOfCopies();
		dvdToEdit.setLanguage(language);
		dvdToEdit.setThumbnailImage(image);
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Success!");
		alert.setContentText(
				"This book has been added to the catalogue successfully!");
		alert.showAndWait();
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
	 * This method closes the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) editDVDPane.getScene().getWindow();
		stage.close();
	}
}
