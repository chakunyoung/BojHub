import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());

		int[][] arr = new int[size][size];

		int row = arr.length / 2;
		int col = arr.length / 2;

		int count = 0;
		int dir = 0; // 상, 우, 하, 좌
		int limit = 1;
		int moveCount = 0;

		while (true) {
			arr[row][col] = ++count;

			if (dir == 0) {
				row--;
			} else if (dir == 1) {
				col++;
			} else if (dir == 2) {
				row++;
			} else
				col--;

			++moveCount;

			if (moveCount == limit) {
				moveCount = 0;
				dir = (dir + 1) % 4;
				if (dir % 2 == 0)
					limit++;
			}

			if (count == size * size) {
				break;
			}
		}
		int f = Integer.parseInt(br.readLine());
		int[] ans = new int[2];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				sb.append(arr[i][j]).append(" ");
				if (arr[i][j] == f) {
					ans[0] = i + 1;
					ans[1] = j + 1;
				}
			}
			if (i != arr.length - 1)
				sb.append("\n");
		}
		System.out.println(sb);
		System.out.println(ans[0] + " " + ans[1]);
	}
}
