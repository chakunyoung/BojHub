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

			BigInteger bi = new BigInteger(s1, 2);
			s1 = bi.toString(2);

			bi = new BigInteger(s2, 2);
			s2 = bi.toString(2);

			if (s1.length() < s2.length()) {
				String t = "";
				t = s2;
				s2 = s1;
				s1 = t;
			}

			s2 = "0".repeat(s1.length() - s2.length()) + s2;
			StringBuilder res = new StringBuilder();
			int carry = 0;
			for (int j = s1.length() - 1; j >= 0; j--) {
				int sum = (s1.charAt(j) - '0') + (s2.charAt(j) - '0') + carry;
				res.insert(0, sum % 2);
				carry = sum / 2;
			}

			if (carry != 0)
				res.insert(0, carry);

			sb.append(res.toString()).append("\n");
		}
		System.out.println(sb.toString());
	}
}
