import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;

class day5 {
	public static ArrayList<int[]> rules = new ArrayList<int[]>();
	public static ArrayList<int[]> pageNumbers = new ArrayList<int[]>();

	public static void main(String[] args) {
		readFile();
		/*
		 * for (int i = 0; i < pageNumbers.size(); i++) {
		 * for (int j = 0; j < pageNumbers.get(i).length; j++) {
		 * System.out.print(pageNumbers.get(i)[j] + ", ");
		 * }
		 * System.out.println();
		 * }
		 */
		int correctPages = getValidPages();
		System.out.println(correctPages);
	}

	public static void readFile() {
		try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
			String line = reader.readLine();

			while (!line.equals("")) {
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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static HashMap<Integer, Integer> convertToMap(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		return map;
	}

	public static boolean checkRule(ArrayList<int[]> rules, int[] pageNumbers) {
		HashMap<Integer, Integer> map = convertToMap(pageNumbers);
		for (int i = 0; i < rules.size(); i++) {
			int[] rule = rules.get(i);
			int first = rule[0];
			int second = rule[1];
			if (map.containsKey(first) && map.containsKey(second)) {
				if (map.get(first) > map.get(second)) {
					return false;
				}
			}
		}
		return true;
	}

	public static int getValidPages() {
		int count = 0;
		for (int i = 0; i < pageNumbers.size(); i++) {
			if (checkRule(rules, pageNumbers.get(i))) {
				int middleIndex = Math.floorDiv(pageNumbers.get(i).length, 2);
				count += pageNumbers.get(i)[middleIndex];
			}
		}
		return count;
	}
}
