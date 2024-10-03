import java.io.*;
import java.util.*;

public class Main {
	static int a, b, c;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new int[a][b];
		v = new boolean[a][b];

		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1;
		}

		int max = 0;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				if (map[i][j] == 1 && !v[i][j]) {
					max = Math.max(max, bfs(i, j));
				}
			}
		}

		System.out.println(max);
	}

	static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		v[x][y] = true;
		int size = 1;

		while (!queue.isEmpty()) {
			int[] c = queue.poll();
			int cx = c[0];
			int cy = c[1];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx >= 0 && ny >= 0 && nx < a && ny < b && !v[nx][ny] && map[nx][ny] == 1) {
					queue.add(new int[] { nx, ny });
					v[nx][ny] = true;
					size++;
				}
			}
		}

		return size;
	}
}
