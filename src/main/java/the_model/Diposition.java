package the_model;

import com.google.gson.annotations.SerializedName;

/**
 * Possible values for Diposition.
 * 
 * @author Nicholas Cervania
 *
 */
public enum Diposition {
	@SerializedName("1")
	MALICIOUS,
	@SerializedName("2")
	CLEAN,
	@SerializedName("3")
	UNKNOWN;

}
