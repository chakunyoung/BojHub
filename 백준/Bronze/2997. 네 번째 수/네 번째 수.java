import java.io.*;
import java.util.*;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		List<Integer> list = new ArrayList<>();

		int min = 1000;
		int gap = 1000;
		while (st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());
			list.add(n);
			min = Math.min(min, n);
		}
		Collections.sort(list);
		for (int i = 0; i < 2; i++) {
			gap = Math.min(gap, list.get(i + 1) - list.get(i));
		}

		for (int i = 0; i < 3; i++) {
			if (!(list.get(i) == min)) {
				System.out.println(min);
				return;
			}
			min += gap;
		}
		System.out.println(min);

	}
}
