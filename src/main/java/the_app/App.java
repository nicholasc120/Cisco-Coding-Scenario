package the_app;

import the_model.Reader;

import java.util.*;
import java.io.*;

public class App {

	/**
	 * Reads a file line-by-line and outputs metrics based on file information.
	 * 
	 * @param args[0]
	 *            The path to the file being read.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Error: Please supply a path name.");
			System.exit(1);
		}

		try {
			Scanner sc = new Scanner(new File(args[0]));
			Reader reader = new Reader();
			while (sc.hasNextLine()) {
				String nextLine = sc.nextLine();
				reader.parseAndSaveEvent(nextLine);
			}
			sc.close();
			System.out.print(reader.getResults());
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found.");
			System.exit(1);
		}
	}
}