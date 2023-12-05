import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int A;
    static int B;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //int N = Integer.parseInt(br.readLine());
        StringTokenizer st; // = new StringTokenizer(br.readLine());
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 그래프 number
        int B = Integer.parseInt(st.nextToken()); // 간선 number
        int start = Integer.parseInt(st.nextToken());
        visit = new boolean[A+1];

        for(int i = 0; i<=A; i++){ // 0번은 사용 안함.
            list.add(new ArrayList<Integer>()); //
        }

        StringTokenizer stt;
        while(B-- >0){
            stt = new StringTokenizer(br.readLine());
            int startNumber = Integer.parseInt(stt.nextToken());
            int arrive = Integer.parseInt(stt.nextToken());
            list.get(startNumber).add(arrive);
            list.get(arrive).add(startNumber);
        }
        for(int k = 0; k<list.size(); k++){
            ArrayList<Integer> list1 = list.get(k);
            Collections.sort(list1);
        }

        dfs(start);
        Arrays.fill(visit, false);
        System.out.println();
        bfs(start);


    }public static void dfs(int start){
        System.out.print(start + " ");
        visit[start] = true;
        ArrayList<Integer> l = list.get(start);
        for(int i =0; i<l.size(); i++){
            int number = l.get(i);
            if(!visit[number])
                dfs(number);
        }
    }

    public static void bfs(int start){
        System.out.print(start + " ");
        q.add(start);
        visit[start] = true;
        while(!q.isEmpty()){
            int numberidx = q.poll();
            for(int i = 0; i<list.get(numberidx).size(); i++){
                int number = list.get(numberidx).get(i);
                    if(!visit[number]){
                    System.out.print(number+" ");
                    q.add(number);
                    visit[number] = true;
                }
            }
        }
    }
}

