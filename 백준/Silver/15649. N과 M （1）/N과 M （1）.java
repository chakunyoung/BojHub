import java.util.*;
import java.io.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int n;
	static int m;
	static boolean[] v;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		v = new boolean[n + 1];

		recur(0, 1);
		System.out.println(sb.toString());

	}

	static void recur(int a, int b) {
		if (a == m) {
			for (int ele : arr)
				sb.append(ele).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!v[i]) {
				v[i] = true;
				arr[a] = i;
				recur(a + 1, i + 1);
				v[i] = false;
			}
		}

	}
}