import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;

class day4 {
	public static int row;
	public static int col;

	public static void main(String[] args) {
		HashMap<String, ArrayList<int[]>> letters = parseInput("input.txt");
		ArrayList<int[]> X = letters.get("X");
		ArrayList<int[]> M = letters.get("M");
		ArrayList<int[]> A = letters.get("A");
		ArrayList<int[]> S = letters.get("S");
		boolean[][] MBool = new boolean[row][col];
		boolean[][] ABool = new boolean[row][col];
		boolean[][] SBool = new boolean[row][col];
		for (int[] coord : M) {
			if (isValidCoordinate(coord[0], coord[1])) {
				MBool[coord[0]][coord[1]] = true;
			}
		}
		for (int[] coord : A) {
			if (isValidCoordinate(coord[0], coord[1])) {
				ABool[coord[0]][coord[1]] = true;
			}
		}
		for (int[] coord : S) {
			if (isValidCoordinate(coord[0], coord[1])) {
				SBool[coord[0]][coord[1]] = true;
			}
		}
		int totalXmas = getTotalXmas(X, MBool, ABool, SBool);
		System.out.println("Total Xmas: " + totalXmas);
	}

	private static boolean isValidCoordinate(int row, int col) {
		return row >= 0 && row < day4.row && col >= 0 && col < day4.col;
	}

	private static int getTotalXmas(ArrayList<int[]> X, boolean[][] MBool, boolean[][] ABool,
			boolean[][] SBool) {
		int total = 0;
		for (int[] coord : X) {
			int x = coord[0];
			int y = coord[1];
			// Check if xmas spelled in the same row
			if (y + 3 < col && MBool[x][y + 1] && ABool[x][y + 2] && SBool[x][y + 3]) {
				total++;
			}
			// Check if xmas spelled in the same column
			if (x + 3 < row && MBool[x + 1][y] && ABool[x + 2][y] && SBool[x + 3][y]) {
				total++;
			}
			// Check if xmas spelled in the same diagonal
			if (x + 3 < row && y + 3 < col && MBool[x + 1][y + 1] && ABool[x + 2][y + 2]
					&& SBool[x + 3][y + 3]) {
				total++;
			}
			// Check if xmas spelled in the reverse diagonal
			if (x + 3 < row && y - 3 >= 0 && MBool[x + 1][y - 1] && ABool[x + 2][y - 2]
					&& SBool[x + 3][y - 3]) {
				total++;
			}
			// Check if xmas spelled in the reverse row
			if (y - 3 >= 0 && MBool[x][y - 1] && ABool[x][y - 2] && SBool[x][y - 3]) {
				total++;
			}
			// Check if xmas spelled in the reverse column
			if (x - 3 >= 0 && MBool[x - 1][y] && ABool[x - 2][y] && SBool[x - 3][y]) {
				total++;
			}
			// Check if xmas spelled in the upward diagonal
			if (x - 3 >= 0 && y + 3 < col && MBool[x - 1][y + 1] && ABool[x - 2][y + 2]
					&& SBool[x - 3][y + 3]) {
				total++;
			}
			// Check if xmas spelled in the downward diagonal
			if (x - 3 >= 0 && y - 3 >= 0 && MBool[x - 1][y - 1] && ABool[x - 2][y - 2]
					&& SBool[x - 3][y - 3]) {
				total++;
			}
		}
		return total;
	}

	private static HashMap<String, ArrayList<int[]>> parseInput(String filename) {
		HashMap<String, ArrayList<int[]>> letters = new HashMap<>();
		letters.put("X", new ArrayList<>());
		letters.put("M", new ArrayList<>());
		letters.put("A", new ArrayList<>());
		letters.put("S", new ArrayList<>());
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			row = 0;
			while (line != null) {
				col = line.length();
				for (int i = 0; i < line.length(); i++) {
					int[] rowCol = { row, i };
					String letter = Character.toString(line.charAt(i));
					if ("XMAS.".contains(letter)) {
						letters.get(letter).add(rowCol);
					}
				}
				row++;
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Error reading file: " + e);
		}
		return letters;
	}

}
