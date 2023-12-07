import java.util.*;
import java.io.*;

public class Main {


	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		
		loop:
		for(int i = 0; i<testCase; i++) {
			long number = Long.parseLong(br.readLine());
			
			for(int j = 2; j<=100_000_0; j++) {
				if(number % j == 0) {
					sb.append("NO").append("\n");
					continue loop;
				}
					
			}
			sb.append("YES").append("\n");
		}
		System.out.println(sb.toString());
	}
}