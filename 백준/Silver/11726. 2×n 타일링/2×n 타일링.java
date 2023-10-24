import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int limit;
    static int[] memo;
    
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        
        limit = Integer.parseInt(br.readLine());
        memo = new int[limit + 1];
        Arrays.fill(memo, -1);
        int res = recur(0);
        System.out.println(res);
    }
    
    
    static int recur(int n) {
    	
    	
    	if(limit == n) {
    		return 1;
    	}
    	
    	if(n > limit)
    		return 0;
    	
    	if(memo[n] != -1)
    		return memo[n];
    	
    	return memo[n] = (recur(n + 1) + recur(n + 2)) % 10007; 
    }    
}
