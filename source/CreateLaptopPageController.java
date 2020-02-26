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
 * <h1>Create a new Laptop resource.</h1> The CreateLaptopPageController Class
 * which controls the CreateLaptopPage.fxml
 * 
 * @author Ming and Boris
 * @version 1.0
 * @since 2018-12-03
 */
public class CreateLaptopPageController {

	@FXML
	private BorderPane createLaptopPane;

	@FXML
	private TextField title;

	@FXML
	private TextField year;

	@FXML
	private Button thumbnailImage;

	@FXML
	private TextField manufacturer;

	@FXML
	private TextField model;

	@FXML
	private TextField operatingSystem;

	@FXML
	private TextField numOfCopies;

	Alert alert = new Alert(AlertType.CONFIRMATION);

	private String image;

	/**
	 * Actions will be made when the user clicks on the button. Triggers alert
	 * box for indication of new Laptop item creation. (Creates a new Laptop
	 * resource with all fields entered.)
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 */
	@FXML
	private void clickOnConfirm(ActionEvent event) {
		String title = this.title.getText();
		String year = this.year.getText();
		String manufacturer = this.manufacturer.getText();
		int numberOfCopies = Integer.parseInt(this.numOfCopies.getText());
		String model = this.model.getText();
		String OS = this.operatingSystem.getText();
		LaptopComputer newLaptop = new LaptopComputer(title, year, image,
				numberOfCopies, manufacturer, model, OS);
		SearchBrowse.getResources().add(newLaptop);
		alert.setHeaderText("Success!");
		alert.setContentText(
				"This DVD has been added to the catalogue successfully!");
		alert.showAndWait();
		closeWindow();
	}

	/**
	 * Actions will be made when the user clicks on the button. Setting of
	 * thumbnail image for the Laptop.
	 * 
	 * @param event
	 *            - When the mouse clicks on the button.
	 * @throws IOException
	 *             Throws an exception if the file chosen doenst exist
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
		Stage stage = (Stage) createLaptopPane.getScene().getWindow();
		stage.close();
	}
}