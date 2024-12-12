import java.util.ArrayList;

/**
 * day-3
 */
public class day3 {

	public static void main(String[] args) {
		ArrayList<String> data = readInput.read_file("input.txt");
		int total = part1.getTotalFromMul(data);
		System.out.println("This is the total: " + total);
	}
}
