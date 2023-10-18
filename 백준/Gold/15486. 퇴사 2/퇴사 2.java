import java.util.*;
import java.io.*;

class Main {

    static Node[] arr;
    static int[] memo;
    static int day;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        day = Integer.parseInt(br.readLine());
        arr = new Node[day];
        memo = new int[day + 1];

        for (int i = 0; i < day; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i] = new Node(t, p);
        }

        for (int i = 0; i < day; i++) {
            // 고르지 않음
            if (i + 1 <= day) {
                memo[i + 1] = Math.max(memo[i + 1], memo[i]);
            }

            // 고름
            if (i + arr[i].t <= day) {
                memo[i + arr[i].t] = Math.max(memo[i + arr[i].t], memo[i] + arr[i].p);
            }
        }

        System.out.println(memo[day]);
    }

    static class Node {
        int t, p;

        public Node(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }
}
