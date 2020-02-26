
import java.io.Serializable;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * A class that creates a new Resource object.
 * 
 * @author Boris Andreev and Kyriacos Mosphilis
 * @version 1.0
 */
public class Resource implements Serializable {

	/**
	 * @param id
	 *            Static id which is updated every time a new resource is
	 *            created.
	 */
	private static int id = 0;
	private int curResourceID;
	private String title;
	private String year;
	private String thumbnailImage;
	private int numOfCopies;
	private ArrayList<Copy> copies = new ArrayList<>();
	private ArrayList<User> waitingList = new ArrayList<>();

	/**
	 * Constructor for a resource.
	 * 
	 * @param title
	 *            Title of the resource.
	 * @param year
	 *            Year of resource release.
	 * @param image
	 *            Cover image for the resource.
	 * @param numOfCopies
	 *            How many copies exist of the resource in the library.
	 */
	public Resource(String title, String year, String image, int numOfCopies) {
		id++;
		this.curResourceID = id;
		this.title = title;
		this.year = year;
		this.thumbnailImage = image;
		this.numOfCopies = numOfCopies;
		generateCopies();
	}

	/**
	 * Getter method for the ID.
	 * 
	 * @return resource ID.
	 */
	public int getID() {
		return curResourceID;
	}

	/**
	 * Getter method for the title of the resource
	 * 
	 * @return resource title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Getter method for the year of release
	 * 
	 * @return year of release of resource
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Getter method for the cover image of a resource
	 * 
	 * @return The thumbnail image of the resource
	 */
	public String getThumbnailImage() {
		return thumbnailImage;
	}

	/**
	 * Getter method for the number of copies existing for the resource
	 * 
	 * @return Number of copies of the resource
	 */
	public int getNumOfCopies() {
		return numOfCopies;
	}

	/**
	 * Method that generates the given number of copies for a given resource
	 */
	public void generateCopies() {
		for (int i = 0; i < numOfCopies; i++) {
			copies.add(new Copy(this, i + 1));
		}
	}

	/**
	 * Method to create more copies.
	 * 
	 * @param newNumberOfCopies
	 *            The new number of copies.
	 */
	public void addCopies(int newNumberOfCopies) {
		int copiesToAdd = newNumberOfCopies - this.numOfCopies;
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText("Success!");
		alert.setContentText("Copies added successfuly!");
		if (!copies.isEmpty()) {
			for (int i = 0; i < copiesToAdd; i++) {
				copies.add(new Copy(this,
						copies.get((copies.size() - 1)).getCopyId() + 1));
				this.setNumOfCopies(newNumberOfCopies);
				alert.showAndWait();
			}
		} else {
			for (int j = 0; j < copiesToAdd; j++) {
				copies.add(new Copy(this, j + 1));
				this.setNumOfCopies(newNumberOfCopies);
				alert.showAndWait();
			}
		}
	}

	/**
	 * Method to remove copies.
	 * 
	 * @param copiesToRemove
	 *            The copies to be removed.
	 */
	public void removeCopies(int copiesToRemove) {
		int notAvailable = 0;
		ArrayList<Copy> freeCopies = new ArrayList<>();
		Alert alert1 = new Alert(AlertType.CONFIRMATION);
		alert1.setHeaderText("Success!");
		alert1.setContentText("Copies removed successfuly!");
		for (Copy copy : copies) {
			if (copy.getIsBorrowed() || copy.getIsRequested()
					|| copy.getIsReserved()) {
				notAvailable++;
			} else {
				freeCopies.add(copy);
			}
		}
		if (copiesToRemove > notAvailable) {
			for (int i = 0; i < copiesToRemove; i++) {
				copies.remove(freeCopies.get(i));
			}
			for (int j = 0; j < copies.size(); j++) {
				copies.get(j).setCopyID(j + 1);
				this.setNumOfCopies(j + 1);
			}
			alert1.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText(
					"There are not enough free copies which can be removed!");
			alert.setContentText(
					"Please wait until enough copies are returned so that they can be removed!");
			alert.showAndWait();
		}
	}

	public static void setID() {
		id = SearchBrowse.getResources().size();
	}

	/**
	 * Getter method to get copies.
	 * 
	 * @return An ArrayList containing all the copies of this resource.
	 */
	public ArrayList<Copy> getCopies() {
		return copies;
	}

	/**
	 * Method to add a user to the waiting list.
	 * 
	 * @param user
	 *            The User for the waiting list.
	 */
	public void addToWaitList(User user) {
		waitingList.add(user);
	}

	/**
	 * Setter method to set title.
	 * 
	 * @param title
	 *            The new title of this item.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Setter method to set year.
	 * 
	 * @param year
	 *            The new year of this item.
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Setter method for thumbnailImage
	 * 
	 * @param thumbnailImage
	 *            The new thumnailImage of this item.
	 */
	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}

	/**
	 * Getter method of the waiting list.
	 * 
	 * @return The waiting list of this item.
	 */
	public ArrayList<User> getWaitingList() {
		return waitingList;
	}

	/**
	 * Setter method for number of copies
	 * 
	 * @param numOfCopies
	 *            The new number of copies for this item.
	 */
	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}

	/**
	 * ToString method to print out nicely our Object.
	 */
	public String toString() {
		String result = "ID:\t\t\t\t" + this.getID() + "\nTitle:\t\t\t\t"
				+ this.getTitle() + "\nYear published:\t" + this.getYear()
				+ "\nNumber of Copies:\t" + this.getNumOfCopies();
		return result;
	}

}