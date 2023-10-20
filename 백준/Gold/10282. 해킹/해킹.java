import java.util.*;
import java.io.*;

class Main {
    static List<Edge>[] graph;
    static PriorityQueue<Edge> pq;
    static long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());

            int computers = Integer.parseInt(st.nextToken());
            int lines = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            graph = new ArrayList[computers + 1];
            for (int j = 0; j <= computers; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < lines; j++) {
                st = new StringTokenizer(br.readLine());
                int n2 = Integer.parseInt(st.nextToken());
                int n1 = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                graph[n1].add(new Edge(n2, dist));
            }

            dist = new long[computers + 1];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[start] = 0;

            dijk(start);
            
            int infectedCount = 0;
            long lastTime = 0;
            for (int j = 1; j <= computers; j++) {
                if (dist[j] != Long.MAX_VALUE) {
                    infectedCount++;
                    lastTime = Math.max(lastTime, dist[j]);
                }
            }
            System.out.println(infectedCount + " " + lastTime);
        }
    }

    static void dijk(int startNode) {
        pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1.dist, o2.dist));
        pq.offer(new Edge(startNode, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.dist > dist[cur.n2]) continue;

            for (Edge next : graph[cur.n2]) {
                if (cur.dist + next.dist < dist[next.n2]) {
                    dist[next.n2] = cur.dist + next.dist;
                    pq.offer(new Edge(next.n2, dist[next.n2]));
                }
            }
        }
    }

    static class Edge {
        int n2;
        long dist;

        public Edge(int n2, long dist) {
            this.n2 = n2;
            this.dist = dist;
        }
    }
}
