package tests.model_tests.event_data_tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import the_model.event_data.Diposition;

class DipositionTests {

	@Test
	void fromCode_True_MaliciousCodeReturned() {
		assert (Diposition.fromCode(1) == Diposition.MALICIOUS);
	}

	@Test
	void fromCode_True_CleanCodeReturned() {
		assert (Diposition.fromCode(2) == Diposition.CLEAN);
	}

	@Test
	void fromCode_True_UnknownCodeReturned() {
		assert (Diposition.fromCode(3) == Diposition.UNKNOWN);
	}
	
	@Test
	void fromCode_True_NullReturnedFromInvalidCode() {
		assert(Diposition.fromCode(0) == null);
	}
}
