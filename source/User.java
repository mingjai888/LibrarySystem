import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * This class holds the information for a user object and also deals with the
 * request to borrow, request to return operations, checking for updates to fine
 * and payment history.
 * 
 * @author Boris Andreev and Kyriacos Mosphilis
 *
 */
public class User implements Serializable {

	private String username;
	private String name;
	private String mobileNumber;
	private String houseNumber;
	private String streetName;
	private String postcode;
	private String profilePic;
	private double currentFine;
	private ArrayList<Copy> requestedItems = new ArrayList<>();
	private ArrayList<Copy> borrowedItems = new ArrayList<>();
	private ArrayList<Copy> returnRequests = new ArrayList<>();
	private ArrayList<Copy> reservedFor = new ArrayList<>();
	private ArrayList<Copy> itemsToReturn = new ArrayList<>();
	private ArrayList<Date> paymentDates = new ArrayList<>();
	private ArrayList<Double> paymentAmounts = new ArrayList<>();
	private ArrayList<String> messages = new ArrayList<>();
	private ArrayList<String> paymentHistory = new ArrayList<>();
	private ArrayList<String> fineHistory = new ArrayList<>();

	/**
	 * Constructor for a user object.
	 * 
	 * @param username
	 *            Username of the user
	 * @param name
	 *            Full name of the user
	 * @param mobileNumber
	 *            Mobile number of the user
	 * @param houseNumber
	 *            House number of the user
	 * @param address
	 *            Street name, neighbourhood and city of user
	 * @param postcode
	 *            Postcode of user
	 * @param image
	 *            Path to the profile image of the user
	 */
	public User(String username, String name, String mobileNumber,
			String houseNumber, String address, String postcode, String image) {
		this.username = username;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.houseNumber = houseNumber;
		this.streetName = address;
		this.postcode = postcode;
		this.profilePic = image;
		Collections.reverse(messages);
	}

	/**
	 * Getter method for the path to the users profile picture
	 * 
	 * @return Path to the users profile picture
	 */
	public String getProfilePic() {
		return profilePic;
	}

	/**
	 * Getter method for the items the user has to return
	 * 
	 * @return List of copies the user has to return
	 */
	public ArrayList<Copy> getItemsToReturn() {
		return itemsToReturn;
	}

	/**
	 * Getter method for the items reserved for the user
	 * 
	 * @return List of items reserved for the user
	 */
	public ArrayList<Copy> getReservedFor() {
		return reservedFor;
	}

	/**
	 * Setter method for the users profile picture
	 * 
	 * @param profilePic
	 *            Path to the actual image to be displayed
	 */
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	/**
	 * Getter method for the users username
	 * 
	 * @return The username of the user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Getter method for the full name of the user
	 * 
	 * @return The full name of the user
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter method for the mobile number of the user
	 * 
	 * @return The mobile number of the user
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * Setter method for the users mobile number
	 * 
	 * @param mobileNumber
	 *            String that will be set as the mobile number of the user
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * Setter method for the user house number
	 * 
	 * @param houseNumber
	 *            String that is the house where the user lives
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	/**
	 * Getter method for the street where the user lives
	 * 
	 * @return The street where the user lives
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * Setter method for the street where the user lives
	 * 
	 * @param streetName
	 *            Street where the user lives
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * Getter method for the users postcode
	 * 
	 * @return The users postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * Setter method for the users postcode
	 * 
	 * @param postcode
	 *            String that is the users postcode
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * Getter method for the items the user has requested to return
	 * 
	 * @return List of the items the user has requested to return
	 */
	public ArrayList<Copy> getReturnRequests() {
		return returnRequests;
	}

	/**
	 * This method checks and adds the fine history of the user while
	 * collaborating with the Fine class to see if there are any new fines. It
	 * also contains checks to avoid duplication in the fine history list.
	 */
	public void checkFineHistory() {
		String history = "";
		boolean once = true;
		for (Copy copy : borrowedItems) {
			if (copy.getDueDate() != null) {
				Copy curCopy = copy;
				Date dueDate = curCopy.getDueDate();
				Date currentDate = Copy.getDateNow();
				Fine fine = new Fine(curCopy.getResource(), dueDate,
						currentDate);
				history += curCopy.getDueDate() + ", amount due: "
						+ fine.getCurrentFine() + ", copy: "
						+ curCopy.getCopyId() + " of "
						+ curCopy.getResource().getTitle() + ". Days overdue: "
						+ fine.getDaysOverdue() + "\n";
				if (fine.getDaysOverdue() > 0) {
					if (!fineHistory.isEmpty()) {
						for (String string : fineHistory) {
							if (history.equals(string)) {
								once = false;
							}

						}
						if (once) {
							fineHistory.add(history);
						}
					}
				} else {
					fineHistory.add(history);
				}
			}
		}
	}

	/**
	 * Getter method for the fine history of the user
	 * 
	 * @return A list of string each an entry of the fine history of the user
	 */
	public ArrayList<String> getFineHistory() {
		return fineHistory;
	}

	/**
	 * Setter method for the users payment history
	 * 
	 * @param paymentDate
	 *            The date when the user made the payment
	 * @param amount
	 *            How much did the user pay of his fine
	 */
	public void setPaymentHistory(Date paymentDate, double amount) {
		paymentDates.add(paymentDate);
		paymentAmounts.add(amount);
		String history = amount + " was paid on " + paymentDate + ".\n";
		paymentHistory.add(history);
	}

	/**
	 * Getter method for the payment history of the user
	 * 
	 * @return A list of string with each entry being a payment made
	 */
	public ArrayList<String> getPaymentHistory() {
		return paymentHistory;
	}

	/**
	 * Getter method for the items the user has requested
	 * 
	 * @return A list of items which the user has requested
	 */
	public ArrayList<Copy> getRequestedItems() {
		return requestedItems;
	}

	/**
	 * Getter method for the items the user has borrowed
	 * 
	 * @return A list of items the user has borrowed
	 */
	public ArrayList<Copy> getBorrowedItems() {
		return borrowedItems;
	}

	/**
	 * Getter method for the users house number
	 * 
	 * @return The users house number
	 */
	public String getHouseNumber() {
		return houseNumber;
	}

	/**
	 * This method works in collaboration with the Fine class to calculate the
	 * current negative balance of the user.
	 * 
	 * @return The negative balance on this users account
	 */
	public double calculateBalance() {
		double totalFine = 0;
		for (Copy copy : borrowedItems) {
			if (copy.getDueDate() != null) {
				Copy curCopy = copy;
				Date dueDate = curCopy.getDueDate();
				Date currentDate = Copy.getDateNow();
				Fine fine = new Fine(curCopy.getResource(), dueDate,
						currentDate);
				totalFine = fine.getCurrentFine();
			}
		}
		return totalFine;
	}

	/**
	 * Getter method for the users balance. It checks if the calculated negative
	 * balance has changed and if it has updates the current negative balance
	 * 
	 * @return The total which the user owes in fines
	 */
	public double getBalance() {
		if (currentFine != calculateBalance()) {
			double additionalFine = calculateBalance() - currentFine;
			if (additionalFine < 0) {
				return currentFine;
			} else {
				currentFine += additionalFine;
			}
		}
		return currentFine;
	}

	/**
	 * This method is used when a user pays of a part of his fine
	 * 
	 * @param payment
	 *            How much has the user paid towards his fine
	 */
	public void payFine(double payment) {
		currentFine = currentFine - payment;
	}

	/**
	 * This is the request item operation. When browsing the user selects an
	 * item they wan to borrow. This method carries out the check if there are
	 * free copies of this resource available for borrowing. If there are it
	 * sends to the librarian for approval, if not reserves a copy for the user.
	 * 
	 * @param item
	 *            The item the user wants to borrow a copy from
	 */
	public void requestItem(Resource item) {
		Copy freeCopy = Copy.checkCopy(item); // checks if there is a free copy
		if (freeCopy == null) { // if there isnt a free copy user gets added to
			// the waiting list for that
			// resource
			item.addToWaitList(this);
			noCopyAvailable();
			SearchBrowse.reserved(item);
		} else { // if there is a free copy it gets added to the users requested
			// items list and
			// its variables are set to requested
			freeCopy.requestCopy(this);
			freeCopy.setDateRequested(Copy.getDateNow());
			requestedItems.add(freeCopy);
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Success!");
			alert.setContentText(
					"You have requested a copy! If no copies are available now "
							+ "one will be reserved for you.\nYou will reveive a message when you can get "
							+ "your reserved copy!");
			alert.showAndWait();
		}
	}

	/**
	 * Getter method for the users messages
	 * 
	 * @return The list of messages the user has
	 */
	public ArrayList<String> getMessages() {
		Set<String> hs = new LinkedHashSet<>(messages);
		messages.clear();
		messages.addAll(hs);		
		return messages;
	}

	/**
	 * This method is called when the user requests to return a copy.
	 * 
	 * @param copy
	 *            A copy which the user wants to return
	 */
	public void requestReturn(Copy copy) { /*
											 * user chooses which copy to return
											 * here with the gui
											 */
		returnRequests.add(copy); // adds copy to be returned to the return
		// requests list
		copy.setDateRequestReturn(Copy.getDateNow()); // sets the date when the
		// return was requested
	}

	/**
	 * This method adds a message of which item the user has to return and by
	 * when. It also lets them know what the fine will be like if they fail to
	 * return on time.
	 * 
	 * @param copy
	 *            The item the user has to return.
	 */
	public void DueDateMessage(Copy copy) {
		if (copy.getResource() instanceof Book
				|| copy.getResource() instanceof DVD) {
			String messageBook = ("The item you have borrowed: "
					+ copy.getResource().getTitle()
					+ " has been requested by someone else and you have to return it by "
					+ copy.getDueDateString()
					+ " \nor a fine of 2 pounds per day up to a maximum of 25 pounds will start incurring. \n");
			messages.add(messageBook);
		}
		if (copy.getResource() instanceof LaptopComputer) {
			String messageLaptop = ("The item you have borrowed: "
					+ copy.getResource().getTitle()
					+ " has been requested by someone else and you have to return it by "
					+ copy.getDueDateString()
					+ "\nor a fine of 10 pounds per day up to a maximum of 100 pounds will start incurring. \n");
			messages.add(messageLaptop);
		}

	}

	/**
	 * This method sends the user a notification of when there are no copies
	 * available and that they have been added to the waiting list for the item.
	 */
	public void noCopyAvailable() {
		String message = ("Unfortunately all the copies are already borrowed, requseted or reserved at the moment. \n"
				+ "You have been added to the waiting list and will "
				+ "receive a notification when a copy is available. \n");
		messages.add(message);
	}

	/**
	 * This method sends the user a message that a copy of the item he has
	 * requested has become available.
	 * 
	 * @param copy
	 *            An item which the user has requested
	 */
	public void copyNowAvailable(Copy copy) {
		String message = ("The item you have requested: "
				+ copy.getResource().getTitle()
				+ "is now available for you to borrow. \n");
		messages.add(message);
	}
}
