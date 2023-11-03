import java.util.*;
import java.io.*;

public class Main {

	static boolean[] v;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;
	static int sp;
	static int ep;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());
		v = new boolean[size + 1];
		arr = new int[size + 1][size + 1];
		st = new StringTokenizer(br.readLine());
		sp = Integer.parseInt(st.nextToken());
		ep = Integer.parseInt(st.nextToken());
		int line = Integer.parseInt(br.readLine());

		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		v [ sp] = true;
		depth(size, sp, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void depth(int size, int node, int depth) {
		if(node == ep) {
			min = Math.min(min, depth);
			return;
		}

		for (int i = 0; i < size + 1; i++) {
			if (arr[node][i] == 1 && !v[i]) {
				v[i] = true;
				depth(size, i, depth + 1);
				v[i] = false;
			}
		}
	}
}