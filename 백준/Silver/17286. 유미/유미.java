import java.util.*;
import java.io.*;

public class Main {

	static int minDis = Integer.MAX_VALUE;
	static Node[] temp = new Node[4];
	static boolean[] v = new boolean[4];
	static Node umi;
	static List<Node> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int ux = Integer.parseInt(st.nextToken());
		int uy = Integer.parseInt(st.nextToken());
		umi = new Node(ux, uy);
		temp[0] = umi;
		list = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		recur(0, 3);
		System.out.println(minDis);
	}

	public static void recur(int n, int limit) {
		if (n == limit) {
			double tempDis = 0; 
			for (int i = 0; i < 3; i++) {
				double dx = temp[i].x - temp[i+1].x;
				double dy = temp[i].y - temp[i+1].y;
				tempDis += Math.sqrt(dx * dx + dy * dy); 
			}
			minDis = Math.min((int)tempDis, minDis);
			return;
		}

		for (int i = 1; i < 4; i++) {
			if (!v[i]) {
				v[i] = true;
				temp[n+1] = list.get(i-1);
				recur(n + 1, limit);
				v[i] = false;
			}
		}
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return x + " " + y;
		}
	}

}