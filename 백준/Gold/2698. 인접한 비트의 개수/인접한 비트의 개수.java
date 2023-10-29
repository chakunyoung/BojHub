import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int[][][] dp = new int[101][2][101];

		dp[1][0][0] = 1;
		dp[1][1][0] = 1;

		for (int i = 2; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				dp[i][0][j] = dp[i - 1][0][j] + dp[i - 1][1][j];
				dp[i][1][j] = dp[i - 1][0][j];
				if (j > 0) {
					dp[i][1][j] += dp[i - 1][1][j - 1];
				}
			}
		}

		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			// 답 계산
			int answer = dp[n][0][k] + dp[n][1][k];
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}