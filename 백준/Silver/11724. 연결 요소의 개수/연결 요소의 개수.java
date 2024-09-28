import java.util.*;
import java.io.*;

public class Main {

	static int[] path;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int point = Integer.parseInt(st.nextToken());
		int line = Integer.parseInt(st.nextToken());

		Set<Integer> s = new HashSet<>();
		path = new int[point + 1];

		for (int i = 0; i < path.length; i++)
			path[i] = i;

		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// root 찾기
			int root1 = find(a);
			int root2 = find(b);

			// root 들 경합
			if (root1 != root2) {
				union(root1, root2);
			}

		}

		// 분리된 요소 count
		int count = 0;
		for (int i = 1; i < path.length; i++) {
			if (!s.contains(find(path[i]))) {
				count++;
				s.add(find(path[i]));
			}
		}

		System.out.println(count);
	}

	static int find(int n) {
		if (path[n] == n) {
			return n;
		}
		return path[n] = find(path[n]);
	}

	static void union(int a, int b) {
		if (a < b) {
			path[b] = a;
		} else {
			path[a] = b;
		}
	}
}
