import java.awt.Image;
import java.io.*;
import java.util.*;

/**
 * The profile image class allows the user to select between 5 set images
 * 
 * @author Riyaad Islam and Oliver Nixon
 * @version 1.0.0
 */
public class ProfileImage {
    private String profileimageName;
    private Image image;
    private Image avatars[] = new Image[5];

    /**
     * @return Returns an image
     */
    public Image getImage() {
	return image;
    }

    /**
     * @param image sets the image
     */
    public void setImage(Image image) {
	this.image = image;
    }

    /**
     * Constructor for the profile image object
     * 
     * @param profileimageName String that sets the name of the image
     * @param image            File to be used as a profile image
     * @param avatars          Array holding the profile images
     */
    public ProfileImage(String profileimageName, Image image, Image[] avatars) {
	this.profileimageName = profileimageName;
	this.image = image;
	this.avatars = avatars;
    }

    /**
     * Getter method for the array holding the images
     * 
     * @return Array holding the avatars
     */
    public Image[] getAvatars() {
	return avatars;
    }

    /**
     * Sets the the images used as avatars
     * 
     * @param avatars Array of images
     */
    public void setAvatars(Image[] avatars) {
	this.avatars = avatars;
    }

    /**
     * Sets the avatar name
     * 
     * @param in scanner that sets the image name
     * 
     */
    public ProfileImage(Scanner in) {
	this.profileimageName = in.next().trim();
    }

    /**
     * Getter method for the image name
     * 
     * @return Returns profile image name
     */
    public String getImageName() {
	return this.profileimageName;
    }

    /**
     * Method that writes the image to a file
     * 
     * @param file File to which the information should be written
     * @throws IOException Exception thrown if the file doesnt exist
     */
    public void toFile(BufferedWriter file) throws IOException {
	file.write("Image); " + profileimageName + image);
	file.newLine();
    }

    /**
     * Method print the picture.
     */
    @Override
    public String toString() {
	return this.profileimageName;
    }
}
