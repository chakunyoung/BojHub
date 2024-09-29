import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		int idx = 0;
		while (st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int f = Integer.parseInt(st.nextToken());
			sb.append(bs(f, arr)).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int bs(int target, int[] arr) {
		int s = 0;
		int e = arr.length - 1;
		int t = arr.length;

		while (s <= e) {
			int mid = (s + e) / 2;

			if (target > arr[mid]) {
				s = mid + 1;
			} else if (target < arr[mid]) {
				e = mid - 1;
			} else
				return 1;
		}
		return 0;
	}
}