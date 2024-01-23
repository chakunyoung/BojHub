import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());

        long[][] arr = new long[4][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Long.parseLong(st.nextToken());
            }
        }

        long[] list1 = new long[size * size];
        long[] list2 = new long[size * size];

        int idx = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                list1[idx] = arr[0][i] + arr[1][j];
                list2[idx] = arr[2][i] + arr[3][j];
                idx++;
            }
        }

        Arrays.sort(list1);
        Arrays.sort(list2);

        int s = 0;
        int e = list2.length - 1;
        long count = 0;

        while (true) {
            if (s == list2.length || e == -1) {
                break;
            }
            long sum = list1[s] + list2[e];
            if (sum < 0) {
                s++;
            } else if (sum > 0) {
                e--;
            } else {
                long cnt1 = 1;
                long cnt2 = 1;
                while (s + 1 < list1.length && list1[s] == list1[s + 1]) {
                    cnt1++;
                    s++;
                }
                while (e - 1 >= 0 && list2[e] == list2[e - 1]) {
                    cnt2++;
                    e--;
                }
                count += cnt1 * cnt2;
                s++;
                e--;
            }
        }
        System.out.println(count);
    }
}