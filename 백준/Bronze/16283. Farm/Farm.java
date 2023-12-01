import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		List<int[]> list = new ArrayList<>();
		for (int i = 1; i < c; i++) {
			int temp = a * i;
			if (temp + b * (c - i) == d) {
				list.add(new int[]{i, c-i});
			}
		}
		if(list.size() >= 2 || list.size() == 0)
			System.out.println(-1);
		else
			System.out.println(list.get(0)[0] + " " + list.get(0)[1]);
	}
}