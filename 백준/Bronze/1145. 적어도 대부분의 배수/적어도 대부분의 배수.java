import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] arr = new int[5];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int min = 1;
		while (true) {
			int count = 0;
			for (int number : arr) {
				if (min % number == 0)
					count++;
			}
			if (count >= 3) {
				System.out.println(min);
				break;
			}
			min++;
		}
	}
}
