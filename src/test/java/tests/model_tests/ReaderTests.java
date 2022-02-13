package tests.model_tests;

import org.junit.Test;

import the_model.Reader;

public class ReaderTests {
	private Reader reader = new Reader();

	@Test
	public void parseAndSaveEvent_True_TestEmptyStringIsNotSaved() {
		reader.parseAndSaveEvent("");
		assert (reader.getResults().equals(""));
	}

	@Test
	public void parseAndSaveEvent_True_TestInvalidJSONIsNotSaved() {
		reader.parseAndSaveEvent("{invalid JSON");
		assert (reader.getResults().equals(""));
	}

	@Test
	public void parseAndSaveEvent_True_TestValidJSON() {
		reader.parseAndSaveEvent("{\"ts\":1551140352,\"pt\":55,"
				+ "\"si\":\"3380fb19-0bdb-46ab-8781-e4c5cd448074\","
				+ "\"uu\":\"0dd24034-36d6-4b1e-a6c1-a52cc984f105\","
				+ "\"bg\":\"77e28e28-745a-474b-a496-3c0e086eaec0\","
				+ "\"sha\":\"abb3ec1b8174043d5cd21d21fbe3c3fb3e9a11c7ceff3314a3222404feedda52\","
				+ "\"nm\":\"phkkrw.ext\",\"ph\":\"/efvrfutgp/expgh/phkkrw\",\"dp\":2}");
		assert (reader.getResults().equals("ext: 1\n"));
	}

	@Test
	public void parseAndSaveEvent_True_TestDuplicateFileNamesNotSaved() {
		reader.parseAndSaveEvent("{nm: file.txt}");
		reader.parseAndSaveEvent("{nm: file.txt}");
		assert (reader.getResults().equals("txt: 1\n"));
	}

	@Test
	public void parseAndSaveEvent_True_TestUniqueFileNamesAreSaved() {
		reader.parseAndSaveEvent("{nm: file.txt}");
		reader.parseAndSaveEvent("{nm: file1.txt}");
		assert (reader.getResults().equals("txt: 2\n"));
	}

	@Test
	public void parseAndSaveEvent_True_TestMissingTimestampIsSavedAsNull() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getTimeInfo().getTimestamp() == null);
	}

	@Test
	public void parseAndSaveEvent_True_TestMissingProcessingTimeIsSavedAsNull() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getTimeInfo()
				.getProcessingTime() == null);
	}

	@Test
	public void parseAndSaveEvent_True_TestMissingSessionIDIsSavedAsNull() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getIdInfo().getSessionID() == null);
	}

	@Test
	public void parseAndSaveEvent_True_TestMissingUserUUIDIsSavedAsNull() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getIdInfo().getUserUUID() == null);
	}

	@Test
	public void parseAndSaveEvent_True_TestMissingBusinessUUIDIsSavedAsNull() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getIdInfo()
				.getBusinessUUID() == null);
	}

	@Test
	public void parseAndSaveEvent_True_TestMissingSHAIsSavedAsNull() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getFile().getSha256() == null);
	}

	@Test
	public void parseAndSaveEvent_True_TestMissingFileNameIsSavedAsNull() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getFile().getFileName() == null);
	}

	@Test
	public void parseAndSaveEvent_True_TestMissingPathIsSavedAsNull() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getFile().getPath() == null);
	}

	@Test
	public void parseAndSaveEvent_True_TestMissingDipositionIsSavedAsNull() {
		reader.parseAndSaveEvent("{}");
		assert (reader.getEvents().get(0).getDiposition() == null);
	}

	@Test
	public void parseAndSaveEvent_True_TestEventsWithMissingFieldsAreSaved() {
		reader.parseAndSaveEvent("{nm: file.txt}");
		reader.parseAndSaveEvent("{nm: file.txt}");
		assert (reader.getEvents().size() == 2);
	}

	@Test
	public void parseAndSaveEvent_True_TestEventsWithMissingFileNameAreSaved() {
		reader.parseAndSaveEvent("{dp: 1}");
		assert (reader.getResults().equals(""));
	}

	@Test
	public void parseAndSaveEvent_True_TestIllegalDipositionValues() {
		reader.parseAndSaveEvent("{nm: file.txt, dp: 4}");
		assert (reader.getEvents().get(0).getDiposition() == null);
	}
}
