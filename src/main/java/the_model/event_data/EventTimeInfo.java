package the_model.event_data;

/**
 * Represents time-related data for an Event.
 * 
 * @author Nicholas Cervania
 *
 */
public class EventTimeInfo {
	/** timestamp */
	private Integer timestamp;
	/** processing time */
	private Integer processingTime;

	/**
	 * Constructs a new EventTimeInfo event.
	 * 
	 * @param timestamp the timestamp of the event. Can be null.
	 * @param processingTime the processing time of the event. Can be null.
	 */
	public EventTimeInfo(Integer timestamp, Integer processingTime) {
		this.timestamp = timestamp;
		this.processingTime = processingTime;
	}

	/**
	 * 
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * 
	 * @return the timestamp of the event
	 */
	public int getTimestamp() {
		return timestamp;
	}

	/**
	 * 
	 * @param processingTime the processing time
	 */
	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}

	/**
	 * 
	 * @return the processing time of the event
	 */
	public int getProcessingTime() {
		return processingTime;
	}

}
