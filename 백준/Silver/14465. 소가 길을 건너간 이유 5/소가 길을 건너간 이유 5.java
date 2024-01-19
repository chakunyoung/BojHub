import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int load = Integer.parseInt(st.nextToken());
		int streaks = Integer.parseInt(st.nextToken());
		int brokens = Integer.parseInt(st.nextToken());

		int[] loads = new int[load + 1];

		for (int i = 0; i < brokens; i++) {
			int broken = Integer.parseInt(br.readLine());
			loads[broken] = 1;
		}

		int brokenMin = 0;

		for (int i = 1; i <= streaks; i++) {
			if (loads[i] == 1)
				++brokenMin;
		}

		int s = 2;
		int e = streaks;

		int tempMin = brokenMin;
		while (e < loads.length) {
			if (e + 1 <= load) {
				tempMin -= loads[s - 1];
				tempMin += loads[e + 1];
			}
			brokenMin = Math.min(tempMin, brokenMin);
			s++;
			e++;
		}

		System.out.println(brokenMin);
	}
}