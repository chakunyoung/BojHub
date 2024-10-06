import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int m;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[m];
		recur(0, 1);
		System.out.println(sb.toString());

	}

	static void recur(int nn, int mm) {
		if (nn == m) {
			for (int ele : arr)
				sb.append(ele).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = mm; i <= n; i++) {
			arr[nn] = i;
			recur(nn + 1, i + 1);
		}
	}
}
