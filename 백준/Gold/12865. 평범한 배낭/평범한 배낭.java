import java.util.*;
import java.io.*;

public class Main {

	static Item[] itemArr; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int items = Integer.parseInt(st.nextToken());
		int maxWeight = Integer.parseInt(st.nextToken());
		
		itemArr = new Item[items + 1];
		
		for(int i = 1; i<=items; i++) {
			st = new StringTokenizer(br.readLine());
			itemArr[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		} 
		
		int[][] dp = new int[items + 1][maxWeight + 1];
		
		for (int i = 1; i < dp.length; i++) { // item
			int w = itemArr[i].w;
			int v = itemArr[i].v;
			for (int j = 1; j < dp[0].length; j++) { // weight
				dp[i][j] = dp[i - 1][j];
				if (j - w >= 0) 
		            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v); // 현재 아이템의 무게를 뺀 idx 에서 가치를 더한다.
			}
		}
		
		//System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[items][maxWeight]);
	}

	static class Item {
		int w, v;

		public Item(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
}
