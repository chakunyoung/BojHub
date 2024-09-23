import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 10; i++)
			list.add(Integer.parseInt(br.readLine()));

		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			int localSum = sum + list.get(i);
			if (localSum > 100) {
				int temp = localSum - 100;
				int temp2 = 100 - sum;

				if (temp > temp2) {
					System.out.println(sum);
					return;
				} else {
					System.out.println(localSum);
					return;
				}
			} else {
				sum += list.get(i);
			}
		}
		System.out.println(sum);
	}
}