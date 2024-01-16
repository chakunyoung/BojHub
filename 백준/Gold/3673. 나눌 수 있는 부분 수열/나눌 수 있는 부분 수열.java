import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int div = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] mod = new int[div];
            mod[0] = 1;
            long sum = 0;
            long count = 0;

            while (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                sum += n;
                count += mod[(int) (sum % div)];
                ++mod[(int) (sum % div)];

            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}