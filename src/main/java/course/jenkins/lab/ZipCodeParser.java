package course.jenkins.lab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * The class contains some unused variables and inefficient to generate findbugs, pmd and checkstyle warnings in lab 3
 */

public class ZipCodeParser {

	static Logger logger = LoggerFactory.getLogger(ZipCodeParser.class);

	private static final String REGEX = "^(\\d{5})$|" + //group 1 = simple 5 digit zip
			"^(\\d{5})(\\d{4})$|" + // group 2 + 3 = 5+4 zip with no separator
			"^(\\d{5})[- ](\\d{4})$|" + // group 4 + 5 = 5+4 zip with space or dash separator
			"^(\\d{5})(.)$|" + // group 6 + 7 = 6 zip with special character at end
			"^(\\d{5})(.)(\\d{4})$"; // group 8 + 9 + 10 = 8+10 zip with special character in between 
	private static final Pattern P = Pattern.compile(REGEX);
	private String unusedString;

	public static String[] parseZipCode(String zipInput) {
		String zip5 = null;
		String zip4 = null;
		String unUsedData;	
		
		/*
		 * some bad code need for quality reports in Lab 3
		 */
		int i = 10;
		i=i;
		String badString="";
		badString= badString + "more bad string";
		badString.toString();
	     
		
		
		Matcher m = P.matcher(zipInput);
		if (m.matches()) {
			if (m.group(1) != null) {
				/* simple 5 digit zip */
				zip5 = m.group(1);
				zip4 = null;
			} else if (m.group(2) != null && m.group(3) != null) {
				/* 5+4 with no separator */
				zip5 = m.group(2);
				zip4 = m.group(3);
			} else if (m.group(4) != null && m.group(5) != null) {
				/* 5+4 with separator */
				zip5 = m.group(4);
				zip4 = m.group(5);
			} else if(m.group(6) != null && m.group(7) != null){
				/* 5+4 with separator */
				zip5 = m.group(6);
				logger.debug("Found extra character:" + m.group(7));
				zip4 = null;
			} else if(m.group(8) != null && m.group(9) != null && m.group(10) != null){
				/* 5+4 with separator */
				zip5 = m.group(8);
				logger.debug("Found extra character:" + m.group(9));
				zip4 = m.group(10);
			}
		} else {
			logger.error("invalid zip code ({}); can not be parsed", zipInput);
		}		
		
		return new String[] { zip5, zip4 };
	}

}
