import java.util.*;
import java.io.*;

public class Main {

	static boolean v[];
	static int loopCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			st = new StringTokenizer(s, " ");

			int[] arr = new int[st.countTokens()];
			v = new boolean[st.countTokens()];
			loopCount = 0;

			int idx = 0;
			while (st.hasMoreTokens()) {
				arr[idx] = Integer.parseInt(st.nextToken()) - 1;
				idx++;
			}

			for (int j = 0; j < arr.length; j++) {
				if (!v[j]) {
					loopCount++;
					dfs(j, arr);
				}
			}
			sb.append(loopCount).append("\n");
		}
		System.out.println(sb.toString());

	}

	public static void dfs(int n, int[] arr) {
		if (v[n]) {
			return;
		}

		v[n] = true;
		dfs(arr[n], arr);
	}
}