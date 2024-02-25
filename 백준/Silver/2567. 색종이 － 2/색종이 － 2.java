import java.util.*;
import java.io.*;

public class Main {

	static int[][] arr;
	static int[] xdir = { 1, -1, 0, 0 };
	static int[] ydir = { 0, 0, 1, -1 };
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[100][100];
		int testCase = Integer.parseInt(br.readLine());

		for (int i = 1; i <= testCase; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					arr[j][k] = 1;
				}
			}
		}

		// debug
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		find();

		System.out.println(count);

	}

	public static void find() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {

				if (arr[i][j] != 1)
					continue;

				// 벽은 0으로 취급한다.
				int countZero = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + xdir[k];
					int ny = j + ydir[k];

					if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[i].length) {
						if (arr[nx][ny] == 0) {
							countZero++;
						}

					} else {
						countZero++;
					}
				}

				if (countZero == 2)
					count += 2;
				else if (countZero == 1)
					count++;
			}
		}
	}
}
