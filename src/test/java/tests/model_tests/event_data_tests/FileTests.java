package tests.model_tests.event_data_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import the_model.event_data.File;

class FileTests {
	private File file = new File(null, null, null);

	@Test
	void testFileExtension() {
		file.setFileName("file.txt");
		assert(file.getFileExtension().equals("txt"));
	}

	@Test
	void testMultipleFileExtensions() {
		file.setFileName("file.txt.pdf.docx");
		assert(file.getFileExtension().equals("docx"));
	}

	@Test
	void testNoExtension() {
		file.setFileName("file");
		assert(file.getFileExtension().equals("No Extension"));
	}

	@Test
	void testNullFile() {
		file.setFileName(null);
		assert(file.getFileExtension() == null);
	}
}
