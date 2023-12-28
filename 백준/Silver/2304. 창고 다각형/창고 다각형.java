import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int input = Integer.parseInt(br.readLine());
		
		int[] arr = new int[1002];
		int[] leftArr = new int[1002];
		int[] rightArr = new int[1002];
		
		for(int i = 0; i<input; i++) {
			st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			arr[id] = v;
		}
		
		for(int i = 1; i<leftArr.length - 1; i++) 
			leftArr[i] = Math.max(arr[i], leftArr[i-1]);  
		
		for(int i = leftArr.length - 2; i > 0; i--) 
			rightArr[i] = Math.max(arr[i], rightArr[i+1]);
		
		int ans = 0;
		for(int i = 1; i<leftArr.length - 1; i++) {
			arr[i] = Math.min(leftArr[i], rightArr[i]);
			ans += arr[i];
		}
		
		System.out.println(ans);
	}
}
