import java.util.*;
import java.io.*;

public class Main {

	static int move;
	static int[][] arr;
	static int[][][] v;

	static int[] xDir = { 1, -1, 0, 0 };
	static int[] yDir = { 0, 0, 1, -1 };

	static int[] knightXDir = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] knightYDir = { -2, -1, 1, 2, 2, 1, -1, -2 };

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		move = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());

		arr = new int[row][col];
		v = new int[row][col][move + 1];

		for(int i = 0; i<v.length; i++) {
			for(int j = 0; j<v[0].length; j++) {
				for(int k = 0; k<v[0][0].length; k++) {
					v[i][j][k] = 10000000;
				}
				
			}
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[0].length; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		move(move);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
//		
//		for(int i = 0; i<v.length; i++) {
//			for(int j = 0; j<v[0].length; j++) {
//				System.out.println(Arrays.toString(v[i][j]));
//			}
//		}
	}

	public static void move(int move) {
		Queue<Node> q = new ArrayDeque<>();

		q.offer(new Node(0, 0, 0, move));
		v[0][0][move] = 0;

		while (!q.isEmpty()) {
			Node n = q.poll();
			// System.out.println(n);

			if (n.x == arr.length - 1 && n.y == arr[0].length - 1)
				answer = Math.min(answer, n.dis);

			if (n.knightMove > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = n.x + knightXDir[i];
					int ny = n.y + knightYDir[i];

					if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length && arr[nx][ny] == 0
							&& n.dis + 1 < v[nx][ny][n.knightMove - 1]) {
						
						v[nx][ny][n.knightMove - 1] = n.dis + 1;
						q.offer(new Node(nx, ny, n.dis + 1, n.knightMove - 1));
						
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int nx = n.x + xDir[i];
				int ny = n.y + yDir[i];

				if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length && arr[nx][ny] == 0
						&& n.dis + 1 < v[nx][ny][n.knightMove]) {
					
					v[nx][ny][n.knightMove] = n.dis + 1;
					q.offer(new Node(nx, ny, n.dis + 1, n.knightMove));
					
				}
			}
		}
	}

	static class Node {
		int x, y, dis, knightMove;

		public Node(int x, int y, int dis, int knightMove) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.knightMove = knightMove;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", dis=" + dis + ", knightMove=" + knightMove + "]";
		}
	}
}