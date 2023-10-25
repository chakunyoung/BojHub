import java.util.*;
import java.io.*;

public class Main {

	static int ans;
	static int[][] memo;
	static int[][] arr;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		arr = new int[row][col];
		memo = new int[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = -1;
			}
		}
		System.out.println(recur(0, 0));
		// for (int i = 0; i < row; i++)
		// 	System.out.println(Arrays.toString(memo[i]));
	}

	static int recur(int x, int y) {
		if (x == arr.length - 1 && y == arr[0].length - 1) {
			return 1;
		}

		if (memo[x][y] != -1)
			return memo[x][y];

		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
				if (arr[nx][ny] < arr[x][y]) {
					count += recur(nx, ny);
				}
			}
		}
		return memo[x][y] = count;
	}
}
