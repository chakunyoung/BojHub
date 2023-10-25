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

		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		memo = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = -1;
			}
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (memo[i][j] == -1)
					max = Math.max(recur(i, j), max);
			}
		}

		// for(int i =0; i<n; i++)
		// 	System.out.println(Arrays.toString(memo[i]));

		System.out.println(max + 1);
	}

	static int recur(int x, int y) {
		if (memo[x][y] != -1)
			return memo[x][y];

		int tempMax = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
				if (arr[nx][ny] > arr[x][y]) {
					tempMax = Math.max(recur(nx, ny) + 1, tempMax);
				}
			}
		}
		return memo[x][y] = tempMax;
	}
}
