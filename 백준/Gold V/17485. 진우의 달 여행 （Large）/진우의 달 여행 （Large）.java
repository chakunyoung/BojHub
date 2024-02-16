import java.io.*;
import java.util.*;

public class Main {

    static int[][][] memo;
    static int[][] arr;
    static int[] dx = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        arr = new int[row][col];
        memo = new int[row][col][3];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++)
                Arrays.fill(memo[i][j], -1);
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE >> 1;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < 3; j++) {
                min = Math.min(min, recur(0, i, j));
            }
        }
        System.out.println(min);
    }

    public static int recur(int n, int prevCol, int prevDir) {
        if (n == arr.length) {
            return 0;
        }

        if (memo[n][prevCol][prevDir] != -1) {
            return memo[n][prevCol][prevDir];
        }

        int r = Integer.MAX_VALUE >> 1;
        for (int i = 0; i < 3; i++) {
            if (i == prevDir) continue;
            if (prevCol + dx[i] < 0 || prevCol + dx[i] >= arr[0].length) continue;
            r = Math.min(r, recur(n + 1, prevCol + dx[i], i) + arr[n][prevCol]);
        }
        return memo[n][prevCol][prevDir] = r;
    }
}