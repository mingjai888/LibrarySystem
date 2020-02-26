import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * <h1>Create a new Book resource.</h1> The CreateBookPageController Class which
 * controls the CreateBookPage.fxml It contains methods to create a new book
 * object with the gui
 * 
 * @author Ming
 * @version 1.0
 * @since 2018-12-03
 */
public class CreateBookPageController {

	@FXML
	private BorderPane createBookPane;

	@FXML
	private TextField title;

	@FXML
	private TextField year;

	@FXML
	private Button thumbnailImage;

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

	private String image;
	Alert alert = new Alert(AlertType.CONFIRMATION);

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
	 * Actions will be made when the user clicks on the button. Triggers alert
	 * box for indication of new Book item creation. (Creates a new Book
	 * resource with all fields entered.)
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 */
	@FXML
	private void clickOnConfirm(ActionEvent event) {
		String title = this.title.getText();
		String year = this.year.getText();
		String author = this.author.getText();
		String publisher = this.publisher.getText();
		int numberOfCopies = Integer.parseInt(this.numberOfCopies.getText());
		String genre = this.genre.getText();
		String language = this.language.getText();
		String ISBN = this.ISBN.getText();
		String image = this.image;
		Book newBook = new Book(title, year, image, numberOfCopies, author,
				publisher);
		newBook.setGenre(genre);
		newBook.setISBN(ISBN);
		newBook.setLanguage(language);
		SearchBrowse.getResources().add(newBook);
		alert.setHeaderText("Success!");
		alert.setContentText(
				"This book has been added to the catalogue successfully!");
		alert.showAndWait();
		closeWindow();
		// System.out.println(newBook.toString());
	}

	/**
	 * 
	 * This method is called whenever a new thumbnail image for the Book is set.
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 * @throws IOException
	 *             Throws execption if the file doesnt exist
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
	 * This method closes the window.
	 */
	@FXML
	private void closeWindow() { // A method which close the window
		Stage stage = (Stage) createBookPane.getScene().getWindow();
		stage.close();
	}

}