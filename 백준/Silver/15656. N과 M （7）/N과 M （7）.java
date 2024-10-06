import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static int[] arr;
	static int[] sarr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		sarr = new int[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		recur(0);
		System.out.println(sb.toString());
	}

	static void recur(int nn) {
		if (nn == m) {
			for (int i = 0; i < m; i++) {
				sb.append(sarr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			sarr[nn] = arr[i];
			recur(nn + 1);
		}
	}
}