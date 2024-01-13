import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long target = Long.parseLong(br.readLine());
		int n = Integer.parseInt(br.readLine());
		long[] a = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		long[] b = new long[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			b[i] = Long.parseLong(st.nextToken());
		}

		Map<Long, Long> sumA = new HashMap<>();
		for (int i = 0; i < n; i++) {
			long sum = 0;
			for (int j = i; j < n; j++) {
				sum += a[j];
				sumA.put(sum, sumA.getOrDefault(sum, 0L) + 1);
			}
		}

		long count = 0;
		for (int i = 0; i < m; i++) {
			long sum = 0;
			for (int j = i; j < m; j++) {
				sum += b[j];
				count += sumA.getOrDefault(target - sum, 0L);
			}
		}

		System.out.println(count);
	}
}