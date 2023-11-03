import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[] v;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());
		arr = new int[size + 1][size + 1];
		int line = Integer.parseInt(br.readLine());
		v = new boolean[size + 1];

		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		
		depth(size, 1);
		v[1] = true;
		
		//System.out.println(Arrays.toString(v));
		
		int count = 0;
		for(int i = 0; i<v.length; i++) {
			if(v[i])
				++count;
		}
		System.out.println(count - 1);
	}
	
	static void depth(int size, int node) {
		for(int i = 0; i<size + 1; i++) {
			if(arr[node][i] == 1 && !v[i]) {
				v[i] = true;
				depth(size, i);
			}
		}
	}
}