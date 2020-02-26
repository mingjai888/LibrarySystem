import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * <h1>Create a new DVD resource.</h1> The CreateDVDPageController Class which
 * controls the CreateDVDPage.fxml Contains methods which can create a new DVD
 * object
 * 
 * @author Ming and Boris
 * @version 1.0
 * @since 2018-12-03
 */
public class CreateDVDPageController {

	@FXML
	private BorderPane createDVDPane;

	@FXML
	private TextField title;

	@FXML
	private TextField year;

	@FXML
	private Button thumbnailImage;

	@FXML
	private TextField director;

	@FXML
	private TextField runtime;

	@FXML
	private TextField language;

	@FXML
	private TextField numOfCopies;

	@FXML
	private TextField availavleSubtitles;

	Alert alert = new Alert(AlertType.CONFIRMATION);
	private String image;

	/**
	 * Actions will be made when the user clicks on the button. Triggers alert
	 * box for indication of new DVD item creation. (Creates a new DVD resource
	 * with all fields entered.)
	 * 
	 * @param event
	 *            - When the mouse clicks on the confirm button.
	 */
	@FXML
	private void clickOnConfirm(ActionEvent event) {
		String title = this.title.getText();
		String year = this.year.getText();
		String director = this.director.getText();
		int numberOfCopies = Integer.parseInt(this.numOfCopies.getText());
		String runtime = this.runtime.getText();
		String language = this.language.getText();
		String availableSubtitles = this.availavleSubtitles.getText();
		DVD newDVD = new DVD(title, year, image, numberOfCopies, director,
				runtime);
		newDVD.setSubtitles(availableSubtitles);
		newDVD.setLanguage(language);
		SearchBrowse.getResources().add(newDVD);
		alert.setHeaderText("Success!");
		alert.setContentText(
				"This DVD has been added to the catalogue successfully!");
		alert.showAndWait();
		closeWindow();
	}

	/**
	 * This method is called when setting of thumbnail image for the Laptop.
	 * 
	 * @param event
	 *            - When the mouse clicks on the new image button.
	 * @throws IOException
	 *             Exception thrown if the file specified does not exist
	 */
	@FXML
	public void clickOnThumbnailImage(ActionEvent event) throws IOException {
		FileChooser fc = new FileChooser();
		File selectedFile = fc.showOpenDialog(null);
		image = selectedFile.toURI().toString();
		/*
		 * ImageIcon imgIcon = new ImageIcon(image); JLabel lbl = new JLabel();
		 * lbl.setIcon(imgIcon); JFrame frame = new JFrame("Image viewer");
		 * frame.getContentPane().add(lbl, BorderLayout.CENTER); frame.pack();
		 * frame.setLocationRelativeTo(null); frame.setVisible(true);
		 */
	}

	/**
	 * Actions will be made when the user clicks on the button. Returns to
	 * previous window by closing the current/most recent one.
	 * 
	 * @param event
	 *            - When the mouse clicks on the back button.
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
		Stage stage = (Stage) createDVDPane.getScene().getWindow();
		stage.close();
	}
}