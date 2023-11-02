import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		long n1 = Long.parseLong(st.nextToken());		
		long n2 = Long.parseLong(st.nextToken());
		long c1 = count(n1 - 1, 1, 0);
		long c2 = count(n2, 1, 0);
		
		System.out.println(c2 - c1);
	}
	
	public static long count(long number, long size, long count2) {
		if(size > number) {
			return count2;
		}
		count2 -= (size >> 1) * (number/size);
		count2 += size * (number/size);
		return count(number, size << 1, count2);
	}
}
