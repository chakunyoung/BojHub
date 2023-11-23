import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int line = Integer.parseInt(br.readLine());
		
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i<=line; i++) 
			list.add(new ArrayList<>());
		
		while(line -- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = st.nextToken().charAt(0) - 'A';
			int s1 = st.nextToken().charAt(0) - 'A';
			int s2 = st.nextToken().charAt(0) - 'A';
			list.get(p).add(s1);
			list.get(p).add(s2);
		}
		
		// 부모노드 A 보장
		abb(list, 0); sb.append("\n");
		bab(list, 0); sb.append("\n");
		bba(list, 0);
		System.out.println(sb.toString());
	}
	
	public static void abb(List<List<Integer>> list, int p) {
		if(p == '.' - 'A')
			return;
		sb.append((char)(p + 'A'));
		abb(list, list.get(p).get(0));
		abb(list, list.get(p).get(1));
	}
	
	public static void bab(List<List<Integer>> list, int p) {
		if(p == '.' - 'A')
			return;
		bab(list, list.get(p).get(0));
		sb.append((char)(p + 'A'));
		bab(list, list.get(p).get(1));
	}
	
	public static void bba(List<List<Integer>> list, int p) {
		if(p == '.' - 'A')
			return;
		bba(list, list.get(p).get(0));
		bba(list, list.get(p).get(1));
		sb.append((char)(p + 'A'));
	}
	
}

