import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int groupCount = 0;
		while(m >= 1 && w >= 2){
			if(w >= 2){
				w -= 2;
				m -= 1;
				groupCount++;
			}
		}

		while(k >0){
			if(w >= 1){
				w--;
			}else if(m >= 1)
				m--;
			else{
				groupCount--;
				m+=1;
				w+=1;
			}
			k--;
		}
		System.out.println(groupCount);
	}
}