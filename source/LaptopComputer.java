
/**
 * Class that creates a new Laptop computer object
 * @author Boris Andreev and Kyriacos Mosphilis
 * @version 1.00
 */
import java.sql.ResultSet;

public class LaptopComputer extends Resource {

	private String manufacturer;
	private String model;
	private String OS;

	/**
	 * Constructor for a laptop.
	 * 
	 * @param title
	 *            Name of computer.
	 * @param year
	 *            Year of manufacture
	 * @param thumbnailImage
	 *            Picture of the laptop
	 * @param numOfCopies
	 *            Total available computers in the library
	 * @param manufacturer
	 *            Manufacturer of the computer
	 * @param model
	 *            Model of the computer
	 * @param OS
	 *            Operating system running on the laptop
	 */
	public LaptopComputer(String title, String year, String thumbnailImage,
			int numOfCopies, String manufacturer, String model, String OS) {
		super(title, year, thumbnailImage, numOfCopies);
		this.manufacturer = manufacturer;
		this.model = model;
		this.OS = OS;
	}

	/**
	 * Getter method for the manufacturer of the laptop
	 * 
	 * @return Manufacturer of the laptop
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Getter method for the model of the laptop
	 * 
	 * @return The model of the laptop
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Getter method for laptop OS
	 * 
	 * @return Operating system running on the laptop
	 */
	public String getOS() {
		return OS;
	}

	/**
	 * Setter method for the laptop manufacturer.
	 * 
	 * @param manufacturer
	 *            String for the laptop manufacturer
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * Getter method for the laptop model.
	 * 
	 * @param model
	 *            Model of the laptop.
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Setter method for the laptop OS.
	 * 
	 * @param OS
	 *            The operating system of the laptop.
	 */
	public void setOS(String OS) {
		this.OS = OS;
	}

	/**
	 * To string method for the laptop.
	 */
	public String toString() {
		String result = super.toString();
		result += "\nManufacturer:\t\t" + this.getManufacturer()
				+ "\nModel:\t\t\t" + this.getModel() + "\nOS:\t\t\t\t"
				+ this.getOS();
		return result;
	}
}
