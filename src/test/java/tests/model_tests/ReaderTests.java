package tests.model_tests;

import org.junit.Test;

import the_model.Reader;

/**
 * Unit tests for the Reader class
 * 
 * @author Nicholas Cervania
 *
 */
public class ReaderTests {
	private Reader reader = new Reader();

	/**
	 * Test that an empty string is not parsed by reader
	 * 
	 * @result empty string will not be saved
	 */
	@Test
	public void test_empty_string_is_not_saved() {
		reader.parseAndSaveEvent("");
		assert (reader.getResults().equals(""));
	}

	/**
	 * Test that malformed JSON lines are discarded
	 * 
	 * @result results of the invalid JSON are not saved
	 */
	@Test
	public void test_invalid_JSON_is_not_saved() {
		reader.parseAndSaveEvent("\"nm\":\"phkkrw.ext\"");
		assert (reader.getResults().equals(""));
	}

	/**
	 * Test that valid JSON is processed correctly
	 * 
	 * @result results of the JSON are saved correctly
	 */
	@Test
	public void test_valid_JSON_outputs_correctly() {
		reader.parseAndSaveEvent("{\"ts\":1551140352,\"pt\":55,"
				+ "\"si\":\"3380fb19-0bdb-46ab-8781-e4c5cd448074\","
				+ "\"uu\":\"0dd24034-36d6-4b1e-a6c1-a52cc984f105\","
				+ "\"bg\":\"77e28e28-745a-474b-a496-3c0e086eaec0\","
				+ "\"sha\":\"abb3ec1b8174043d5cd21d21fbe3c3fb3e9a11c7ceff3314a3222404feedda52\","
				+ "\"nm\":\"phkkrw.ext\",\"ph\":\"/efvrfutgp/expgh/phkkrw\",\"dp\":2}");
		assert (reader.getResults().equals("ext: 1\n"));
	}

	/**
	 * Test that duplicate file names are not saved in the HashSet for the
	 * extension
	 * 
	 * @result the HashSet will only save one filename for each extension
	 */
	@Test
	public void test_duplicate_file_names_are_not_saved() {
		reader.parseAndSaveEvent("{nm: file.txt}");
		reader.parseAndSaveEvent("{nm: file.txt}");
		assert (reader.getResults().equals("txt: 1\n"));
	}

	/**
	 * Test that unique file names are saved in the HashSet for the extension
	 * 
	 * @result the HashSet will save each unique file name for each extension
	 */
	@Test
	public void test_unique_file_names_are_saved() {
		reader.parseAndSaveEvent("{nm: file.txt}");
		reader.parseAndSaveEvent("{nm: file1.txt}");
		assert (reader.getResults().equals("txt: 2\n"));
	}

	/**
	 * Test that missing timestamp field is saved as null when missing from JSON
	 * 
	 * @result missing field will be null
	 */
	@Test
	public void test_missing_timestamp_is_saved_as_null() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getTimeInfo().getTimestamp() == null);
	}

	/**
	 * Test that missing processing time field is saved as null when missing
	 * from JSON
	 * 
	 * @result missing field will be null
	 */
	@Test
	public void test_missing_processing_time_is_saved_as_null() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getTimeInfo()
				.getProcessingTime() == null);
	}

	/**
	 * Test that missing session ID field is saved as null when missing from
	 * JSON
	 * 
	 * @result missing field will be null
	 */
	@Test
	public void test_missing_session_ID_is_saved_as_null() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getIdInfo().getSessionID() == null);
	}

	/**
	 * Test that missing user UUID field is saved as null when missing from JSON
	 * 
	 * @result missing field will be null
	 */
	@Test
	public void test_missing_user_UUID_is_saved_as_null() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getIdInfo().getUserUUID() == null);
	}

	/**
	 * Test that missing business UUID field is saved as null when missing from
	 * JSON
	 * 
	 * @result missing field will be null
	 */
	@Test
	public void test_missing_business_UUID_is_saved_as_null() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getIdInfo()
				.getBusinessUUID() == null);
	}

	/**
	 * Test that missing SHA256 field is saved as null when missing from JSON
	 * 
	 * @result missing field will be null
	 */
	@Test
	public void test_missing_sha_is_saved_as_null() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getFile().getSha256() == null);
	}

	/**
	 * Test that missing timestamp field is saved as null when missing from JSON
	 * 
	 * @result missing field will be null
	 */
	@Test
	public void test_missing_filename_is_saved_as_null() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getFile().getFileName() == null);
	}

	/**
	 * Test that missing path field is saved as null when missing from JSON
	 * 
	 * @result missing field will be null
	 */
	@Test
	public void test_missing_path_is_saved_as_null() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getFile().getPath() == null);
	}

	/**
	 * Test that missing diposition field is saved as null when missing from
	 * JSON
	 * 
	 * @result missing field will be null
	 */
	@Test
	public void test_missing_diposition_is_saved_as_null() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getDiposition() == null);
	}

	/**
	 * Test that illegal diposition values are saved as null
	 * 
	 * @result The diposition value is null
	 */
	@Test
	public void test_illegal_diposition_value() {
		reader.parseAndSaveEvent("{nm: file.txt, dp: 4}");
		assert (reader.getEvents().get(0).getDiposition() == null);
	}

	/**
	 * Test that Reader can still process JSON name fields when other fields are
	 * missing
	 * 
	 * @result both events will be saved, despite missing other fields.
	 */
	@Test
	public void test_events_with_missing_fields_are_processed() {
		reader.parseAndSaveEvent("{nm: file.txt}");
		reader.parseAndSaveEvent("{nm: file.txt}");
		assert (reader.getEvents().size() == 2);
	}

	/**
	 * Test that Reader saves events when filenames are missing and results are
	 * correct
	 * 
	 * @result The event is saved but the results are an empty string
	 */
	@Test
	public void test_events_with_missing_filename_is_saved() {
		reader.parseAndSaveEvent("{dp: 1}");
		assert (reader.getResults().equals("")
				&& reader.getEvents().size() == 1);
	}
}
