import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());

		int[] times = new int[1001];
		int max = 0;
		List<int[]> list = new ArrayList<>();

		for(int i = 0 ; i<size; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.add(new int[]{s, e});

			for(int j = s; j<e; j++)
				times[j]++;
		}

		for (int i = 0; i < list.size(); i++) {
			int count = 0;
			int[] range = list.get(i);
			for(int j = range[0]; j<range[1]; j++)
				times[j]--;

			for(int j = 1; j<times.length; j++)
				if(times[j] > 0)
					count++;

			max = Math.max(max, count);

			for(int j = range[0]; j<range[1]; j++)
				times[j]++;
		}
		System.out.println(max);
	}
}