import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 약수가 있다면 해당 기울기는 이미 다른 x, y 가 선점함
		int count = 1;
		int[] arr = new int[1001];
		arr[1] = 3;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < i; j++) {
				if (1 == gcd(Math.max(i, j), Math.min(i, j)))
					++count;
			}
			arr[i] = count * 2 + 1;
		}

		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			sb.append(arr[Integer.parseInt(br.readLine())]).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static int gcd(int x, int y) {
		if (y == 0) {
			return x;
		}
		return gcd(y, x % y);
	}
}