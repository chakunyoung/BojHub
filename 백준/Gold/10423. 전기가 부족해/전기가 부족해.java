import java.io.*;
import java.util.*;

public class Main {
	static int[] p;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 

        p = new int[N + 1];
        for (int i = 1; i <= N; i++) 
        	p[i] = i;

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        
        while(st.hasMoreTokens()) {
            int plant = Integer.parseInt(st.nextToken());
            union(first, plant);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a, b, w});
        }

        int cost = 0;
        int nodeCount = K;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            if (find(edge[0]) != find(edge[1])) {
            	++nodeCount;
            	cost += edge[2];
                union(edge[0], edge[1]);
            }
            
            if(nodeCount == N)
            	break;
        }

        System.out.println(cost);
    }

	static int find(int x) {
		if (x == p[x])
			return x;
		return p[x] = find(p[x]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b)
			p[b] = a;
		else
			p[a] = b;
	}
}
