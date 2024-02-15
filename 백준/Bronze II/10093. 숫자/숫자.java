import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		long s = Long.parseLong(st.nextToken());
		long e = Long.parseLong(st.nextToken());
		if (s > e) {
			long t = s;
			s = e;
			e = t;
		}

		long count = 0;
		for (long i = s + 1; i < e; i++) {
			sb.append(i).append(" ");
			++count;
		}
		System.out.println(count);
		System.out.println(sb);
	}
}
