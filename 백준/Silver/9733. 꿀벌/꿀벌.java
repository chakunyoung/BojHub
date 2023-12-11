import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<String, Integer> tasks = new HashMap<>();
		String[] names = { "Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex" };
		for (String task : names) {
			tasks.put(task, 0);
		}

		int totalTasks = 0;
		String input;
		while ((input = br.readLine()) != null) {
			String[] splitInput = input.split(" ");
			totalTasks+= splitInput.length;
			for (String task : splitInput) {
				if (tasks.containsKey(task)) {
					tasks.put(task, tasks.get(task) + 1);
				}
			}
		}

		for (String task : names) {
			System.out.print(task + " ");
			int count = tasks.get(task);
			System.out.print(count + " ");
			double ratio = totalTasks > 0 ? (double) count / totalTasks : 0;
			System.out.printf("%.2f\n", ratio);
		}
		System.out.println("Total " + totalTasks + " 1.00");
	}
}