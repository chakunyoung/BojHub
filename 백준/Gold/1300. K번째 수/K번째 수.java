import java.util.*;
import java.io.*;

class Main {

    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int idx = Integer.parseInt(br.readLine());

        long ans = bs(n, idx);
        System.out.println(ans);

    }

    public static int bs(int n, int idx) {
        long s = 1;
        long e = Integer.MAX_VALUE >> 1;
        long mid = 0;
        long ans = 0;
        while (s <= e) {
            // value
            mid = (s + e) / 2;

            int temp = 0;

            for (int i = 1; i <= n; i++) {
                long innerTemp = mid / i;
                if (innerTemp >= n)
                    innerTemp = n;
                temp += innerTemp;
            }

            // temp 가 앞에 있는 수의 개수.
            if (temp >= idx) {
                e = mid - 1;
                ans = mid;
            } else {
                s = mid + 1;

            }
        }
        return (int) ans;
    }
}