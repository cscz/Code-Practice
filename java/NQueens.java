import java.util.*;

public class NQueens {

    static int count;
    static boolean output = true;
    public static void main(String[] args) {
	int n = 8;
	if(args.length != 0) {
            n = Integer.parseInt(args[0]);
	}
        int[] board = new int[n + 1];
	count = 0;
        solve(1, board);
	System.out.println("There are total " + count + " solutions for " + n + " Queens.");
    }
    
    private static void solve(int row, int[] board) {
        for(int i = 1; i < board.length; i++) {
            board[row] = i;
            if(isValid(row, board)) {
                if(row == board.length - 1) {
		    count++;
                    //Output 
		    if(output) {
		        for(int m = 1; m < board.length; m++) {
                            for(int n = 1; n < board.length; n++) {
                                if(n == board[m]) {
		            	    System.out.print("Q ");
		                } else {    
		            	    System.out.print(". ");
		                }
		            }
		            System.out.println();
		        }
	                System.out.println();
		    }
                } else {
                    solve(row + 1, board);
                }
            }
        }
        board[row] = 0;
    }
    
    private static boolean isValid(int row, int[] board) {
        for(int i = 1; i < board.length; i++) {
            if(i == row || board[i] == 0) {
                continue;
            }
            if(board[i] == board[row] || row + board[row] == i + board[i] || row - board[row] == i - board[i]) {
                return false;
            }
        }
        return true;
    }
}
