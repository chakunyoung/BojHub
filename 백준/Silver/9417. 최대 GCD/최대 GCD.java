import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<>();

			while (st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int max = 0;
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					max = Math.max(max, gcd(list.get(i), list.get(j)));
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}

	static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}