package the_model.event_data;

/**
 * Possible values for Diposition.
 * 
 * @author Nicholas Cervania
 *
 */
public enum Diposition {
	MALICIOUS, CLEAN, UNKNOWN;

	/**
	 * Retruns a Diposition enum based off the code
	 * 
	 * @param dp
	 *            the diposition code. Valid values are 1, 2, and 3.
	 * @return a Diposition enum if code is valid, null otherwise.
	 */
	public static Diposition fromCode(int dp) {
		switch (dp) {
			case 1 :
				return MALICIOUS;
			case 2 :
				return CLEAN;
			case 3 :
				return UNKNOWN;
			default :
				return null;
		}
	}
}
