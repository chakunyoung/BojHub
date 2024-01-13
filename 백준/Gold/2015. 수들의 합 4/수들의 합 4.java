import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		long target = Integer.parseInt(st.nextToken());

		Map<Long, Long> m = new HashMap<>();
		m.put(0L, 1L);

		long count = 0;
		long initSum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			initSum += Integer.parseInt(st.nextToken());
			count += m.getOrDefault(initSum - target, 0L);
			m.put(initSum, m.getOrDefault(initSum, 0L) + 1);
		}
		System.out.println(count);
	}
}