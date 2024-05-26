import java.io.*;
import java.util.*;

public class Main {

	public static int h, w;
	public static char[][] arr;
	public static boolean[][] v;
	public static int[][] dxy = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	public static int sheep = 0;
	public static int wolf = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int answerSheep = 0, answerWolf = 0;

		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		arr = new char[h][w];
		v = new boolean[h][w];

		for (int x = 0; x < h; x++)
			arr[x] = br.readLine().toCharArray();

		for (int x = 0; x < h; x++) {
			for (int y = 0; y < w; y++) {
				if (!v[x][y] && (arr[x][y] == 'o' || arr[x][y] == 'v')) {
					sheep = wolf = 0;
					dfs(x, y);
					if (sheep > wolf)
						answerSheep += sheep;
					else
						answerWolf += wolf;
				}
			}
		}

		sb.append(answerSheep).append(" ").append(answerWolf);
		System.out.println(sb);
	}

	public static void dfs(int x, int y) {
		v[x][y] = true;

		if (arr[x][y] == 'v')
			wolf++;
		if (arr[x][y] == 'o')
			sheep++;

		int nx, ny;

		for (int i = 0; i < 4; i++) {
			nx = x + dxy[i][0];
			ny = y + dxy[i][1];

			if (nx < 0 || ny < 0 || nx >= h || ny >= w || v[nx][ny] || arr[nx][ny] == '#')
				continue;

			v[nx][ny] = true;
			dfs(nx, ny);
		}
	}
}
