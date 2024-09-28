import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int size = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[size];

		int idx = 0;
		while (st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}

		int s = 0;
		int e = 0;

		int sum = 0;
		int ans = 0;

		while (e <= size) {
			if (sum == t) {
				ans++;
			}

			if (sum >= t) {
				sum -= arr[s++];
			} else if (e < size) {
				sum += arr[e++];
			} else {
				break;
			}
		}

		System.out.println(ans);
	}
}
