import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * day2_file_read
 */
public class day2_file_read {

	public static ArrayList<Integer[]> read_file(String file_name) {
		ArrayList<Integer[]> data = new ArrayList<Integer[]>();
		try {
			FileReader file = new FileReader(file_name);
			BufferedReader reader = new BufferedReader(file);
			String line = reader.readLine();
			while (line != null) {
				String[] parts = line.trim().split("\\s+");
				Integer[] line_data = Arrays.stream(parts).map(Integer::parseInt)
						.toArray(Integer[]::new);
				data.add(line_data);
				for (Integer i : line_data) {
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return data;
	}
}
