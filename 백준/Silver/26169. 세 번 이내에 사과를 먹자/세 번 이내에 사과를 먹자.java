import java.io.*;
import java.util.*;

public class Main {

    static int[] xdir = {1, -1, 0, 0};
    static int[] ydir = {0, 0, 1, -1};
    static int[][] arr = new int[5][5];
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] loc = new int[2];
        loc[0] = Integer.parseInt(st.nextToken());
        loc[1] = Integer.parseInt(st.nextToken());
        arr[loc[0]][loc[1]] = -1;
        dfs(loc[0], loc[1], 0, 0);
        System.out.println(ans);
    }

    public static void dfs(int x, int y, int apple, int moveCnt) {
        if (apple >= 2)
            ans = 1;
        if (moveCnt == 3) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int dx = xdir[i] + x;
            int dy = ydir[i] + y;

            if (dx >= 0 && dx < 5 && dy >= 0 && dy < 5) {
                if (arr[dx][dy] == 1) {
                    arr[dx][dy] = -1;
                    dfs(dx, dy, apple + 1, moveCnt + 1);
                    arr[dx][dy] = 1;
                } else if (arr[dx][dy] == 0) {
                    arr[dx][dy] = -1;
                    dfs(dx, dy, apple, moveCnt + 1);
                    arr[dx][dy] = 0;
                }
            }
        }
    }
}