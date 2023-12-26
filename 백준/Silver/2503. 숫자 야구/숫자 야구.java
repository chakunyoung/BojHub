import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		List<Integer> numbers = new LinkedList<>();

		for (int i = 111; i <= 999; i++) {
			int n1 = i / 10 % 10;
			int n2 = i / 100;
			int n3 = i % 10;

			if (n1 == 0 || n2 == 0 || n3 == 0)
				continue;

			if (i / 10 % 10 == i % 10 || i / 100 == i / 10 % 10 || i / 100 == i % 10)
				continue;
			numbers.add(i);
		}

		int size = Integer.parseInt(br.readLine());
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			Iterator<Integer> it = numbers.iterator();

			int input = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int sum = s + b;

			while (it.hasNext()) {
				int num = it.next();
				int[] n = digit(num);
				int[] in = digit(input);

				int count = 0;
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if(n[j] == in[k]) ++count;
					}
				}

				int sCount = 0;
				for(int j = 0; j<3; j++){
					if(n[j] == in[j]) ++sCount;
				}

				if(sCount != s || count != sum)
					it.remove();

			}
		}
		System.out.println(numbers.size());
	}

	public static int[] digit(int number) {
		int n1 = number / 100;
		int n2 = number / 10 % 10;
		int n3 = number % 10;
		return new int[] {n1, n2, n3};
	}
}