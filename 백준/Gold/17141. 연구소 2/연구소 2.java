import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static ArrayList<Node> virusList = new ArrayList<>();
	static Node[] selectedVirus;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int min = Integer.MAX_VALUE;
	static int emptySpace;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		selectedVirus = new Node[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) continue;
				if (map[i][j] == 2) 
					virusList.add(new Node(i, j, 0));
				++emptySpace;
			}
		}

		recur(0, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void recur(int cnt, int start) {
		if (cnt == M) {
			spreadVirus();
			return;
		}

		for (int i = start; i < virusList.size(); i++) {
			selectedVirus[cnt] = virusList.get(i);
			recur(cnt + 1, i + 1);
		}
	}

	static void spreadVirus() {
		int[][] copyMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			copyMap[i] = map[i].clone();
		}

		Queue<Node> q = new LinkedList<>();
		int emptySpacesLeft = emptySpace;

		for (Node n : selectedVirus) {
			copyMap[n.x][n.y] = 1;
			emptySpacesLeft--;
			q.add(n);
		}

		int time = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			time = cur.time;
			
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || copyMap[nx][ny] == 1)
					continue;

				copyMap[nx][ny] = 1;
				q.add(new Node(nx, ny, cur.time + 1));
				emptySpacesLeft--;	
			}
		}
		
		if (emptySpacesLeft == 0) {
			min = Math.min(min, time);
			return;
		}
	}

	static class Node {
		int x, y, time;

		Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
