
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static String[] temp;
	static String[] arr;
	static int len;
	static int strs;
	static List<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		len = Integer.parseInt(st.nextToken());
		strs = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		arr = new String[strs];
		temp = new String[len];

		int idx = 0;
		while (st.hasMoreTokens())
			arr[idx++] = st.nextToken();

		Arrays.sort(arr); // 정렬 순

		comb(len, 0, 0);

		for (String s : list) 
			sb.append(s).append("\n");
		
		System.out.println(sb);
	}

	// a e i o u // 1개 ~ 3개
	// 조합
	public static void comb(int limit, int n, int idx) {
		if (limit == n) {
			
			int aeiou = 0;
			int rest = 0;
			
			// 최소 한개의 모음과 최소 두개의 자음
			for(int i = 0; i<temp.length; i++) {
				if(temp[i].equals("a") || temp[i].equals("e") || temp[i].equals("i") || temp[i].equals("o") || temp[i].equals("u"))
					aeiou++;
				else
					rest++;
			}
			
			if(aeiou < 1 || rest < 2)
				return;
			
			sb = new StringBuilder();
			for (String s : temp)
				sb.append(s);
			list.add(sb.toString());
			sb.setLength(0);
			return;
		}

		for (int i = idx; i < strs; i++) {
			temp[n] = arr[i];
			comb(limit, n + 1, i + 1);
		}
	}
}