import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		TreeSet<Node> ts = new TreeSet<Node>((o1, o2)->{
			if(o1.year == o2.year) {
				if(o1.month == o2.month) {
					return o1.day - o2.day;
				}
				return o1.month - o2.month;
			}
			return o1.year - o2.year;
		});

		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			ts.add(new Node(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		System.out.println(ts.last().name);
		System.out.println(ts.first().name);

	}

	static class Node{
		String name;
		int day;
		int month;
		int year;
		public Node(String name, int day, int month, int year){
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}
}
