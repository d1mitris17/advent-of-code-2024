import java.util.ArrayList;

/**
 * part1
 */
public class part1 {

	public static ArrayList<String> clean_data(ArrayList<String> data) {

		ArrayList<String> cleaned_data = new ArrayList<String>();

		for (String line : data) {
			line = line.replace(" ", "");
			int i = 0;
			while (i < line.length()) {
				if (line.charAt(i) == 'm') {
					int max = i + 11;

					if (max >= line.length()) {
						max = line.length() - 1;
					}
					int current = i + 7;

					while (line.charAt(current) != ')' && current < max) {
						current += 1;
					}
					if (is_valid(line.substring(i, current + 1))) {
						cleaned_data.add(line.substring(i, current + 1));
						i = current;
					}

				}
				i++;
			}
		}
		return cleaned_data;
	}

	private static boolean is_valid(String s) {
		System.out.println("currrent checking: " + s);

		if (s.length() <= 6) {
			return false;
		}
		System.out.println("Its length is good");
		if (!(s.substring(0, 3).equals("mul"))) {
			return false;
		}
		System.out.println("Its mul is good");
		if (s.charAt(3) != '(') {
			return false;
		}
		System.out.println("Its ( is good");
		int commaI = s.length() - 1;
		while (s.charAt(commaI) != ',' && commaI > 4) {
			commaI -= 1;
		}
		System.out.println("Its , is good");
		if (commaI == 4) {
			return false;
		}
		System.out.println("Its commaI is good");
		for (int i = 4; i < commaI; i++) {
			if (!(Character.isDigit(s.charAt(i))))
				return false;
		}
		System.out.println("Its first part is good");
		for (int i = (commaI + 1); i < (s.length() - 1); i++) {
			System.out.println("s.charAt(i): " + s.charAt(i));
			if (!(Character.isDigit(s.charAt(i))))
				return false;
		}
		System.out.println("Its second part is good");
		System.out.println("");
		System.out.println("");

		return true;
	}

}
