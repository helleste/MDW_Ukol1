import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author helleste@fit.cvut.cz
 *
 */
public class FormatTransformator {
	
	private static final String NAME = "name";
	private static final String START = "start";
	private static final String LOCATION = "location";
	private static final String SUMMARY = "sumary";

	/**
	 * Main function starts the whole process of converting formats.
	 * 
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		parseString();

	}
	
	/**
	 * This parses the data from Format1 to Format2.
	 * 
	 * @throws ParseException
	 */
	private static void parseString() throws ParseException {
		
		List<String> lines = new ArrayList<String>();
		lines = Arrays.asList(Format1Container.getDATA1().split("\n"));
		lines = clearArray(lines);
		
		Address address = parseAddress(lines.get(lines.indexOf(LOCATION) + 1));
		String name = lines.get(lines.indexOf(NAME) +1) +
				" - " +
				lines.get(lines.indexOf(SUMMARY) +1);
		String date = convertDate(lines.get(lines.indexOf(START) +1));
		Format2Container format2 = new Format2Container(
				name, 
				date, 
				address);
		convertDate(lines.get(lines.indexOf(START) +1));
		System.out.println(format2.toString());
		
	}
	
	/**
	 * This removes '--' from strings in the array.
	 * 
	 * @param list
	 * @return
	 */
	private static List<String> clearArray(List<String> list) {
		
		for (int i = 0; i < list.size();i++) {
			list.set(i, list.get(i).replace("--", ""));
		}

		return list;
	}
	
	/**
	 * This parses individual parts of an address.
	 * 
	 * @param addr
	 * @return
	 */
	private static Address parseAddress(String addr) {
		
		String[] addressParts = addr.split(", ");
		
		Address address = new Address(addressParts[0], addressParts[1], addressParts[2]);
		
		return address;
	}
	
	/**
	 * This removes suffixes from date for further formating.
	 * 
	 * @param date
	 * @return
	 */
	private static String deleteSuffixes(String date) {
		String[] suffixes = {"st", "nd", "rd", "th"};
		
		for (String suff : suffixes) {
			date = date.replace(suff, "");
		}
		
		return date;
	}
	
	/**
	 * This converts date as per Format1 by the Format2 rules.
	 * 
	 * @param textDate
	 * @return
	 * @throws ParseException
	 */
	private static String convertDate(String textDate) throws ParseException {
		textDate = deleteSuffixes(textDate);
		Date date = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH).parse(textDate);
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.M.yyyy");
		String newDate = DATE_FORMAT.format(date);
		
		return newDate;
	}

}
