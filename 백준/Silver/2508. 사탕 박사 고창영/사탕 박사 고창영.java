import java.util.*;
import java.io.*;

public class Main {

	static char[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr = new char[r][c];

			for (int j = 0; j < r; j++) {
				String col = br.readLine();
				for (int k = 0; k < col.length(); k++) {
					arr[j][k] = col.charAt(k);
				}
			}

			int count = 0;
			for (int j = 0; j < r; j++) {
				for (int k = 0; k < c; k++) {
					if (arr[j][k] == 'o') {
						if (check(j, k))
							++count;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	public static boolean check(int x, int y) {
		if (y - 1 >= 0 && arr[x][y - 1] == '>' && y + 1 < arr[0].length && arr[x][y + 1] == '<') {
			return true;
		} else if (x - 1 >= 0 && arr[x - 1][y] == 'v' && x + 1 < arr.length && arr[x + 1][y] == '^') {
			return true;
		}
		return false;
	}
}