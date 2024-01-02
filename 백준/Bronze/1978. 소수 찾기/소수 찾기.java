import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		boolean[] checkPrimes = new boolean[1001];
		checkPrimes[1] = true;

		for (int i = 2; i <= Math.sqrt(checkPrimes.length); i++) {
			if (!checkPrimes[i]) {
				for (int j = i + i; j < checkPrimes.length; j += i) {
					checkPrimes[j] = true;
				}
			}
		}

		int line = Integer.parseInt(br.readLine());
		int count = 0;
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			if (!checkPrimes[Integer.parseInt(st.nextToken())]) {
				++count;
			}
		}
		System.out.println(count);
	}
}