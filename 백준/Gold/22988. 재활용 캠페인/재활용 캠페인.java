import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		long x = Long.parseLong(input[1]);

		String[] line = br.readLine().split(" ");
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(line[i]);
		}

		System.out.println(solve(n, x, arr));
	}

	private static int solve(int n, long x, long[] arr) {
		Arrays.sort(arr);

		int doubleCount = 0;
		int oneCount = 0;
		int s = 0;
		int e = n - 1;

		for (int i = e; i >= 0; i--) {
			if (arr[e] >= x) {
				e--;
				oneCount++;
			}
		}

		while (s < e) {
			if ((arr[s] + arr[e]) * 2 >= x) {
				doubleCount++;
				s++;
				e--;
			} else {
				s++;
			}
		}

		int left = (n - doubleCount * 2 - oneCount) / 3;
		return oneCount + doubleCount + left;
	}
}