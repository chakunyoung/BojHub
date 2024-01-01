import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] h = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			h[i] = Integer.parseInt(br.readLine());
			sum += h[i];
		}

		Arrays.sort(h);

		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - h[i] - h[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (k == i || k == j)
							continue;
						System.out.println(h[k]);
					}
					return;
				}
			}
		}
	}
}
