import java.util.*;
import java.io.*;

public class Main {

	static int[][] arr;
	static int[] dix = { 1, -1, 0, 0 };
	static int[] diy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());
		arr = new int[size][size];
		for (int i = 0; i < size; i++) {
			String str = br.readLine();
			for (int j = 0; j < size; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[i][j] == 1)
					list.add(dfs(i, j));
			}
		}

		Collections.sort(list);

		for (int ele : list)
			sb.append(ele).append("\n");
		
		System.out.println(list.size());
		System.out.println(sb);
	}

	public static int dfs(int x, int y) {
		arr[x][y] = 0;
		int sum = 0;

		for (int i = 0; i < 4; i++) {
			int dx = x + dix[i];
			int dy = y + diy[i];

			if (dx >= 0 && dy >= 0 && dx < arr.length && dy < arr[0].length) {
				if (arr[dx][dy] == 1)
					sum += dfs(dx, dy);
			}
		}
		return sum + 1;
	}

}
