import java.io.*;
import java.util.ArrayList;

/**
 * Database class is used to serialize data that needs to be stored between
 * program instances.
 * 
 * @author Oliver Nixon, Riyaad Islam
 * @version 1.0
 */
public class Database {

	/**
	 * Method used to serialize an ArrayList of Resource to store in a .ser
	 * file.
	 * 
	 * @param al
	 *            The ArrayList of Resource to be serialized and written to a
	 *            file.
	 */
	public static void storeResourceList(ArrayList<Resource> al) {
		try {
			FileOutputStream outFile = new FileOutputStream("resourcelist.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(outFile);
			objectOut.writeObject(al);
			objectOut.close();
			outFile.close();
			// System.out.println("Stored resource list in resourcelist.ser");
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	/**
	 * Getter method used to retrieve data from serialized file and deserialize
	 * the data and return the ArrayList of Resource stored in the file.
	 * 
	 * @return The ArrayList of Resource stored in resourcelist.ser.
	 */
	public static ArrayList<Resource> getResourceList() {
		ArrayList<Resource> resourceList = null;
		try {
			FileInputStream inFile = new FileInputStream("resourcelist.ser");
			ObjectInputStream objectIn = new ObjectInputStream(inFile);
			resourceList = (ArrayList<Resource>) objectIn.readObject();
			objectIn.close();
			inFile.close();
			return resourceList;
		} catch (IOException e) {
			// e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			return null;
		}
	}

	/**
	 * Method used to serialize an ArrayList of User to store in a .ser file.
	 * 
	 * @param al
	 *            The ArrayList of User to be serialized and written to a file.
	 */
	public static void storeUserList(ArrayList<User> al) {
		try {
			FileOutputStream outFile = new FileOutputStream("userlist.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(outFile);
			objectOut.writeObject(al);
			objectOut.close();
			outFile.close();
			// System.out.println("Stored user list in userlist.ser");
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	/**
	 * Getter method used to retrieve data from serialized file and deserialize
	 * the data and return the ArrayList of User stored in the file.
	 * 
	 * @return The ArrayList of User stored in userlist.ser.
	 */
	public static ArrayList<User> getUserList() {
		ArrayList<User> userList = null;
		try {
			FileInputStream inFile = new FileInputStream("userlist.ser");
			ObjectInputStream objectIn = new ObjectInputStream(inFile);
			userList = (ArrayList<User>) objectIn.readObject();
			objectIn.close();
			inFile.close();
			return userList;
		} catch (IOException e) {
			// e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			return null;
		}
	}

	/**
	 * Method used to serialize an ArrayList of Librarian to store in a .ser
	 * file.
	 * 
	 * @param al
	 *            The ArrayList of Librarian to be serialized and written to a
	 *            file.
	 */
	public static void storeLibList(ArrayList<Librarian> al) {
		try {
			FileOutputStream outFile = new FileOutputStream("liblist.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(outFile);
			objectOut.writeObject(al);
			objectOut.close();
			outFile.close();
			// System.out.println("Stored librarian list in liblist.ser");
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	/**
	 * Getter method used to retrieve data from serialized file and deserialize
	 * the data and return the ArrayList of Librarian stored in the file.
	 * 
	 * @return The ArrayList of Librarian stored in liblist.ser.
	 */
	public static ArrayList<Librarian> getLibList() {
		ArrayList<Librarian> libList = null;
		try {
			FileInputStream inFile = new FileInputStream("liblist.ser");
			ObjectInputStream objectIn = new ObjectInputStream(inFile);
			libList = (ArrayList<Librarian>) objectIn.readObject();
			objectIn.close();
			inFile.close();
			return libList;
		} catch (IOException e) {
			// e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			return null;
		}
	}

	/**
	 * Void method to save data currently stored in the program to the .ser
	 * files.
	 */
	public static void saveData() {
		Database.storeResourceList(SearchBrowse.getResources());
		Database.storeUserList(Librarian.getUsersList());
		Database.storeLibList(Librarian.getLibrarianList());
	}

	/**
	 * Method to be called when there are no files currently on the system.
	 * Should be set up to contain some data to avoid null pointer exception on
	 * program startup.
	 * 
	 */
	public static void setupFiles() {
		ArrayList<Resource> newResourceList = new ArrayList<Resource>();
		ArrayList<User> newUserList = new ArrayList<User>();
		ArrayList<Librarian> newLibList = new ArrayList<Librarian>();
		Resource resource1 = new Book("The Lord of The Rings Book", "2001",
				"LordAvatarBook.jpg", 3, "Tolkien", "Springer");
		Resource resource2 = new LaptopComputer("XPS", "2018",
				"XPSAvatarImage.jpeg", 3, "Dell", "XPS", "Windows");
		Resource resource3 = new DVD("The Lord of the Rings DVD", "2001",
				"LordAvatarDVD.jpg", 10, "Peter Jackson", "180");
		// ("TLOTR", 2001, null, 30);
		User user1 = new User("user1", "Random Student", "07938681415", "56",
				"Bay Campus", "SA1 8PP", "Avatar5.png");
		// User user2 = new User("user2", "user 1", "05454645", "56", "Bay
		// Campus", "SA1 8PP", "Avatar5.png");
		Librarian lib1 = new Librarian("lib1", "Best Librarian", "0886080038",
				"65", "Singleton Campus", "SA1 4FS", "Avatar5.png", "24/07");
		newResourceList.add(resource1);
		newResourceList.add(resource2);
		newResourceList.add(resource3);
		newUserList.add(user1);
		// newUserList.add(user2);
		newLibList.add(lib1);

		Database.storeResourceList(newResourceList);
		Database.storeUserList(newUserList);
		Database.storeLibList(newLibList);
	}
}