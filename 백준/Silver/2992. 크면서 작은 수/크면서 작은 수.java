import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int min = Integer.MAX_VALUE;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		n = Integer.parseInt(input);

		char[] arr = input.toCharArray();
		v = new boolean[arr.length];
		recur(arr, "");

		if (min == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(min);
		}
	}

	static void recur(char[] arr, String s) {
		if (s.length() == arr.length) {
			int num = Integer.parseInt(s);
			if (num > n)
				min = Math.min(min, num);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				recur(arr, s + arr[i]);
				v[i] = false;
			}
		}
	}
}
