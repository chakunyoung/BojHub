import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int g = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 1; i <= 500; i++) {
			for (int j = 1; j <= i; j++) {
				if (i * i - j * j == g) {
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
