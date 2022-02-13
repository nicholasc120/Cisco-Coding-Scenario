package the_model;

import the_model.event_data.*;

/**
 * Stores data from the JSON object.
 * 
 * @author Nicholas Cervania
 */
public class Event {
	/** Time-related information */
	private final EventTimeInfo timeInfo;
	/** ID information */
	private final IdentificationInformation idInfo;
	/** File from the event */
	private final File file;
	/** diposition value */
	private Diposition diposition;

	/**
	 * Construct new Event object.
	 * 
	 * @param timeInfo
	 *            EventTimeInfo object containing time-related information about
	 *            the event.
	 * @param idInfo
	 *            IdentifciationInformation object containing
	 *            identification-related information about the event.
	 * @param file
	 *            File object containing file-related information about the
	 *            event.
	 * @param diposition
	 *            Diposition enumeration representing the diposition code value
	 *            for the event.
	 */
	public Event(EventTimeInfo timeInfo, IdentificationInformation idInfo,
			File file, Diposition diposition) {
		this.timeInfo = timeInfo;
		this.idInfo = idInfo;
		this.file = file;
		this.diposition = diposition;
	}

	/**
	 * 
	 * @return the EventTimeInfo object of the event.
	 */
	public EventTimeInfo getTimeInfo() {
		return timeInfo;
	}

	/**
	 * 
	 * @return the IdentificationInformation object of the event.
	 */
	public IdentificationInformation getIdInfo() {
		return idInfo;
	}

	/**
	 * 
	 * @return the File object of the event.
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Set the Diposition value
	 * 
	 * @param diposition
	 *            Diposition enumeration.
	 */
	public void setDiposition(Diposition diposition) {
		this.diposition = diposition;
	}

	/**
	 * 
	 * @return the diposition enumeration
	 */
	public Diposition getDiposition() {
		return diposition;
	}
}
