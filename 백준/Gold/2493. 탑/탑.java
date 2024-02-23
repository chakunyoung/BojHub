import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Stack<Height> s = new Stack<>();

		for (int i = 0; i < size; i++) {
			while (!s.isEmpty()) {
				if (s.peek().value < arr[i]) {
					s.pop();
				} else {
					sb.append(s.peek().idx).append(" ");
					s.push(new Height(arr[i],i+1));
					break;
				}
			}
			if(s.isEmpty()) {
				s.push(new Height(arr[i],i+1));
				sb.append(0).append(" ");
			}
				
		}
		System.out.println(sb.toString());
	}
}

class Height{
	int value;
	int idx;
	public Height(int value, int idx) {
		this.value = value;
		this.idx = idx;
	}
}