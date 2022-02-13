package the_model.event_data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents file-related information about an Event.
 * 
 * @author Nicholas Cervania
 *
 */
public class File {
	/** sha256 of the file */
	private String sha256;
	/** file name */
	private String fileName;
	/** path */
	private String path;

	/**
	 * Constructs a new File object for an event.
	 * 
	 * @param sha256
	 *            the SHA256 of the file.
	 * @param fileName
	 *            the name of the file.
	 * @param path
	 *            the path to the file.
	 */
	public File(String sha256, String fileName, String path) {
		this.sha256 = sha256;
		this.fileName = fileName;
		this.path = path;
	}
	/**
	 * 
	 * @param sha256
	 *            the SHA256 of the file
	 */
	public void setSha256(String sha256) {
		this.sha256 = sha256;
	}

	/**
	 * 
	 * @return the SHA256 of the file
	 */
	public String getSha256() {
		return sha256;
	}

	/**
	 * 
	 * @param fileName
	 *            the file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 
	 * @param path
	 *            the path to the file
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * 
	 * @return the path to the file
	 */
	public String getPath() {
		return path;
	}
	/**
	 * Use regex to find the extension of the file.
	 * 
	 * @return The file extension if the file has an extension. "No extension"
	 *         if the file has no extension. Null if the file has not been set.
	 */
	public String getFileExtension() {
		if (fileName != null) {
			Pattern pattern = Pattern.compile("\\.([a-zA-Z0-9]+)$");
			Matcher matcher = pattern.matcher(fileName);
			return matcher.find() ? matcher.group(1) : "No Extension";
		}
		return null;
	}
}
