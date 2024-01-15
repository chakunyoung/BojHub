import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int size = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[] arr = new int[h + 1];

		for(int i = 0; i<size; i++){
			int num = Integer.parseInt(br.readLine());
			if( i % 2 == 0){
				arr[0] += 1;
				arr[num + 1] -= 1;
			}else{
				arr[h - num + 1] += 1;
			}
		}

		int min = Integer.MAX_VALUE;
		int[] prefix = new int[h+1];
		prefix[0] = arr[0];
		for(int i = 1; i<=h; i++){
			prefix[i] = prefix[i-1] + arr[i];
			min = Math.min(min, prefix[i]);
		}

		int count = 0;
		for(int i = 1; i<=h; i++){
			if(prefix[i] == min)
				count++;
		}
		System.out.println(min + " " + count);
	}
}

