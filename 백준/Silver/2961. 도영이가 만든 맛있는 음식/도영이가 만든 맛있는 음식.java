import java.util.*;
import java.io.*;

class Main {
    static int minv = Integer.MAX_VALUE;
    static List<Node> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        recur(0, size, 1, 0, 0);
        System.out.println(minv);
    }

    public static void recur(int n, int limit, int s, int ss, int count) {
        if (n == limit) {
            if(count == 0)
                return;
            minv = Math.min(minv, Math.abs(s - ss));
            return;
        }

        recur(n + 1, limit, s, ss, count);
        recur(n + 1, limit, list.get(n).s * s, list.get(n).ss + ss, count + 1);
    }

    static class Node {
        int s, ss;

        public Node(int s, int ss) {
            this.s = s;
            this.ss = ss;
        }
    }
}