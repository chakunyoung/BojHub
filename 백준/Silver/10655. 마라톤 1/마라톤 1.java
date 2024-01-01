import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int size = Integer.parseInt(br.readLine());
		Point[] points = new Point[size];

		for (int i = 0; i < size; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new Point(x, y);
		}

		int total = 0;
        for (int i = 0; i < size - 1; i++) {
            total += Math.abs(points[i].x - points[i+1].x) + Math.abs(points[i].y - points[i+1].y);
        }

        int max = 0;
        for (int i = 1; i < size - 1; i++) {
            int temp = Math.abs(points[i - 1].x - points[i].x) + Math.abs(points[i - 1].y - points[i].y) 
                     + Math.abs(points[i].x - points[i + 1].x) + Math.abs(points[i].y - points[i + 1].y)
                     - Math.abs(points[i - 1].x - points[i + 1].x) - Math.abs(points[i - 1].y - points[i + 1].y);
            max = Math.max(max, temp);
        }

        System.out.println(total - max);
    }

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}