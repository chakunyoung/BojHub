import java.util.*;
import java.io.*;

class Main {

    static int[] temp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());

        temp = new int[size];
        recur(size, 0);
    }

    public static void recur(int limit, int n) {
        for (int i = 1; i <= temp.length / 2; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (n - j - 1 < 0 || n - i - j - 1 < 0)
                    break;
                if (temp[n - j - 1] == temp[n - i - j - 1]) {
                    count++;
                }
            }
            if (count == i)
                return;
        }

        if (limit == n) {
            for (int ele : temp)
                sb.append(ele);
            System.out.println(sb);
            System.exit(0);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            temp[n] = i;
            recur(limit, n + 1);
        }
    }
}