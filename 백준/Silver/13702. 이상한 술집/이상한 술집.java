import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(bs(arr, k));

	}

	public static int bs(int[] arr, int k) {
		int s = 0;
		int e = Integer.MAX_VALUE;
		int ans = 0;

		while (s <= e) {
			long mid = ((long) s + e) / 2;

			int count = 0;
			for (int ele : arr) {
				count += ele / mid;
			}

			if (count >= k) {
				s = (int) mid + 1;
				ans = (int) mid;
			} else {
				e = (int) mid - 1;
			}

		}
		return ans;
	}
}