import java.io.*;
import java.util.*;

public class Main {

    static List<List<Node>> list = new ArrayList<>();
    static int[] dist;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
        return o1.w - o2.w;
    });

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken()) + 1;
        int limit = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        dist = new int[size];

        List<Integer> items = new ArrayList<>();
        items.add(0);
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens())
            items.add(Integer.parseInt(st.nextToken()));

        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, w));
            list.get(e).add(new Node(s, w));
        }

        int max = -1;
        for (int i = 1; i < size; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;

            dijk(i);

            int totalItems = 0;
            for (int j = 1; j < size; j++) {
                if (dist[j] <= limit)
                    totalItems += items.get(j);
            }
            max = Math.max(max, totalItems);
        }
        System.out.println(max);


    }

    static void dijk(int s) {
        pq.offer(new Node(s, 0));
        while (!pq.isEmpty()) {
            Node mid = pq.poll();

            if (dist[mid.dest] < mid.w)
                continue;

            List<Node> l = list.get(mid.dest);
            for (Node n : l) {
                int f = dist[mid.dest] + n.w;
                if (f < dist[n.dest]) {
                    dist[n.dest] = f;
                    pq.offer(new Node(n.dest, f));
                }
            }
        }
    }


    static class Node {
        int dest, w;

        public Node(int dest, int w) {
            this.dest = dest;
            this.w = w;
        }


    }
}