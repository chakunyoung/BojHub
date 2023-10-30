import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int i = 1; i <= testCase; i++) {
			int col = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[2][col];

			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < col; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[2][col];

			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			if(col == 1) {
				sb.append(Math.max(dp[0][col - 1], dp[1][col - 1])).append("\n");
				continue;
			}
			
			
			dp[0][1] = arr[0][1] + arr[1][0]; // 위쪽
			dp[1][1] = arr[0][0] + arr[1][1];

			for (int j = 2; j < col; j++) {
				dp[0][j] = Math.max(dp[1][j - 2] + arr[0][j], dp[1][j - 1] + arr[0][j]);
				dp[1][j] = Math.max(dp[0][j - 2] + arr[1][j], dp[0][j - 1] + arr[1][j]);
			}
			
			//System.out.println(Arrays.deepToString(dp));
			
			sb.append(Math.max(dp[0][col - 1], dp[1][col - 1])).append("\n");
		}
		System.out.println(sb.toString());
	}
}
