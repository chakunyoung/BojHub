import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] memo = new int[size];
		Arrays.fill(memo, 1);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j])
					memo[i] = Math.max(memo[j] + 1, memo[i]);
			}
		}

		int max = 0;
		for (int i = 0; i < size; i++) {
			max = Math.max(max, memo[i]);
		}

		System.out.println(max);
		//System.out.println(Arrays.toString(memo));
	}
}