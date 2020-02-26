
/**
 * Class that creates a DVD object
 * @author Boris Andreev and Kyriacos Mosphilis
 */
import java.sql.ResultSet;

public class DVD extends Resource {

	private String director;
	private String runtime;
	private String language = "";
	private String subtitles = "";

	/**
	 * Constructor for a DVD.
	 * 
	 * @param title
	 *            Title of the DVD.
	 * @param year
	 *            Year of release.
	 * @param thumbnailImage
	 *            Cover Image.
	 * @param numOfCopies
	 *            How many are available in the library.
	 * @param director
	 *            Director of the film.
	 * @param runtime
	 *            Runtime of film.
	 */

	public DVD(String title, String year, String thumbnailImage,
			int numOfCopies, String director, String runtime) {
		super(title, year, thumbnailImage, numOfCopies);
		this.director = director;
		this.runtime = runtime;
		// this.language = language;
		// this.subtitles = subtitles;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Getter method for film director
	 * 
	 * @return Name of film director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Getter method for film runtime
	 * 
	 * @return The runtime of the film
	 */
	public String getRuntime() {
		return runtime;
	}

	/**
	 * Getter method for the film's language
	 * 
	 * @return The language of the film
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Getter method for film's list of subtitles
	 * 
	 * @return Subtitles available for the film
	 */
	public String getSubtitles() {
		return subtitles;
	}

	/**
	 * Setter method for the film's subtitles
	 * 
	 * @param subtitles
	 *            String that holds the available subtitles
	 */
	public void setSubtitles(String subtitles) {
		this.subtitles = subtitles;
	}

	/**
	 * Setter method for the director of the film
	 * 
	 * @param director
	 *            Director of the film
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * Setter method for the DVDs runtime.
	 * 
	 * @param runtime
	 *            How long the film is
	 */
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String toString() {
		String result = super.toString();
		result += "\nDirector:\t\t\t" + this.getDirector() + "\nRuntime:\t\t\t"
				+ this.getRuntime() + " minutes" + "\nLanguage\t\t\t"
				+ this.getLanguage() + "\nSubtitles:\t\t\t"
				+ this.getSubtitles();
		return result;
	}

}
