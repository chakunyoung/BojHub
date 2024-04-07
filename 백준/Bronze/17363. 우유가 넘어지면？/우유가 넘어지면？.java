import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] input = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				input[i][j] = s.charAt(j);
			}
		}

		for (int i = M - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				sb.append(format(input[j][i]));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static char format(char c) {
		if (c == '-')
			return '|';
		else if (c == '>')
			return '^';
		else if (c == '/')
			return '\\';
		else if (c == '|')
			return '-';
		else if (c == '\\')
			return '/';
		else if (c == '^')
			return '<';
		else if (c == '<')
			return 'v';
		else if (c == 'v')
			return '>';
		return c;
	}
}