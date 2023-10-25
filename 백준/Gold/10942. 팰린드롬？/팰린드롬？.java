import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n + 1];
		int[][] arr = new int[n + 1][n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++)
			list[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= n; i++)
			arr[i][i] = 1;

		for (int i = 1; i <= n - 1; i++)
			if (list[i] == list[i + 1])
				arr[i][i + 1] = 1;

		for (int i = 2; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				if (list[j] == list[j + i] && arr[j + 1][j + i - 1] == 1)
					arr[j][j + i] = 1;
			}
		}

		int que = Integer.parseInt(br.readLine());
		for (int i = 0; i < que; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(arr[s][e]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
