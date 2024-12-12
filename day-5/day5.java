import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

class day5 {
	public static ArrayList<int[]> rules = new ArrayList<int[]>();
	public static ArrayList<int[]> pageNumbers = new ArrayList<int[]>();

	public static void main(String[] args) {
		readFile();
		for (int i = 0; i < pageNumbers.size(); i++) {
			for (int j = 0; j < pageNumbers.get(i).length; j++) {
				System.out.print(pageNumbers.get(i)[j] + ", ");
			}
			System.out.println();
		}

	}

	public static void readFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
			String line = reader.readLine();

			while (line != "") {
				try {
					String[] parts = line.split("\\|");
					int[] rule = new int[parts.length];
					for (int i = 0; i < parts.length; i++) {
						rule[i] = Integer.parseInt(parts[i].trim());
					}
					rules.add(rule);
				} catch (NumberFormatException e) {
					break;
				}
				line = reader.readLine();
			}

			line = reader.readLine();

			while (line != null) {
				try {
					String[] parts = line.split(",");
					int[] update = new int[parts.length];
					for (int i = 0; i < parts.length; i++) {
						update[i] = Integer.parseInt(parts[i].trim());
					}
					pageNumbers.add(update);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				line = reader.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
