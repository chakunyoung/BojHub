import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static int[] temp;
	static int[] ans;
	static int N;

	static String numbers;
	static StringBuilder innerSB = new StringBuilder();
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		numbers = br.readLine();

		N = numbers.length();
		if (numbers.length() > 9)
			N = (numbers.length() - 9) / 2 + 9;

		arr = new int[N];
		temp = new int[N];
		ans = new int[N];
		v = new boolean[N + 1];

		bt(0, N);

		for (int ele : ans) {
			sb.append(ele).append(" ");
		}
		System.out.println(sb);
	}

	public static void bt(int n, int limit) {
		innerSB.setLength(0);

		for (int i = 0; i < n; i++)
			innerSB.append(temp[i]);

		if (!(innerSB.toString().equals(numbers.substring(0, innerSB.length())))) {
			return;
		}

		if (n == limit) {
			if (innerSB.toString().equals(numbers))
				System.arraycopy(temp, 0, ans, 0, N);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!v[i]) {
				temp[n] = i;
				v[i] = true;
				bt(n + 1, limit);
				v[i] = false;
			}
		}
	}
}