import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class readInput {

	public static ArrayList<String> read_file(String file_name) {
		ArrayList<String> data = new ArrayList<String>();
		try {
			FileReader file = new FileReader(file_name);
			BufferedReader reader = new BufferedReader(file);
			String line = reader.readLine();
			while (line != null) {
				data.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("an error occurred.");
			e.printStackTrace();
		}
		return data;
	}
}
