import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int sheep = Integer.parseInt(st.nextToken());
		int goat = Integer.parseInt(st.nextToken());
		int total = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int ansCount = 0;
		int[] ans = new int[2];

		for (int a = 1; a <= total - 1; a++) {
			int b = total - a;
			if ((a * sheep + b * goat) == w) {
				++ansCount;
				ans[0] = a;
				ans[1] = b;
			}
		}

		if (ansCount > 1 || ansCount == 0) {
			System.out.println("-1");
		} else {
			System.out.println(ans[0] + " " + ans[1]);
		}

	}
}
