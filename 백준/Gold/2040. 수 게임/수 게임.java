import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static int[] arr;
	static int[] prefix;
	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		size = Integer.parseInt(br.readLine());
		for (int i = 0; i < 3; i++) {
			arr = new int[size + 1];
			prefix = new int[size + 1];
			memo = new int[size + 1];

			Arrays.fill(memo, Integer.MIN_VALUE);

			st = new StringTokenizer(br.readLine());
			for (int j = size; j >= 1; j--) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			prefix[size] = arr[size];
			for (int j = 1; j <= size; j++) {
				prefix[j] = prefix[j - 1] + arr[j];
			}

			int res = recur(1);
			// System.out.println(res);
			if (res < 0)
				System.out.println("A");
			else if (res > 0)
				System.out.println("B");
			else
				System.out.println("D");
		}
	}

	static int recur(int s) {
		if (s > size)
			return 0;

		if (memo[s] != Integer.MIN_VALUE)
			return memo[s];

		int min = Integer.MAX_VALUE;
		for (int i = s; i <= size; i++) {
			min = Math.min(min, prefix[i] - prefix[s - 1] - recur(i + 1));
		}

		return memo[s] = min;
	}
}
