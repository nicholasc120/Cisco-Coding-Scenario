package tests.model_tests.event_data_tests;

import org.junit.jupiter.api.Test;

import the_model.event_data.File;

/**
 * Unit Tests for the File class methods
 * 
 * @author Nicholas Cervania
 *
 */
class FileTests {
	private File file = new File(null, null, null);

	/**
	 * Test that file extension regex works properly
	 * @result "file.txt" should return "txt"
	 */
	@Test
	void test_extension_returned() {
		file.setFileName("file.txt");
		assert (file.getFileExtension().equals("txt"));
	}

	/**
	 * Test that file extension regex works properly with multiple extensions
	 * @result "file.txt.pdf.docx" should return "docx"
	 */
	@Test
	void test_extension_returned_for_multiple_extensions() {
		file.setFileName("file.txt.pdf.docx");
		assert (file.getFileExtension().equals("docx"));
	}

	/**
	 * Test that "No Extension is returned for files without an extension
	 * @result should return "No Extension" when filename does not include extension
	 */
	@Test
	void test_file_no_extension_returned() {
		file.setFileName("file");
		assert (file.getFileExtension().equals("No Extension"));
	}

	/**
	 * Test that null is returned when fileName is null
	 * @result should return null
	 */
	@Test
	void test_no_returned() {
		file.setFileName(null);
		assert (file.getFileExtension() == null);
	}
}
