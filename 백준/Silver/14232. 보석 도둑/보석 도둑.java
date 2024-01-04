import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		long w = Long.parseLong(br.readLine().trim());
		long temp = w;
		
		List<Long> list = new ArrayList<>();
		for(long i = 2; i<=Math.sqrt(w); i++) {
			if(temp % i == 0) {
				list.add(i);
				temp /= i;
				i--;
			}
		}
		if(temp != 1) list.add(temp);
		
		sb.append(list.size()).append("\n");
		for(long n : list) sb.append(n).append(" ");
		System.out.println(sb);
	}
}