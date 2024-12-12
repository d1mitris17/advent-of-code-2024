import java.util.ArrayList;

class part1 {

	public static int getSafeLevels(ArrayList<Integer[]> data) {
		int safe_levels = 0;
		for (Integer[] row : data) {
			// when first 2 non-equal elements are found, break loop && set increasing to
			// true or false
			int pattern = row[1] - row[0];
			// if the pattern is 0, then all numebrs are the same so skip
			if (pattern == 0) {
				continue;
			}
			boolean increasing = pattern > 0;
			safe_levels += checkLevel(row, increasing);

		}

		return safe_levels;
	}

	public static int checkLevel(Integer[] row, boolean increas) {
		for (int i = 1; i < row.length; i++) {
			int pattern = row[i] - row[i - 1];
			if (pattern == 0) {
				return 0;
			} else if (!increas && (pattern > 0 || pattern < -3)) {
				return 0;
			} else if (increas && (pattern < 0 || pattern > 3)) {
				return 0;

			}
		}
		return 1;
	}
}
