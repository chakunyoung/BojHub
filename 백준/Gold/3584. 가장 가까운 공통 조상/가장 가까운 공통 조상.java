import java.util.*;
import java.io.*;

public class Main {

	static int[] arr;
	static List[] arrChild;
	static int root;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			int nodeCount = Integer.parseInt(br.readLine());

			arr = new int[nodeCount + 1];
			arrChild = new List[nodeCount + 1];

			for (int j = 0; j < nodeCount + 1; j++) {
				arrChild[j] = new ArrayList<Integer>();
			}

			for (int j = 0; j < nodeCount - 1; j++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				arr[s] = p;
				arrChild[p].add(s);
			}

			if (arr[1] != 0)
				root = rootNode(arr[1]);
			else
				root = rootNode(arr[2]);

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// depth
			int aDepth = depthCount(1, root, a);
			int bDepth = depthCount(1, root, b);

			while (a != b) {
				if (aDepth > bDepth) {
					a = arr[a];
					aDepth--;
				} else {
					b = arr[b];
					bDepth--;
				}
			}
			sb.append(a).append("\n");
		}
		System.out.println(sb);
	}

	static int rootNode(int n) {
		if (arr[n] == 0)
			return n;
		return rootNode(arr[n]);
	}

	static int depthCount(int depth, int p, int find) {
		if (p == find)
			return depth;

		for (int i = 0; i < arrChild[p].size(); i++) {
			int child = (int)arrChild[p].get(i);
			int result = depthCount(depth + 1, child, find);
			if (result != 0)
				return result;
		}
		return 0;
	}
}
