import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

	private int[][] grid;

	public Board() {
		grid = new int[9][9];
	}

	public Board(int[][] grid) {
		if (grid.length != 9 || grid[0].length != 9) {
			throw new IllegalArgumentException("Grid must be 9 by 9");
		}
		this.grid = grid;
	}

	public void set(int row, int col, int val) {
		grid[row][col] = val;
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	public boolean isComplete() {

		// Check that board is completely filled
		for (int i = 0; i < 9; i++) {
			int[] row = grid[i];
			if (Arrays.binarySearch(row, 0) >= 0)
				return false;
		}

		// Check that board is valid
		return this.isValid();
	}

	public boolean isValid() {
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			numbers.clear();
			// Rows
			for (int j = 0; j < 9; j++) {
				int num = grid[i][j];
				if (num == 0)
					continue;
				if (numbers.contains(num)) {
					return false;
				}
				numbers.add(num);
			}
			numbers.clear();
			// Columns
			for (int j = 0; j < 9; j++) {
				int num = grid[j][i];
				if (num == 0)
					continue;

				if (numbers.contains(num)) {
					return false;
				}
				numbers.add(num);
			}
		}

		// Regions
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				numbers.clear();
				int rowOffset = i * 3;
				int colOffset = j * 3;
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						int num = grid[rowOffset + r][colOffset + c];
						if (num == 0)
							continue;
						if (numbers.contains(num)) {
							return false;
						}
						numbers.add(num);
					}
				}
			}
		}

		return true;
	}

	public Board clone() {
		int[][] newGrid = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				newGrid[i][j] = grid[i][j];
			}
		}

		return new Board(newGrid);
	}

	public String toString(){
		String str = "";
		for (int i = 0; i < 9; i++) {
			str += Arrays.toString(grid[i]).replace("[","").replaceAll("]", "").replaceAll(", ", " ");
			str += "\n";
		}
		return str;
	}
}
