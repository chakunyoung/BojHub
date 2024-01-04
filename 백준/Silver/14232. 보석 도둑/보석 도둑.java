import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Long w = Long.parseLong(br.readLine());
		
		List<Long> ans = new ArrayList<>();
		
		for (long f = 2; f * f <= w; f++) {
            while (w % f == 0) {
            	ans.add(f);
                w /= f;
            }
        }
        
        if (w > 1) {
        	ans.add(w);
        }
		
		Collections.sort(ans);
		
		System.out.println(ans.size());
		for(long a : ans) {
			sb.append(a).append(" ");
		}
		System.out.println(sb);
	}
}