import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int cost = Integer.parseInt(st.nextToken());
		int citiesCount = Integer.parseInt(st.nextToken());

		City[] cities = new City[citiesCount + 1];

		for(int i = 1; i<=citiesCount; i++) {
			st = new StringTokenizer(br.readLine());
			cities[i] = new City(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int[][] dp = new int[citiesCount + 1][100_000 + 1];

		for (int i = 1; i < cities.length; i++) {
			int w = cities[i].w; // 홍보 비용
			int c = cities[i].c; // 고객 수

			for (int j = 1; j < dp[0].length; j++) { // 비용
				dp[i][j] = dp[i - 1][j];

				if (j - w >= 0) 
					dp[i][j] = Math.max(dp[i][j], dp[i][j - w] + c); // 계속 update
			}
		}
		
		// 최소비용 출력
		int answer = 0;
		for(int i = 0; i<dp[0].length; i++) {
			if(dp[citiesCount][i] >= cost) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

	static class City {
		int w, c;

		public City(int w, int c) {
			this.w = w;
			this.c = c;
		}
	}
}