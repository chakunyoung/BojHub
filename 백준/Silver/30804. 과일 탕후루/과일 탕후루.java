import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];

		st = new StringTokenizer(br.readLine());
		int idx = 0;
		while (st.hasMoreTokens())
			arr[idx++] = Integer.parseInt(st.nextToken());

		int[] count = new int[10];
		int l = 0;
		int r = 0;
		int max = 0;
		int countFruit = 0;

		while (r < size) {
			if (count[arr[r]] == 0) {
				countFruit++;
			}
			count[arr[r]]++;
			r++;

			while (countFruit > 2) {
				count[arr[l]]--;
				if (count[arr[l]] == 0) {
					countFruit--;
				}
				l++;
			}

			max = Math.max(max, r - l);
		}
		System.out.println(max);
	}
}
