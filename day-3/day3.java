import java.util.ArrayList;

/**
 * day-3
 */
public class day3 {

	public static void main(String[] args) {
		ArrayList<String> data = readInput.read_file("input.txt");

		ArrayList<String> cleaned_data = part1.clean_data(data);
		System.out.println("This is the cleaned data");
		for (int i = 0; i < cleaned_data.size(); i++) {
			System.out.println(cleaned_data.get(i));
		}
	}
}
