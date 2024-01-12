import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int days = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[size];
		
		int idx = 0;
		while(st.hasMoreTokens()) 
			arr[idx++] = Integer.parseInt(st.nextToken());
		
		int s = 0;
		int e = 0;
		int sum = 0;
		int answer = Integer.MIN_VALUE;
		
		// 초기
		for(; e<days; e++) 
			sum += arr[e];
		answer = Math.max(answer, sum);
		
		while(e != size) {
			sum -= arr[s++];
			sum += arr[e++];
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}
}
