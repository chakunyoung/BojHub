import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[w+2];
		int[] leftArr = new int[w + 2];
		int[] rightArr = new int[w + 2];
		
		int idx = 1;
		while(st.hasMoreTokens()) 
			arr[idx++] = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i<leftArr.length - 1; i++) 
			leftArr[i] = Math.max(arr[i], leftArr[i-1]);  
		
		for(int i = leftArr.length - 2; i > 0; i--) 
			rightArr[i] = Math.max(arr[i], rightArr[i+1]);
		
		int count = 0;
		for(int i = 1; i<leftArr.length - 1; i++) 
			count += Math.min(leftArr[i], rightArr[i]) - arr[i];   
		
		System.out.println(count);
	}
	
	
}
