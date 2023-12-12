import java.io.*;
import java.util.*;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine().strip());
		int[] xs = new int[size];
		int[] ys = new int[size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			xs[i] = Integer.parseInt(st.nextToken());
			ys[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(xs);
		Arrays.sort(ys);

		int mx = xs[size / 2];
		int my = ys[size / 2];

		long ans = 0;
		for (int i = 0; i < size; i++) {
			ans += Math.abs((long)xs[i] - mx) + Math.abs((long)ys[i] - my);
		}

		System.out.println(ans);
	}
}