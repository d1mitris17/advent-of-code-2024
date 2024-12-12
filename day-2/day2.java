import java.util.ArrayList;

public class day2 {

	public static void main(String[] args) {
		// Read the file
		ArrayList<Integer[]> data = day2_file_read.read_file("input.txt");
		int safe_levels = part1.getSafeLevels(data);
		// Print the result
		System.out.println("Safe levels: " + safe_levels);
	}

}
