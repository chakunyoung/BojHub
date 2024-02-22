import java.io.*;
import java.util.*;

public class Main {

	static long[][] memo = new long[31][31];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[][] map = new int[r][c];
		for (int i = 0; i < map.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		int max = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				for (int k = 0; k < Math.min(r, c); k++) {
					if (i + k < r && j + k < c) {
						int num = map[i][j];
						if (num == map[i + k][j] && num == map[i][j + k] && num == map[i + k][j + k]) {
							max = Math.max(max, (k + 1) * (k + 1));
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}