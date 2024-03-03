import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());

			String s1 = st.nextToken();
			String s2 = st.nextToken();

			BigInteger b1 = new BigInteger(s1, 2);
			BigInteger b2 = new BigInteger(s2, 2);
			BigInteger sum = b1.add(b2);
			sb.append(sum.toString(2)).append("\n");
		}
		System.out.println(sb.toString());
	}
}