import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int res = 0;
		for (int i = 0; i < n; i++) {
			res += Integer.parseInt(br.readLine());
		}
		System.out.println(res);

	}

}
