import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		long s1 = Long.parseLong(st.nextToken());
		long s2 = Long.parseLong(st.nextToken());

		System.out.println((s1 + s2) * (s1 - s2));

	}
}
