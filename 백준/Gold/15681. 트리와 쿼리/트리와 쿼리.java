import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	;
	static Map<Integer, Integer> map = new HashMap<>();
	static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int root = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= size; i++)
			list.add(new ArrayList<>());

		for (int i = 0; i < size - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		recur(root, -1);

		for (int i = 0; i < q; i++) {
			sb.append(map.get(Integer.parseInt(br.readLine())) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int recur(int p, int prev) {
		int count = 1;

		for (int ele : list.get(p)) {
			if(ele == prev)
				continue;

			count += recur(ele, p);
		}
		map.put(p, count);
		return count;
	}
}
