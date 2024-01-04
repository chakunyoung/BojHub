import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		List<Long> list = new ArrayList<>();
		Map<Long, Long> primeCount = new HashMap<>();

		for (int i = 0; i < testCase; i++) {
			st = new StringTokenizer(br.readLine());

			long n = Long.parseLong(st.nextToken());
			long tempN = n;
			long k = Long.parseLong(st.nextToken());

			for (long j = 2; j * j <= k; j++) {
				while (k % j == 0) {
					primeCount.put(j, primeCount.getOrDefault(j, 0L) + 1);
					k /= j;
				}
			}
			if (k > 1)
				primeCount.put(k, primeCount.getOrDefault(k, 0L) + 1);

			long min = Long.MAX_VALUE;
			for (Long prime : primeCount.keySet()) {
				tempN = n;
				long count = 0;
				for (long mul = prime; mul <= tempN; ) {
					count += tempN / mul;
					tempN /= mul;
				}
				min = Math.min(min, count / primeCount.get(prime));

			}

			sb.append(min).append("\n");
			list.clear();
			primeCount.clear();
		}
		System.out.println(sb);
	}
}