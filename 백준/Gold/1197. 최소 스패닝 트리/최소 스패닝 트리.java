import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int u, v, w;
    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    public int compareTo(Edge e) {
        return this.w - e.w;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parent;
    
    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int u, int v) {
    	if(u < v)
    		parent[u] = v;
    	else
    		parent[v] = u;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int eCount = Integer.parseInt(st.nextToken());
        int vCount = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        parent = new int[eCount + 1];
        
        for (int i = 1; i <= eCount; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < vCount; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(u, v, w));
        }

        int mstWeight = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.u) != find(edge.v)) {
                union(find(edge.u), find(edge.v));
                mstWeight += edge.w;
            }
        }

        System.out.println(mstWeight);
    }
}
