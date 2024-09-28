import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static Queue<Integer> q = new LinkedList<>();
    static List<List<Integer>> list;
    static boolean[] visit;
    static int[] distance;
    static List<Integer> l = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        //int numberCount = Integer.parseInt(st.nextToken());


        int edge = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int dis = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visit = new boolean[edge + 1];
        distance = new int[edge + 1];

        list = new ArrayList<>();
        for(int i = 0; i<=edge; i++){
            list.add(new ArrayList<>());
        }

        while(v-- > 0){
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());

            list.get(e1).add(e2);
        }
        bfs(start, dis);
        
        Collections.sort(l);
        if(l.size()==0)
            System.out.println(-1);
        else{
            for(int eee : l){
                System.out.println(eee);
            }
        }
    }
    
    //거리 처리
    public static void bfs(int start, int disCount){
        q.offer(start);
        visit[start] = true;

        while(!q.isEmpty()){
            int edge = q.poll(); // 노드
            List<Integer> s = list.get(edge); // low // 해당 엣지의 거리는?
            int dis1 = distance[edge] + 1;

            for(int e : s){ // col
                if(!visit[e]) {
                    visit[e] = true;
                    q.add(e); // 도착지를 큐에 넣음
                    distance[e] = dis1;

                    if(disCount == distance[e]){
                        l.add(e);
                    }
                }
            }
        }
    }
}


