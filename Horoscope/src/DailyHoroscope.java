import java.net.URL;
import java.util.Scanner;
import java.io.IOException;

/**
 * This class scrapes the webpage horoscope.com for the different signs and
 * returns the appropriate message depending on the sign.
 * 
 * @author Vidit Makwana
 *
 */
public class DailyHoroscope {

	String sign;

	/**
	 * This method is a simple getter for the zodiac sign.
	 * 
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * This method scrapes the webpage respective to the sign in the parameter and
	 * returns today's message for that sign.
	 * 
	 * @param sign
	 * @return the message respective to the sign in the parameter
	 * @throws IOException
	 */
	public String getMessage(String sign) throws IOException {
		this.sign = sign;
		URL url = null;
		switch (sign) {
		case ("Aries"):
			url = new URL("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=1");
			break;
		case ("Taurus"):
			url = new URL("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=2");
			break;
		case ("Gemini"):
			url = new URL("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=3");
			break;
		case ("Cancer"):
			url = new URL("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=4");
			break;
		case ("Leo"):
			url = new URL("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=5");
			break;
		case ("Virgo"):
			url = new URL("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=6");
			break;
		case ("Libra"):
			url = new URL("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=7");
			break;
		case ("Scorpio"):
			url = new URL("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=8");
			break;
		case ("Sagittarius"):
			url = new URL("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=9");
			break;
		case ("Capricorn"):
			url = new URL("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=10");
			break;
		case ("Aquarius"):
			url = new URL("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=11");
			break;
		case ("Pisces"):
			url = new URL("https://www.horoscope.com/us/horoscopes/general/horoscope-general-daily-today.aspx?sign=12");
		}
		Scanner scanner = new Scanner(url.openStream());
		StringBuffer pageContent = new StringBuffer();
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			pageContent.append(line);
		}
		scanner.close();
		int startIndex = pageContent.indexOf("</strong> - ") + 11;
		int endIndex = pageContent.indexOf("</p>");
		String message = pageContent.substring(startIndex, endIndex);
		return message;

	}

}
