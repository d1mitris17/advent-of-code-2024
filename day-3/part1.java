import java.util.ArrayList;

/**
 * part1
 */
public class part1 {

	public static int getTotalFromMul(ArrayList<String> data) {
		int total = 0;

		for (String line : data) {
			int i = 0;
			while (i < (line.length() - 6)) {
				// check if found "mul("
				if ((line.substring(i, i + 4).equals("mul("))) {
					int max = i + 12;
					// if the line is shorter than the max length, set max to the length of the line
					if (max >= line.length()) {
						max = line.length();
					}

					// set the right bracket to the 7th character after the 'm' as it is the minimum
					int rightB = i + 7;

					// if the line is shorter than the initial right bracket, move to a new line
					if (rightB >= line.length()) {
						System.out.println("Error: Line is too short");
						System.out.println(line.substring(i, max));
						break;
					}

					// find the right bracket
					while (rightB < max && line.charAt(rightB) != ')') {
						rightB += 1;
					}

					// if the right bracket is not found, move to the next character in the line
					if (rightB >= max || line.charAt(rightB) != ')') {
						System.out.println("Error: Right bracket not found");
						System.out.println(line.substring(i, max));
						i++;
						continue;
					}

					int commaI = rightB - 2;
					while (commaI > i + 4 && line.charAt(commaI) != ',') {
						commaI -= 1;
					}

					if (commaI <= i + 4) {
						System.out.println("Error: Comma not found");
						System.out.println(line.substring(i, max));
						i++;
						continue;
					}

					try {
						int n1 = Integer.parseInt(line.substring(i + 4, commaI));
						int n2 = Integer.parseInt(line.substring(commaI + 1, rightB));

						total += (n1 * n2);
						i = rightB + 1;
					} catch (NumberFormatException e) {
						System.out.println("Error: Arithmetic error");
						System.out.println(line.substring(i, max));
						i++;
					}

				} else {
					i++;
				}
			}
		}
		return total;
	}

}
