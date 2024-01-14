import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		String str = br.readLine();

		int[] arr = new int[str.length()];
		int[] sCount = new int[str.length() + 1];
		int[] kCount = new int[str.length() + 1];

		for (int i = 0; i < arr.length; i++) {
			if (str.charAt(i) == 'S') {
				arr[i] = 2;
				sCount[i + 1] = sCount[i] + 1;
				kCount[i + 1] = kCount[i];
			} else if (str.charAt(i) == 'K') {
				arr[i] = -1;
				kCount[i + 1] = kCount[i] + 1;
				sCount[i + 1] = sCount[i];
			} else {
				sCount[i + 1] = sCount[i];
				kCount[i + 1] = kCount[i];
			}
		}

		int[] prefix = new int[str.length() + 1];
		for (int i = 1; i < arr.length + 1; i++) {
			prefix[i] = arr[i - 1] + prefix[i - 1];
		}

		// 문자열안에 s, k 가 존재해야 함
		int ans = -1;
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < arr.length + 1; i++) {
			if (m.containsKey(prefix[i])) {
				int startIdx = m.get(prefix[i]);
				if (sCount[i] > sCount[startIdx] && kCount[i] > kCount[startIdx]) {
					ans = Math.max(ans, i - startIdx);
				}
			} else {
				m.put(prefix[i], i);
			}
		}
		System.out.println(ans);
	}
}