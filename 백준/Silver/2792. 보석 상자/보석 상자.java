import java.util.*;
import java.io.*;

public class Main {

	static int[] arr;
	static int child;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		child = Integer.parseInt(st.nextToken());
		int color = Integer.parseInt(st.nextToken());

		arr = new int[color];
		for (int i = 0; i < color; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		System.out.println(ps());
	}

	public static int ps() {
	    int s = 1, e = Integer.MAX_VALUE >> 1, ans = 0;

	    while (s <= e) {
	        int mid = (s + e) / 2;
	        int count = 0;
	        for (int ele : arr) {
	            count += ele / mid;
	            if (ele % mid != 0) {
	                count++;
	            }
	        }

	        if (count <= child) {
	            ans = mid;
	            e = mid - 1;
	        } else {
	            s = mid + 1;
	        }
	    }
	    return ans;
	}
}