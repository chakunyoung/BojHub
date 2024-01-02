import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		long n1 = Integer.parseInt(st.nextToken());
		long n2 = Integer.parseInt(st.nextToken());

		long count2 = count(n1, 2, 2, 0) - count(n1 - n2, 2, 2, 0) - count(n2, 2, 2, 0);
		long count5 = count(n1, 5, 5, 0) - count(n1 - n2, 5, 5, 0) - count(n2, 5, 5, 0);
		
		System.out.println(Math.min(count2, count5));
		
	}

	public static long count(long number, long div, long size, long count) {
		if (number < div) { 
	        return count;
	    }

		return count(number, div * size, size, number / div + count);
	}
}