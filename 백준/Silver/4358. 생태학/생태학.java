import java.io.*;
import java.util.*;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Integer> m = new HashMap<>();
		
		int counts = 0;
		String input;
		//while(!(input = br.readLine()).equals("null")) {
			while((input = br.readLine()) != null) {
			++counts;
			m.put(input, m.getOrDefault(input, 0) + 1);
		}	
		
		List<Tree> list = new ArrayList<>();
		for(Map.Entry<String ,Integer> me : m.entrySet()) {
			Tree t = new Tree();
			t.name = me.getKey();
			t.count = me.getValue();
			list.add(t);
		}
		
		list.sort((o1, o2) -> {
			return o1.name.compareTo(o2.name);
		});
		
		for(Tree t : list) {
			System.out.print(t.name + " ");
			System.out.printf("%.4f\n", (double) t.count / counts * 100);
		}
	}
	
	static class Tree{
		String name;
		int count;
	}
}
