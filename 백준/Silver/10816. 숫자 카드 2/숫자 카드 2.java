import java.util.*;
import java.io.*;

public class Main {

	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int len = Integer.parseInt(br.readLine());
		arr = new int[len];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		len = Integer.parseInt(br.readLine());
		int[] fnums = new int[len];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < fnums.length; i++) {
			int fnum = Integer.parseInt(st.nextToken());
			int sIdx = lower_bound(fnum);
			int eIdx = upper_bound(fnum);
			
			if(sIdx != -1) 
				sb.append(eIdx - sIdx + 1).append(" ");
			else
				sb.append(0).append(" ");
		}
		System.out.println(sb.toString());
	}

	public static int lower_bound(int fnum) {
		int s = 0;
		int e = arr.length - 1;

		int idx = -1;
		while (s <= e) {
			int mid = (s + e) / 2;

			if(arr[mid] >= fnum) {
				if(arr[mid] == fnum)
					idx = mid;
				e = mid - 1;
			}else {
				s = mid + 1;
			}
		}

		return idx;
	}
	
	public static int upper_bound(int fnum) {
		int s = 0;
		int e = arr.length - 1;

		int idx = -1;
		while (s <= e) {
			int mid = (s + e) / 2;

			if(arr[mid] > fnum) {
				e = mid - 1;
			}else {
				if(arr[mid] == fnum)
					idx = mid;
				s = mid + 1;
			}
		}

		return idx;
	}

}
