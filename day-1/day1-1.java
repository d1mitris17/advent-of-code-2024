import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

public class day1 {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> all = getFromFile("day1.txt");
		ArrayList<Integer> l1 = quickSort(all.get(0));
		ArrayList<Integer> l2 = quickSort(all.get(1));
		System.out.println(findDistance(l1, l2));
	}

	public static int findDistance(ArrayList<Integer> l1, ArrayList<Integer> l2) {
		int total = 0;
		int minSize = Math.min(l1.size(), l2.size());
		for (int i = 0; i < minSize; i++) {
			total += Math.abs(l1.get(i) - l2.get(i));
		}
		return total;
	}

	public static ArrayList<Integer> quickSort(ArrayList<Integer> list) {
		if (list.size() <= 1) {
			return list;
		}
		Random random = new Random();
		int pivot = list.get(random.nextInt(list.size()));
		ArrayList<Integer> less = new ArrayList<>();
		ArrayList<Integer> equal = new ArrayList<>();
		ArrayList<Integer> greater = new ArrayList<>();
		for (int i : list) {
			if (i < pivot) {
				less.add(i);
			} else if (i == pivot) {
				equal.add(i);
			} else {
				greater.add(i);
			}
		}
		ArrayList<Integer> sorted = new ArrayList<>();
		sorted.addAll(quickSort(less));
		sorted.addAll(equal);
		sorted.addAll(quickSort(greater));
		return sorted;
	}

	public static ArrayList<ArrayList<Integer>> getFromFile(String filename) {
		ArrayList<Integer> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.trim().split("\\s+");
				if (parts.length >= 2) {
					l1.add(Integer.parseInt(parts[0]));
					l2.add(Integer.parseInt(parts[1]));
				} else {
					System.out.println("Skipping invalid line: " + line);
				}
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("An error occurred while reading the file.");
			e.printStackTrace();
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(l1);
		result.add(l2);
		return result;
	}
}
