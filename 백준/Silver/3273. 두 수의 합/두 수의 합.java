import java.util.*;
import java.io.*;

// bfs
// 사용된 노드만 검사
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		
		int idx = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(size -- > 0) 
			arr[idx++] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int target = Integer.parseInt(br.readLine());
		System.out.println(twoPointer(arr, target));
		
	}
	
	public static int twoPointer(int[] arr, int target) {
		int s = 0;
		int e = arr.length - 1;
		int count = 0;
		
		while(s < e) {
			// 검증
			int n1 = arr[s];
			int n2 = arr[e];
			
			// index
			// 같은 수가 있다면
			
			if(n1 + n2 == target) {
				s++;
				count++;
			}else if(n1 + n2 > target) {
				e--;
			}else
				s++;
		}
		return count;
	}
}
