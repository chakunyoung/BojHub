import java.io.*;
import java.util.*;

public class Main {

    static int day;
    static int[][][] memo;
    static int[] days;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        day = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());

        days = new int[day + 1];
        memo = new int[day + 1][4][4];

        for (int[][] m2 : memo)
            for (int[] m1 : m2)
                Arrays.fill(m1, -1);

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            days[n - 1] = f;
        }
        System.out.println(recur(0, 0, 0));
    }

    static int recur(int n, int prev1, int prev2) {
        if (prev1 == prev2 && prev2 == days[n] && days[n] != 0) {
            return 0;
        }

        if (n == day) {
            return 1;
        }

        if (memo[n][prev1][prev2] != -1) {
            return memo[n][prev1][prev2];
        }

        int count = 0;

        if (days[n] != 0) {
            count += (recur(n + 1, prev2, days[n]) % 10000);
        } else {
            for (int i = 1; i <= 3; i++) {
                if (prev1 == prev2 && prev2 == i) {
                    continue;
                }
                count += (recur(n + 1, prev2, i) % 10000);
            }
        }
        return memo[n][prev1][prev2] = count % 10000;
    }
}