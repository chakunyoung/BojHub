import java.util.*;
import java.io.*;

class Main {

	static Node[] arr;
	static int[] memo;
	static int day;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		day = Integer.parseInt(br.readLine());
		arr = new Node[day + 1];
		memo = new int[day + 1];
		Arrays.fill(memo, -1);

		arr[day] = new Node(0, 0);
		for (int i = 0; i < day; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			arr[i] = new Node(t, p);
		}
		int ans = recur(0);
		System.out.println(ans);
	}

	public static int recur(int now) {
		// 날짜를 넘어가면 못쓰게 하려고
		if(now > day)
			return -Integer.MAX_VALUE >> 1;
			
		if(now == day)
			return 0;
			
		if(memo[now] != -1)
			return memo[now];
		
		int max = 0;
		max = Math.max(recur(now + 1), recur(now + arr[now].t) + arr[now].p);
		return memo[now] = max;
	}

	static class Node {
		int t, p;

		public Node(int t, int p) {
			this.t = t;
			this.p = p;
		}
	}
}