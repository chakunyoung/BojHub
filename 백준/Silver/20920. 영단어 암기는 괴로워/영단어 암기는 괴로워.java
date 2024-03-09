import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if (word.length() < M)
				continue;
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
			int count = map.get(b).compareTo(map.get(a));
			if (count == 0) {
				int len = Integer.compare(b.length(), a.length());
				if (len == 0) {
					return a.compareTo(b);
				}
				return len;
			}
			return count;
		});

		pq.addAll(map.keySet());

		sb = new StringBuilder();
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append('\n');
		}

		System.out.println(sb);
	}
}