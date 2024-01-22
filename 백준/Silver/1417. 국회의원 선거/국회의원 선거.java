import java.util.*;
import java.io.*;

public class Main {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		PriorityQueue<People> pq = new PriorityQueue<>((o1, o2) -> {
			return o2.count - o1.count;
		});
		
		int size = Integer.parseInt(br.readLine());
		if(size == 1) {
			System.out.println(0);
			return;
		}
			
		int dasom = Integer.parseInt(br.readLine());
		for(int i = 1; i<size; i++) {
			int n = Integer.parseInt(br.readLine());
			pq.offer(new People(n, i));
		}
		
		int money = 0;
		People people;
		while(true) {
			people = pq.poll();
			if(dasom > people.count)
				break;
			money++;
			dasom++;
			people.count--;
			pq.offer(people);
		}
		System.out.println(money);
	}
	
	static class People{
		int count, number;
		public People(int count, int number) {
			this.count = count;
			this.number = number;
		}
		
	}
}