package course.jenkins.lab;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import course.jenkins.lab.ZipCodeParser;

public class ZipCodeParserTest {

	@Ignore	
	public void testZipWith5() {
		String zipWith5 = "12345";

		String[] zipParts = ZipCodeParser.parseZipCode(zipWith5);
		assertEquals(zipWith5, zipParts[0]);
		assertNull(zipParts[1]);
	}

	@Ignore
	public void testZipWith9() {
		String zipWith9 = "123456789";

		String[] zipParts = ZipCodeParser.parseZipCode(zipWith9);
		assertEquals(zipWith9.substring(0, 5), zipParts[0]);
		assertEquals(zipWith9.substring(5, 9), zipParts[1]);
	}

	@Ignore
	public void testZipWithDash() {
		String zipWithDash = "12345-6789";

		String[] zipParts = ZipCodeParser.parseZipCode(zipWithDash);
		assertEquals(zipWithDash.substring(0, 5), zipParts[0]);
		assertEquals(zipWithDash.substring(6, 10), zipParts[1]);
	}

	@Ignore
	public void testZipWithSpace() {
		String zipWithSpace = "12345 6789";

		String[] zipParts = ZipCodeParser.parseZipCode(zipWithSpace);
		assertEquals(zipWithSpace.substring(0, 5), zipParts[0]);
		assertEquals(zipWithSpace.substring(6, 10), zipParts[1]);
	}

	@Ignore
	public void testZipInvalid() {
		String zipInvalid = "1234";

		String[] zipParts = ZipCodeParser.parseZipCode(zipInvalid);
		assertNull(zipParts[0]);
		assertNull(zipParts[1]);
	}
	
	@Ignore
	public void testZip5WithSpecialCharacterAtEnd() {
		String zipWithSpecialCharacterAtEnd = "12345A";

		String[] zipParts = ZipCodeParser.parseZipCode(zipWithSpecialCharacterAtEnd);
		assertEquals(zipWithSpecialCharacterAtEnd.substring(0, 5), zipParts[0]);
		assertEquals(null, zipParts[1]);
	}
	
	@Ignore
	public void testZip9WithSpecialCharacterInBetween() {
		String zipWithSpecialCharacterInBetween = "12345A6789";

		String[] zipParts = ZipCodeParser.parseZipCode(zipWithSpecialCharacterInBetween);
		assertEquals(zipWithSpecialCharacterInBetween.substring(0, 5), zipParts[0]);
		assertEquals(zipWithSpecialCharacterInBetween.substring(6, 10), zipParts[1]);
	}
	
	@Test
	public void testZipCodeParserShouldSetNullValuesWhenPassesNullValue() throws Exception {
		String[] zipParts = ZipCodeParser.parseZipCode(null);
		assertNull(zipParts[0]);
		assertNull(zipParts[1]);
	}
}
