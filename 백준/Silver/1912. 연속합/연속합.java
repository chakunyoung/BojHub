import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		br.readLine();
		st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		while (st.hasMoreTokens()) {
			int number = Integer.parseInt(st.nextToken());
			sum += number;
			sum = Math.max(sum, number);
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}