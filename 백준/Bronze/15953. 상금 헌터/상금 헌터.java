import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        int[] p1 = {5000000, 3000000, 2000000, 500000, 300000, 100000};
        int[] r1 = {1, 2, 3, 4, 5, 6};

        int[] p2 = {5120000, 2560000, 1280000, 640000, 320000};
        int[] r2 = {1, 2, 4, 8, 16};

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            int t = 0;
            int idx = 0;
            int ans1 = 0;
            while (m1 > 0) {
                if (m1 >= 22)
                    break;

                ans1 = p1[idx];
                m1 -= r1[idx];
                idx++;
                if (idx >= p1.length)
                    break;
            }
            t += ans1;

            idx = 0;
            ans1 = 0;
            while (m2 > 0) {
                if (m2 >= 32)
                    break;

                ans1 = p2[idx];
                m2 -= r2[idx];
                idx++;
                if (idx >= p2.length)
                    break;
            }
            t += ans1;
            sb.append(t).append("\n");
        }
        System.out.println(sb);


    }
}
