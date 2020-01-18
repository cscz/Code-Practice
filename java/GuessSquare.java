public class GuessSquare {
	public static void main(String args[]) {
		int[] p1 = new int[]{1,7};
		int[] p2 = new int[]{8,3};
		System.out.println("p1 is " + p1[0] + " " + p1[1]);
		System.out.println("p2 is " + p2[0] + " " + p2[1]);
		int[][] res = Guess(p1, p2);
		System.out.println("Pair1 is: ");
		System.out.println(res[0][0] + " " + res[0][1]);
		System.out.println(res[0][2] + " " + res[0][3]);

		System.out.println("Pair2 is: ");
		System.out.println(res[1][0] + " " + res[1][1]);
		System.out.println(res[1][2] + " " + res[1][3]);
	}

	public static int[][] Guess(int[] p1, int[] p2) {
		int x_offset = p1[0] - p2[0];
		int y_offset = p1[1] - p2[1];
		
		int[] pair1 = new int[4];
		int[] pair2 = new int[4];
		
		pair1[0] = p1[0] + y_offset;
		pair1[1] = p1[1] - x_offset;

		pair1[2] = p2[0] + y_offset;
		pair1[3] = p2[1] - x_offset;

		pair2[0] = p1[0] - y_offset;
		pair2[1] = p1[1] + x_offset;

		pair2[2] = p2[0] - y_offset;
		pair2[3] = p2[1] + x_offset;
		
		return new int[][] {pair1, pair2};

	}
}
