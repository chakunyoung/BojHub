import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int child;
    static int p;
    static long ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        for(int i = 0; i<n; i++) 
        	arr[i] = Integer.parseInt(br.readLine());
        
        bs();
        System.out.println(ans);
        
    }
    
    public static void bs() {
    	long s = 1;
    	long e = Integer.MAX_VALUE;
    	long mid = 0;
    	
    	while(s<=e) {
    		mid = (s + e) / 2;
    		int count = 0;
    		for(int ele : arr) {
    			if(ele >= mid) 
    				count += ele / mid;
    		}
    		
    		if(count >= p) {
    			ans = mid;
    			s = mid + 1;
    		}else 
    			e = mid - 1;
    	}
    	
    }
}
