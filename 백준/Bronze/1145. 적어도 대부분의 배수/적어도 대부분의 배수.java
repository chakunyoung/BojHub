import java.util.*;
import java.io.*;

public class Main {


	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[5];
		
		int idx = 0;
		while(st.hasMoreTokens()) 
			arr[idx ++ ] = Integer.parseInt(st.nextToken());
		
		int number = 0;
		
		loop:
		for(int i =1; i< Integer.MAX_VALUE; i++) {
			int count = 0;
			for(int j = 0; j<arr.length; j++) {
				if(i % arr[j] == 0)
					count++;
			}
			if(count >= 3) {
				number = i;
				break loop;
			}
				
		}
		
		
		System.out.println(number);
		
		
	}
}