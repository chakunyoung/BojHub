import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] up = new int[H + 1];
		int[] down = new int[H + 1];

		// 높이에 해당하는거 ++
		for (int i = 0; i < N / 2; i++) {
			down[Integer.parseInt(br.readLine())]++;
			up[Integer.parseInt(br.readLine())]++;
		}

		for (int i = H - 1; i > 0; i--) {
			up[i] += up[i + 1];
			down[i] += down[i + 1];
		}

		int min = Integer.MAX_VALUE;
		int count = 0;

		for (int i = 1; i <= H; i++) {
			int temp = up[i] + down[H - i + 1];
			if (temp < min) {
				min = temp;
				count = 1;
			} else if (temp == min) {
				count++;
			}
		}

		System.out.println(min + " " + count);
	}
}