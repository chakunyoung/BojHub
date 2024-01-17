import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int min = Integer.MAX_VALUE;
		int s = 0;
		int e = size - 1;
		int[] ans = new int[2];

		while (s < e) {
			int res = arr[s] + arr[e];

			if (min > Math.abs(res)) {
				min = Math.abs(res);
				ans[0] = arr[s];
				ans[1] = arr[e];
			}

			if (res > 0) {
				e--;
			} else {
				s++;
			}
		}
		System.out.println(ans[0] + " " + ans[1]);
	}
}