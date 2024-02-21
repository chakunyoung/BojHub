import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/text"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int houseCount = Integer.parseInt(br.readLine());

		int[][] arr = new int[houseCount][3];
		int[][] dp = new int[houseCount][3];

		int ridx = 0;
		while (houseCount-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cidx = 0;
			while (st.hasMoreTokens())
				arr[ridx][cidx++] = Integer.parseInt(st.nextToken());
			ridx++;
		}

		int min = Integer.MAX_VALUE >> 1;
		
		for(int i = 0; i<3; i++) {
			Arrays.fill(dp[0], Integer.MAX_VALUE >> 1);
			
			dp[0][i] = arr[0][i];
			
			for(int j = 1; j<dp.length; j++) {
				dp[j][0] = Math.min(dp[j - 1][1], dp[j-1][2]) + arr[j][0];
				dp[j][1] = Math.min(dp[j - 1][0], dp[j-1][2]) + arr[j][1];
				dp[j][2] = Math.min(dp[j - 1][0], dp[j-1][1]) + arr[j][2];
			}
			
			for(int j = 0; j<3; j++) {
				if(i == j) continue;
				min = Math.min(dp[dp.length - 1][j], min);
			}
		}
		System.out.println(min);
	}
}
