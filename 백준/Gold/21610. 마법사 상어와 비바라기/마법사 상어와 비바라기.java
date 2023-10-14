import java.util.*;
import java.io.*;

public class Main {
	static int size, moveCount;
	static int[][] arr, rain;
	static boolean[][] cloud;
	static int[][] dir = { { 0, 0 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 },
			{ 1, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		size = Integer.parseInt(st.nextToken());
		moveCount = Integer.parseInt(st.nextToken());

		arr = new int[size + 1][size + 1];
		for (int i = 1; i <= size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= size; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rain = new int[size + 1][size + 1];
		cloud = new boolean[size + 1][size + 1];
		cloud[size][1] = true;
		cloud[size][2] = true;
		cloud[size - 1][1] = true;
		cloud[size - 1][2] = true;

		for (int i = 0; i < moveCount; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			moveCloud(d, s);
			rain();
			reCloud();
		}

		int answer = 0;
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				answer += arr[i][j];
			}
		}

		System.out.println(answer);
	}

	public static void moveCloud(int d, int s) {
		boolean[][] newCloud = new boolean[size + 1][size + 1];
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (cloud[i][j]) {
					int nx = (i + s * dir[d][0]) % size;
					int ny = (j + s * dir[d][1]) % size;

					if (nx <= 0)
						nx += size;
					if (ny <= 0)
						ny += size;

					newCloud[nx][ny] = true;
					rain[nx][ny]++;
				}
			}
		}

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				cloud[i][j] = newCloud[i][j];
			}
		}
	}

	static void rain() {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (rain[i][j] > 0) {
					arr[i][j] += rain[i][j];
					rain[i][j] = 0;
				}
			}
		}

		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (cloud[i][j]) {
					int cnt = 0;
					for (int d = 2; d <= 8; d += 2) {
						int nx = i + dir[d][0];
						int ny = j + dir[d][1];
						if (nx >= 1 && nx <= size && ny >= 1 && ny <= size && arr[nx][ny] > 0) {
							cnt++;
						}
					}
					arr[i][j] += cnt;
				}
			}
		}
	}

	static void reCloud() {
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				if (arr[i][j] >= 2 && !cloud[i][j]) {
					cloud[i][j] = true;
					arr[i][j] -= 2;
				} else {
					cloud[i][j] = false;
				}
			}
		}
	}
}