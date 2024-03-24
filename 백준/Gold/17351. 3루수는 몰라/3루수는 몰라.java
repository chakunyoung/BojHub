import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr = new int[501][501];
	static int[][][][][] memo = new int[501][501][5][5][5];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= N; j++) {
				char input = line.charAt(j - 1);
				if (input == 'M')
					arr[i][j] = 0;
				else if (input == 'O')
					arr[i][j] = 1;
				else if (input == 'L')
					arr[i][j] = 2;
				else if (input == 'A')
					arr[i][j] = 3;
				else
					arr[i][j] = 4;
			}
		}

		for (int[][][][] row : memo) {
			for (int[][][] col : row) {
				for (int[][] prev3 : col) {
					for (int[] prev2 : prev3) {
						Arrays.fill(prev2, -1);
					}
				}
			}
		}

		System.out.println(recur(1, 1, 4, 4, 4));
	}

	static int recur(int r, int c, int prev3, int prev2, int prev1) {
		if (r < 1 || r > N || c < 1 || c > N)
			return 0;

		int temp = memo[r][c][prev3][prev2][prev1];
		if (temp != -1)
			return temp;

		temp = 0;

		int now = arr[r][c];
		if (prev3 == 0 && prev2 == 1 && prev1 == 2 && now == 3)
			++temp;

		temp += Math.max(recur(r, c + 1, prev2, prev1, now), recur(r + 1, c, prev2, prev1, now));
		return memo[r][c][prev3][prev2][prev1] = temp;
	}
}