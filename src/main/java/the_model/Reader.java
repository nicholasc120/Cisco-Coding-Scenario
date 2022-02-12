package the_model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.google.gson.Gson;

public class Reader {
	private HashMap<String, HashSet<String>> extensions;
	private ArrayList<Event> events;

	public Reader() {
		extensions = new HashMap<String, HashSet<String>>();
		events = new ArrayList<Event>();
	}

	public void parseAndSaveEvent(String JSON) {
		try {
			Event event = new Gson().fromJson(JSON, Event.class);
			events.add(event);
			addToExtensionsAndNames(event.getFileExtension(), event.getFileName());
		} catch (RuntimeException e) {
			System.err.println("Invalid JSON. Skipping...");
			return;
		}
	}

	private void addToExtensionsAndNames(String extension, String fileName) {
		if (!extensions.containsKey(extension)) {
			HashSet<String> fileNames = new HashSet<String>();
			fileNames.add(fileName);
			extensions.put(extension, fileNames);
		} else {
			extensions.get(extension).add(fileName);
		}
	}

	public String getResults() {
		String result = "";
		for (String key : extensions.keySet()) {
			result += key + ": " + extensions.get(key).size() + "\n";
		}
		return result;
	}
}
