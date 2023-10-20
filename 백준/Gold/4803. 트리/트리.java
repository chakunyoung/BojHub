import java.util.*;
import java.io.*;

public class Main {
	static int[] parent;
	static boolean[] isCycle;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int caseNumber = 1;

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if (n == 0 && m == 0)
				break;

			parent = new int[n + 1];
			isCycle = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a, b);
			}

			int treeCount = 0;
			for (int i = 1; i <= n; i++) {
				if (parent[i] == i && !isCycle[i]) {
					treeCount++;
				}
			}

			System.out.println("Case " + caseNumber + ": " + (treeCount == 0 ? "No trees."
					: (treeCount == 1 ? "There is one tree." : "A forest of " + treeCount + " trees.")));
			caseNumber++;
		}
	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			isCycle[a] = true;
			return;
		}
		parent[b] = a;
		if (isCycle[b]) {
			isCycle[a] = true;
		}
	}
}
