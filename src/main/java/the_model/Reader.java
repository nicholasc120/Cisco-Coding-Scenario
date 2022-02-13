package the_model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Save events from JSON format and return results
 * 
 * @author Nicholas Cervania
 *
 */
public class Reader {
	/**
	 * Dictionary with file extension keys and HashSet file names. Used to determine
	 * the number of unique file names for each extension
	 */
	private HashMap<String, HashSet<String>> extensions;
	/** ArrayList to store events parsed by reader. */
	private ArrayList<Event> events;

	/**
	 * Construct new Reader object and necessary members.
	 */
	public Reader() {
		extensions = new HashMap<String, HashSet<String>>();
		events = new ArrayList<Event>();
	}

	/**
	 * Parses an Event object from a line of JSON. The event is saved alongside the
	 * processing of the file names and extensions if and only if the line of JSON
	 * is syntactically valid. Missing fields will be saved as null.
	 * 
	 * @param JSON The line of JSON representing the Event object.
	 */
	public void parseAndSaveEvent(String JSON) {
		if (JSON.isBlank()) {
			return;
		}
		try {
			Event event = new Gson().fromJson(JSON, Event.class);
			events.add(event);
			addToExtensionsAndNames(event.getFileExtension(), event.getFileName());
		} catch (JsonSyntaxException e) {
			System.err.println("Invalid JSON. Skipping...");
			return;
		}
	}

	/**
	 * Helper function to save the file extension and file name of a function. If a
	 * new file extension is being added, a new HashSet for unique filenames of that
	 * extension will be constructed. Otherwise, the file name will be added to the
	 * existing HashSet.
	 * 
	 * @param extension the file extension.
	 * @param fileName  the name of the file.
	 */
	private void addToExtensionsAndNames(String extension, String fileName) {
		if (!extensions.containsKey(extension)) {
			HashSet<String> fileNames = new HashSet<String>();
			fileNames.add(fileName);
			extensions.put(extension, fileNames);
		} else {
			extensions.get(extension).add(fileName);
		}
	}

	/**
	 * Returns each type of extension followed by the number of extensions of that
	 * type.
	 * 
	 * @return String containing the results with each filetype on a new line.
	 */
	public String getResults() {
		String result = "";
		for (String key : extensions.keySet()) {
			result += key + ": " + extensions.get(key).size() + "\n";
		}
		return result;
	}

	/**
	 * Getter for the Events ArrayList.
	 * 
	 * @return the Events ArrayList.
	 */
	public ArrayList<Event> getEvents() {
		return events;
	}
}
