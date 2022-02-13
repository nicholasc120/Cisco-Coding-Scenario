package the_model.event_data;

/**
 * Represents identification-related data for an event.
 * 
 * @author Nicholas Cervania
 *
 */
public class IdentificationInformation {
	/** session ID */
	private String sessionID;
	/** user UUID */
	private String userUUID;
	/** business UUID */
	private String businessUUID;

	/**
	 * Construct new IdentificationInformation object
	 * 
	 * @param sessionID the session ID of the event
	 * @param userUUID the User UUID of the event
	 * @param businessUUID the business UUID of the event
	 */
	public IdentificationInformation(String sessionID, String userUUID, String businessUUID) {
		this.sessionID = sessionID;
		this.userUUID = userUUID;
		this.businessUUID = businessUUID;
	}

	/**
	 * 
	 * @param sessionID the session ID
	 */
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	/**
	 * 
	 * @return the session ID of the event
	 */
	public String getSessionID() {
		return sessionID;
	}

	/**
	 * 
	 * @param userUUID the user UUID
	 */
	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}

	/**
	 * 
	 * @return the user UUID of the event
	 */
	public String getUserUUID() {
		return userUUID;
	}

	/**
	 * 
	 * @param businessUUID the business UUID
	 */
	public void setBusinessUUID(String businessUUID) {
		this.businessUUID = businessUUID;
	}

	/**
	 * 
	 * @return the business UUID of the event
	 */
	public String getBusinessUUID() {
		return businessUUID;
	}
}
