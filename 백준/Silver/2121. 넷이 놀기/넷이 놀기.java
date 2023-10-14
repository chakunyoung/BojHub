import java.util.*;

import java.io.*;

public class Main {

	static int count;
	static List<Point> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int line = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();

		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Point(x, y));
		}

		Collections.sort(list, (o1, o2) -> {
			if (o1.x == o2.x) {
				return o1.y - o2.y;
			} else {
				return o1.x - o2.x;
			}
		});

		for (int i = 0; i < list.size(); i++) {
			Point n = list.get(i);

			int x = n.x;
			int y = n.y;
			int xr = n.x + r;
			int yc = n.y + c;

			if (bs(x, yc) && bs(xr, y) && bs(xr, yc)) {
				++count;
			}
		}
		System.out.println(count);

	}

	public static boolean bs(int x, int y) {
		int s = 0;
		int e = list.size() - 1;
		int mid = 0;

		while (s <= e) {
			mid = (s + e) / 2;
			Point p = list.get(mid);

			if (p.x < x) {
				s = mid + 1;
			} else if (p.x > x) {
				e = mid - 1;
			} else {// 둘이 같음
				if (p.y < y) {
					s = mid + 1;
				} else if (p.y > y) {
					e = mid - 1;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
