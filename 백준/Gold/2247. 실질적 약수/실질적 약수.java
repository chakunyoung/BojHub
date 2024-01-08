import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int number = Integer.parseInt(br.readLine());
		
		long ans = 0;
		for(int i = 2; i<=number/2; i++) {
			int n = number/i;
			n--; // 시작수 제외
			ans = ((ans) + ((i * n) % 1_000_000)) % 1_000_000;
		}
		System.out.println(ans);
	}
}