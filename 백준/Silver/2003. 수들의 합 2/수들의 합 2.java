import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[size];
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        long sum = 0L;
        int ans = 0;

        while (e != size) {
            sum += arr[e];
            while (sum > t && s < e) {
                sum -= arr[s];
                ++s;
            }
            if (sum == t) {
                ++ans;
            }
            ++e;
        }
        System.out.println(ans);
    }
}