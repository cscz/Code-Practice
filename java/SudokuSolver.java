public class SudokuSolver {
    public static void main(String args[]) {
        char[][] board = new char[][] {
		{'5','3','.','.','7','.','.','.','.'},
		{'6','.','.','1','9','5','.','.','.'},
		{'.','9','8','.','.','.','.','6','.'},
		{'8','.','.','.','6','.','.','.','3'},
		{'4','.','.','8','.','3','.','.','1'},
		{'7','.','.','.','2','.','.','.','6'},
		{'.','6','.','.','.','.','2','8','.'},
		{'.','.','.','4','1','9','.','.','5'},
		{'.','.','.','.','8','.','.','7','9'}
	};
	for(char[] arr : board) {
            for(char c : arr) {
                System.out.print(c + " ");
            }
	    System.out.println();
	}
	System.out.println();

        solver(0, 0, board);

	for(char[] arr : board) {
            for(char c : arr) {
                System.out.print(c + " ");
            }
	    System.out.println();
	}
    }

    private static boolean solver(int row, int col, char[][] board) {
        //System.out.println("row = " + row + " , col = " + col);
        if(row == -1) {
            return true;
        }
        int x = -1;
        int y = -1;
        int j = col + 1;
        outerloop:
        for(int i = row; i < board.length; i++) {
            for(; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    x = i;
                    y = j;
                    break outerloop;
                }
            }
            j = 0;
        }
        
        if(board[row][col] == '.' ) {
            for(int i = 1; i <= 9; i++) {
                char cur = (char)(i + '0');
                if(isValid(row, col, board, cur)) {
                    board[row][col] = cur;
                    if(solver(x, y, board)) {
                        return true;
                    } else {
                        board[row][col] = '.';
                    }
                }
            }
        } else {
            solver(x, y, board);
        }
        return false;
    }
    
    private static boolean isValid(int row, int col, char[][] board, char c) {
        for(int i = 0; i < board.length; i++) {
            if(row != i && board[i][col] == c) {
                return false;
            }
            if(col != i && board[row][i] == c) {
                return false;
            }
            int x = row/3*3 + i/3;
            int y = col/3*3 + i%3;
            if((col != y || row != x) && board[x][y] == c) {
                return false;
            }
        }
        return true;
    }
}
