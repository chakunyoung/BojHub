import java.util.*;
import java.io.*;

class Main {

    static int[] temp;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        temp = new int[n];
        v = new boolean[number + 1];

        recur(n, 0, number, 1);
        System.out.println(sb.toString());
    }

    public static void recur(int limit, int n, int number , int t) {
        if (n == limit) {
            for (int ele : temp)
                sb.append(ele).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = t; i <= number; i++) {
            if (v[i]) continue;
            v[i] = true;
            temp[n] = i;
            recur(limit, n + 1, number, i + 1);
            v[i] = false;
        }
    }
}