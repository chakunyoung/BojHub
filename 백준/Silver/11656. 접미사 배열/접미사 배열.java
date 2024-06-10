import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		List<String> list = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {
			String part = str.substring(i, str.length());
			list.add(part);
		}

		Collections.sort(list);
		for (int i = 0; i < list.size(); i++)
			sb.append(list.get(i)).append("\n");

		System.out.println(sb);
	}
}
