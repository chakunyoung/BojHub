import java.io.*;
import java.util.*;

public class Main {

	static int[][] memo;
	static List<Integer> g = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		g = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens())
			g.add(Integer.parseInt(st.nextToken()));

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[2];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			list.add(arr);
		}

		for (int i = 0; i < list.size(); i++) {
			int[] arr = list.get(i);

			memo = new int[arr[0] + 1][arr[1] + 1];
			for (int j = 0; j < memo.length; j++)
				Arrays.fill(memo[j], -1);

			if (recur(arr[0], arr[1]) == 1) {
				sb.append("A").append("\n");
			} else
				sb.append("B").append("\n");
		}
		System.out.println(sb);
	}

	static int recur(int a, int b) {
		if (memo[a][b] != -1)
			return memo[a][b];

		int count = 0;
		for (int i = 0; i < 3; i++) {
			if (a >= g.get(i) && recur(a - g.get(i), b) == 0)
				++count;
			if (b >= g.get(i) && recur(a, b - g.get(i)) == 0)
				++count;
		}

		if (count > 0) {
			return memo[a][b] = 1;
		} else
			return memo[a][b] = 0;
	}
}