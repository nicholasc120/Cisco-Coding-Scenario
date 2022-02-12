package the_model;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Stores data from the JSON object
 * 
 * @author Nicholas Cervania
 */
public class Event {
	/** timestamp */
	private int ts;
	/** processing time */
	private int pt;
	/** session ID */
	private String si;
	/** user UUID */
	private String uu;
	/** business UUID */
	private String bg;
	/** sha256 of the file */
	private String sha;
	/** file name */
	private String nm;
	/** path */
	private String ph;
	/** diposition value */
	private Diposition dp;

	/**
	 *  
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(int timestamp) {
		this.ts = timestamp;
	}

	/**
	 * 
	 * @return the timestamp of the event
	 */
	public int getTimestamp() {
		return ts;
	}

	/**
	 * 
	 * @param processingTime the processing time
	 */
	public void setProcessingTime(int processingTime) {
		this.pt = processingTime;
	}

	/**
	 * 
	 * @return the processing time of the event
	 */
	public int getProcessingTime() {
		return pt;
	}

	/**
	 * 
	 * @param sessionID the session ID
	 */
	public void setSessionID(String sessionID) {
		this.si = sessionID;
	}

	/**
	 * 
	 * @return the session ID of the event
	 */
	public String getSessionID() {
		return si;
	}

	/**
	 * 
	 * @param userUUID the user UUID
	 */
	public void setUserUUID(String userUUID) {
		this.uu = userUUID;
	}

	/**
	 * 
	 * @return the user UUID of the event
	 */
	public String getUserUUID() {
		return uu;
	}

	/**
	 * 
	 * @param businessUUID the business UUID
	 */
	public void setBusinessUUID(String businessUUID) {
		this.bg = businessUUID;
	}

	/**
	 * 
	 * @return the business UUID of the event
	 */
	public String getBusinessUUID() {
		return bg;
	}

	/**
	 * 
	 * @param sha256 the SHA256 of the file
	 */
	public void setSha256(String sha256) {
		this.sha = sha256;
	}

	/**
	 * 
	 * @return the SHA256 of the file
	 */
	public String getSha256() {
		return sha;
	}

	/**
	 * 
	 * @param fileName the file name
	 */
	public void setFileName(String fileName) {
		this.nm = fileName;
	}

	/**
	 * 
	 * @return the file name
	 */
	public String getFileName() {
		return nm;
	}

	/**
	 * 
	 * @param path the path to the file
	 */
	public void setPath(String path) {
		this.ph = path;
	}

	/**
	 * 
	 * @return the path to the file
	 */
	public String getPath() {
		return ph;
	}

	// throw error if invalid value
	public void setDiposition(int diposition) {
		switch (diposition) {
		case 1:
			this.dp = Diposition.MALICIOUS;
			break;
		case 2:
			this.dp = Diposition.CLEAN;
			break;
		case 3:
			this.dp = Diposition.UNKNOWN;
			break;
		}
	}

	/**
	 * 
	 * @return the diposition enumeration
	 */
	public Diposition getDiposition() {
		return dp;
	}

	/**
	 * Use regex to find the extension of the file.
	 * 
	 * @return The file extension if the file has an extension.
	 * "No extension" if the file has no extension.
	 * Null if the file has not been set.
	 */
	public String getFileExtension() {
		if (nm != null) {
			Pattern pattern = Pattern.compile("\\.([a-zA-Z0-9]+)$");
			Matcher matcher = pattern.matcher(nm);
			return matcher.find() ? matcher.group(1) : "No extension";
		}
		return null;
	}
}
