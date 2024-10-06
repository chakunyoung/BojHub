import java.io.*;
import java.util.*;

public class Main {

	static int count;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		arr = new int[10];
		int idx = 0;
		while (st.hasMoreTokens())
			arr[idx++] = Integer.parseInt(st.nextToken());

		recur(0, 0, 0, 0);

		System.out.println(count);
	}

	static void recur(int n, int a, int b, int sum) {
		if (n == 10) {
			if (sum >= 5)
				count++;
			return;
		}

		for (int i = 1; i <= 5; i++) {
			if (a == b && b == i)
				continue;

			if (arr[n] == i)
				recur(n + 1, b, i, sum + 1);
			else
				recur(n + 1, b, i, sum);
		}
	}
}
