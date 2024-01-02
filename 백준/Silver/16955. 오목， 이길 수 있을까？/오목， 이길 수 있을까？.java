import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[][] arr = new char[10][10];

		for (int i = 0; i < 10; i++) {
			String line = br.readLine();
			for (int j = 0; j < 10; j++) {
				arr[i][j] = line.charAt(j);
			}
		}

		boolean win = false;
		for (int i = 0; i < 10 && !win; i++) {
			for (int j = 0; j < 10 && !win; j++) {
				if (arr[i][j] == '.') {
					arr[i][j] = 'X';
					if (isWin(arr, i, j)) {
						win = true;
					}
					arr[i][j] = '.';
				}
			}
		}

		System.out.println(win ? "1" : "0");
	}

	private static boolean isWin(char[][] arr, int x, int y) {
		int[] dx = { 1, 0, 1, -1, 1, 1, 0, -1 };
		int[] dy = { 0, 1, 1, 1, -1, 0, -1, -1 };

		for (int i = 0; i < 8; i++) {
			for (int j = -4; j <= 0; j++) {
				int count = 0;
				int nx = x + j * dx[i];
				int ny = y + j * dy[i];

				if (nx < 0 || ny < 0 || nx >= 10 || ny >= 10)
					continue;

				boolean check = true;
				for (int k = 0; k < 5; k++) {
					int cx = nx + k * dx[i];
					int cy = ny + k * dy[i];
					if (cx < 0 || cy < 0 || cx >= 10 || cy >= 10 || arr[cx][cy] != 'X') {
						check = false;
						break;
					}
					count++;
				}

				if (check && count == 5)
					return true;
			}
		}

		return false;
	}

}