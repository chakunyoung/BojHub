import java.io.*;
import java.util.*;

public class Main {

    static char[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new char[r][c];

        for (int i = 0; i < arr.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int xx = 0;
        int bb = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int[] s = {i, j};
                if (arr[i][j] == 'W') xx += bfs(s, arr[i][j]);
                else if (arr[i][j] == 'B') bb += bfs(s, arr[i][j]);
            }
        }
        System.out.println(xx + " " + bb);
    }

    static int bfs(int[] start, char p) {
        int c = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start[0], start[1]));
        arr[start[0]][start[1]] = 'T';

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = n.x + dx[i];
                int y = n.y + dy[i];

                if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length) {
                    if (arr[x][y] != p) continue;
                    ++c;
                    q.offer(new Node(x, y));
                    arr[x][y] = 'T';
                }
            }
        }
        return c * c;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}