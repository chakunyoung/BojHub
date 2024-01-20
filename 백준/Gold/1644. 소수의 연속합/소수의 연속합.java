import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		List<Integer> primes = new ArrayList<>();
		boolean[] check = new boolean[4_000_001];

		for (int i = 2; i < check.length; i++) {
			if (!check[i]) {
				primes.add(i);
				for (int j = i; j < check.length; j += i) {
					check[j] = true;
				}
			}
		}

		int s = 0;
		int e = 0;
		int sum = 0;
		int count = 0;
		
		while(e < primes.size()) {
			sum += primes.get(e);
			
			while(sum > n && s != e) {
				sum -= primes.get(s);
				s++;
			}
			
			if(sum == n)
				count++;
			
			e++;
		}
		System.out.println(count);
		
	}
}