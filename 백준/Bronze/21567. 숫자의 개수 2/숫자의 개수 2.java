import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long temp = 1;
		for (int i = 0; i < 3; i++) {
			temp *= Long.parseLong(br.readLine());
		}

		String ts = String.valueOf(temp);
		int[] count = new int[10];
		for (int i = 0; i < ts.length(); i++) {
			int c = ts.charAt(i) - '0';
			count[c]++;
		}

		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}

	}
}