public class PathSum {
	
	public static void main(String args[]) {
		String[] input = {"131 673 234 103 18",
				  "201 96  342 965 150",
				  "630 803 746 422 111",
				  "537 699 497 121 956",
				  "805 732 524 37  331"
				};

		int[][] matrix = new int[input.length][input.length];
		for(int i = 0 ; i < input.length; i++) {
			String[] str = input[i].split("\\s+");
			for(int j = 0; j < str.length; j++) {
				matrix[i][j] = Integer.parseInt(str[j]);
			}
		}

		PathSum ps = new PathSum();
		System.out.println("Minimum path sum in two way is " + ps.minPathTwoWay(matrix));

	}

	int minPathTwoWay(int[][] matrix) {
		int n = matrix.length;
		int[][] dp = new int[n][n];
		int k = 0;
		for(int i = n - 1; i >= 0; i--) {
			dp[i][n - 1] = matrix[i][n - 1] + k;
			k = dp[i][n - 1];
			for(int j = n - 2; j >= 0; j--) {
				int tmp = (i < n - 1) ? dp[i + 1][j] : Integer.MAX_VALUE;
				dp[i][j] = matrix[i][j] + Math.min(tmp, dp[i][j + 1]);	
			}
		}
		return dp[0][0];
	}
}
