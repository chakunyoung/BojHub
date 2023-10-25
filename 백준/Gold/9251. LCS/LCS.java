import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str1 = br.readLine();
		String str2 = br.readLine();

		if (str1.length() > str2.length()) {
			String temp = str1;
			str1 = str2;
			str2 = temp;
		}

		int[][] dp = new int[str2.length() + 1][str1.length() + 1];

//		for(int i = 1; i<dp.length; i++) {
//		
//			char c1 = str2.charAt(i-1);
//			for(int j = 1; j<dp[0].length; j++) {
//				char c2 = str1.charAt(j-1);
//				dp[i][j] = dp[i-1][j];
//				
//				if(c1 == c2) {
//					for(int k = j-1; k>=0; k--) 
//						dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + 1); 
//				}
//			}
//		}

		for (int i = 1; i < dp.length; i++) {
			char c1 = str2.charAt(i - 1);
			for (int j = 1; j < dp[0].length; j++) {
				char c2 = str1.charAt(j - 1);

				if (c1 == c2)
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}

		int max = 0;
		for (int i = 0; i < dp[0].length; i++) {
			max = Math.max(max, dp[dp.length - 1][i]);
		}

		System.out.println(max);

	}
}