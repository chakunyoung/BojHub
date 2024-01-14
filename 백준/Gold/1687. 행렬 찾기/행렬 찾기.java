import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		int[][] arr = new int[row + 1][col];

		for (int i = 0; i < row; i++) {
			String s = br.readLine();
			for (int j = 0; j < col; j++) {
				int n = s.charAt(j) - '0';
				if (n == 0)
					arr[i][j] = 1;
				else
					arr[i][j] = 0;
			}
		}
		// 0의 개수를 쌓아서..
		for (int j = 0; j < col; j++) {
			for (int i = row - 1; i >= 0; i--) {
				if (arr[i][j] == 0)
					continue;
				else
					arr[i][j] = arr[i + 1][j] + 1;
			}
		}
		int max = 0;

		//for (int i = 0; i < row; i++)
		//	System.out.println(Arrays.toString(arr[i]));

		for (int i = 0; i < row - 1; i++) {
			for (int s = 0; s < col; s++) {
				int min = arr[i][s];
				int count = 1;
				
				for (int l = s - 1; l >= 0; l--) {
					if(arr[i][l] >= min)
						count++;
					else
						break;
				}

				for (int r = s + 1; r < col; r++) {
					if(arr[i][r] >= min)
						count++;
					else
						break;
				}
				max = Math.max(max, count * min);
			}
		}
		System.out.println(max);
	}
}
