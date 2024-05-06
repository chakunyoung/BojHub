import java.io.*;
import java.util.*;

public class Main {

	static boolean[] v;
	static int count = 0;
	static int n = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[n + 1];
		v = new boolean[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int s = Integer.parseInt(br.readLine());

		dfs(s);
		System.out.println(count);
	}

	static void dfs(int s) {
		if (s < 1 || s > n || v[s])
			return;

		v[s] = true;
		count++;
		dfs(s + arr[s]);
		dfs(s - arr[s]);
	}
}