import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		boolean[] arr = new boolean[4_000_001];
		
		for(int i = 2; i<arr.length; i++) {
			if(!arr[i]) {
				for(int j = i + i; j<arr.length; j += i) 
					arr[j] = true;
			}
		}
		
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		for(int i = s; i <= e; i++) {
			if(!arr[i]) {
				int number = i;
				while(number != 0) {
					int nn = number % 10;
					if(nn == n) {
						ans++;
						break;
					}
						
					number /= 10;
				}
			}
		}
		System.out.println(ans);
	}
}