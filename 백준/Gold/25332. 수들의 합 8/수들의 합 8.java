import java.util.*;
import java.io.*;

// N번만의 부분합을 구하는 문제
// 2015, 3673과 비슷하면서도, 더 까다롭게 느껴짐

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());
		long ans = 0;

		int[] arr1 = new int[size + 1];
		int[] arr2 = new int[size + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= size; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
			arr1[i] += arr1[i - 1];
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= size; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
			arr2[i] += arr2[i - 1];

			if (arr1[i] == arr2[i])
				ans++;
		}
		
		// 누적 arr2 - arr1 의 결과를 사용한다.
		Map<Long, Integer> map = new HashMap<>();
		for (int i = 1; i <= size; i++) {
			long e = arr2[i] - arr1[i];
			if(map.containsKey(e)) 
				ans += map.get(e);
			map.put(e, map.getOrDefault(e, 0) + 1);
		}
		System.out.println(ans);
	}
}