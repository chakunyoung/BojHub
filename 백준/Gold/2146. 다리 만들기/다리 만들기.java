import java.util.*;
import java.io.*;

public class Main {

	static int size;
	static int num = 2;
	static int arr[][];
	static Queue<Node> q = new LinkedList<>();
	static List<Node> list = new ArrayList<>();
	static boolean[][] v;

	static int[] xdir = { 1, -1, 0, 0 };
	static int[] ydir = { 0, 0, 1, -1 };

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		size = Integer.parseInt(br.readLine());
		arr = new int[size][size];
		v = new boolean[size][size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < size; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		// flood fill
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[i][j] == 1) {
					floodfill(i, j);
					num++;
				}
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[i][j] != 0) {

					boolean b = false;
					
					for (int k = 0; k < 4; k++) {
						int nx = xdir[k] + i;
						int ny = ydir[k] + j;

						if (nx >= 0 && ny >= 0 && nx < size && ny < size && arr[nx][ny] == 0) {
							b = true;
							break;
						}
					}
					
					if (b) 
						answer = Math.min(answer, bridge(i, j, arr[i][j]));
					
					v = new boolean[size][size];
				}
			}
		}
		System.out.println(answer);
	}

	public static void floodfill(int x, int y) {
		q.offer(new Node(x, y, 0));
		arr[x][y] = num;

		while (!q.isEmpty()) {
			Node n = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = n.x + xdir[i];
				int ny = n.y + ydir[i];

				if (nx >= 0 && ny >= 0 && nx < size && ny < size && arr[nx][ny] == 1) {
					arr[nx][ny] = num;
					q.offer(new Node(nx, ny, 0));
				}
			}
		}
	}

	public static int bridge(int x, int y, int start) {
		Node nn = new Node(x, y, 0);
		nn.startNum = start;
		q.offer(nn);
		
		while (!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.dist > answer) {
				q.clear();
				return Integer.MAX_VALUE;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = n.x + xdir[i];
				int ny = n.y + ydir[i];
				
				if (nx >= 0 && ny >= 0 && nx < size && ny < size && !v[nx][ny]) {
					if (arr[nx][ny] == 0) {
						q.offer(new Node(nx, ny, n.dist + 1));
						v[nx][ny] = true;
					}
						
					else if (arr[nx][ny] != start) {
						q.clear();
						return n.dist;
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	static class Node {
		int x, y, dist, startNum;

		public Node(int x, int y, int dist) {
			this.dist = dist;
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", dist=" + dist + "]";
		}
	}
}
