
import java.util.*;
import java.io.*;
public class Main {
	static long max = 0;
	static int maxRoot = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int line = Integer.parseInt(br.readLine());
		List<List<Node>> list = new ArrayList<>();

		for (int i = 0; i <= line; i++)
			list.add(new ArrayList<>());

		for(int i = 0; i<line -1 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(s).add(new Node(e, w)); //
			list.get(e).add(new Node(s, w)); //
		}

		findLongestRoot(list, 1, 0, 0);
		max = 0;
		findLongestRoot(list, maxRoot, 0, 0);
		System.out.println(max);
	}

	public static void findLongestRoot(List<List<Node>> list, int root, long distSum, int prev) {
		for (Node n1 : list.get(root)) { //
			if (n1.number != prev) {
				findLongestRoot(list, n1.number, distSum + n1.dist, root);
			}
		}

		if (max < distSum) {
			max = distSum;
			maxRoot = root;
		}
	}

	static class Node {
		int number;
		int dist;

		public Node(int number, int dist) {
			this.number = number;
			this.dist = dist;
		}

		public String toString() {
			return number + " " + dist;
		}
	}
}
