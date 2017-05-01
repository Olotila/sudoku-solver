public class BacktraceSolver implements Solver {

	@Override
	public void solve(Board board) {		
		board.setGrid(solveRecursive(board.clone()).getGrid());
	}

	private Board solveRecursive(Board board){
		
		//Find the position of the next empty space, left to right, top to bottom
		int row, col;
		row = col = -1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(board.getGrid()[i][j] == 0){
					row = i;
					col = j;
				}
			}
		}
		
		//If there are no empty spaces the board is full
		if(row == -1 || col == -1){
			return board.clone();
		}
		
		//Try each value from 1 to 9 in the current empty space
		for(int i = 1; i <= 9; i++){
			board.set(row, col, i);
			
			//If the board is still valid after setting the value, continue to recur
			if(board.isValid()){
				//Create a branch and store its terminating node
				Board board2 = solveRecursive(board.clone());
				//If the returned board on the branch is a valid result, a solution has been found
				if(board2.isComplete())return board2.clone();
			}else if(board.isComplete()){
				//We found a solution based on the set value, terminate the branch
				return board.clone();
			}
		}
		
		//If the board is not valid, return it to terminate the branch
		return board.clone();
	}
	
}