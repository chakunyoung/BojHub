import java.io.*;
import java.util.*;

public class Main {

    static char[][] arr;
    static int count;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];

        int[] start = new int[2];

        for (int i = 0; i < arr.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        bfs(start);
        System.out.println(count == 0 ? "TT" : count);

    }

    static void bfs(int[] start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start[0], start[1]));
        arr[start[0]][start[1]] = 'X';

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = n.x + dx[i];
                int y = n.y + dy[i];

                if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length) {
                    if (arr[x][y] == 'X')
                        continue;

                    if (arr[x][y] == 'P')
                        ++count;

                    arr[x][y] = 'X';
                    q.offer(new Node(x, y));
                }
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}