package tests.model_tests.event_data_tests;

import org.junit.jupiter.api.Test;

import the_model.event_data.Diposition;

/**
 * Unit Tests for the Diposition enumeration functions
 * 
 * @author Nicholas
 *
 */
class DipositionTests {
	/**
	 * Test that the MALICIOUS value is returned for code value of 1
	 * 
	 * @result MALICIOUS value is returned
	 */
	@Test
	void test_malicious_code_returned() {
		assert (Diposition.fromCode(1) == Diposition.MALICIOUS);
	}

	/**
	 * Test that the CLEAN value is returned for code value of 2
	 * 
	 * @result CLEAN value is returned
	 */
	@Test
	void test_clean_code_returned() {
		assert (Diposition.fromCode(2) == Diposition.CLEAN);
	}

	/**
	 * Test that the UNKNOWN value is returned for code value of 3
	 * 
	 * @result UNKNOWN value is returned
	 */
	@Test
	void test_unknown_code_returned() {
		assert (Diposition.fromCode(3) == Diposition.UNKNOWN);
	}

	/**
	 * Test that the null value is returned for invalid code values
	 * 
	 * @result null is returned
	 */
	@Test
	void test_null_code_returned_for_invalid_code() {
		assert (Diposition.fromCode(0) == null);
	}
}
