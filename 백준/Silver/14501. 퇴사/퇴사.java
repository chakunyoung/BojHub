import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        arr = new int[size][2];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(recur(0, size, 0));
    }

    static int recur(int n, int size, int value) {
        if (n > size)
            return Integer.MIN_VALUE >> 1;

        if (n == size) {
            return value;
        }

        int day = arr[n][0];
        int v = arr[n][1];

        return Math.max(recur(n + day, size, value + v),
                recur(n + 1, size, value));
    }
}