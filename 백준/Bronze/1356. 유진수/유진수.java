import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str = br.readLine();
		boolean check = false;

		for (int i = 1; i < str.length(); i++) {
			String s1 = str.substring(0, i);
			String s2 = str.substring(i, str.length());

			int sumS1 = 1;
			int sumS2 = 1;

			for (int j = 0; j < s1.length(); j++) {
				sumS1 *= s1.charAt(j) - '0';
			}

			for (int j = 0; j < s2.length(); j++) {
				sumS2 *= s2.charAt(j) - '0';
			}

			if (sumS1 == sumS2) {
				check = true;
			}
		}
		System.out.println(check == true ? "YES" : "NO");
	}
}