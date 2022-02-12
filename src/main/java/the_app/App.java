package the_app;

import the_model.Reader;

import java.util.*;
import java.io.*;

public class App {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File(args[0]));
			Reader reader = new Reader();
			while (sc.hasNextLine()) {
				String nextLine = sc.nextLine();
				if (!nextLine.isBlank()) {
					reader.parseAndSaveEvent(nextLine);
				}
			}
			sc.close();
			System.out.println(reader.getResults());
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Error: Please supply a path name.");
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found.");
			System.exit(1);
		}
	}
}