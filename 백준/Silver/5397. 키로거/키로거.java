import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			LinkedList<Character> list = new LinkedList<>();
			String str = br.readLine();
			StringBuilder res = new StringBuilder();

			int idx = 0;

			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);

				if (c == '<') {
					if (idx > 0)
						idx--;
				} else if (c == '>') {
					if (idx < list.size())
						idx++;
				} else if (c == '-') {
					if (idx > 0) {
						list.remove(idx - 1);
						idx--;
					}
				} else {
					list.add(idx, c);
					idx++;
				}
			}

			for (char ch : list)
				res.append(ch);
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}
}