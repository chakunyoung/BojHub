import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] graph;

    static Queue<Node> q = new LinkedList<>();
    static int low, col;
    static int minimumMove = Integer.MAX_VALUE;

    static int[] xRange = {1, -1, 0, 0};
    static int[] yRange = {0, 0, 1, -1};

    //StringTokenizer
    //br.readLine()
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        //int numberCount = Integer.parseInt(st.nextToken());

        low = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        graph = new int[low][col];

        for(int i = 0; i< graph.length; i++){
            String str = br.readLine();
            int idx = 0;
            for(int j =0; j< graph[i].length; j++){
                int ele = Integer.parseInt(str.charAt(idx) +"");
                graph[i][j] = ele;
                idx++;
            }
        }


        System.out.println(bfs());

//        for(int i = 0; i<graph.length;i ++){
//            for(int j =0; j<graph[0].length; j++){
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 큐로 벽의 위치를 저장
        // 큐에서 하나 꺼내서 그 부분을 0으로 만들고 bfs
        // bfs 끝나면 다시 1로 만듬


    }

    //
    public static int bfs(){
        int dis = 0;
        q.add(new Node(0, 0, false, 1));
        graph[0][0] = 2;

        int[] xRange = {1, -1, 0, 0};
        int[] yRange = {0, 0, 1, -1};

        while(!q.isEmpty()){
            Node node = q.poll();
            dis = node.dis;
            if(node.x == graph.length - 1 && node.y == graph[0].length -1)
                return dis;

            for(int i = 0; i<4; i++){
                int x = xRange[i] + node.x;
                int y = yRange[i] + node.y;
                if(x >= 0 && x<low && y>=0 && y <col){
                    int disn = node.dis + 1;

                    if(graph[x][y] != 3){ // 벽뚫 x 가 지나간 자리 다시볼필요없다.

                        if(node.state){ // 벽뚫 o
                            if(graph[x][y] == 1 && graph[x][y] == 2)  // 또 벽이면 또 뚫기 불가능. // 이미 벽뚫o 가 지나간자리 볼필요없음
                                continue;
                            if(graph[x][y] == 0) {
                                q.offer(new Node(x, y, node.state, disn));
                                graph[x][y] = 2; // 벽뚫o 가 지나간 자리. // 벽뚫x 가 이용가능하다.
                            }

                        }else{ // 벽뚫 x
                            if(graph[x][y] == 0){
                                q.offer(new Node(x, y, node.state, disn));
                                graph[x][y] = 3; // 가장빠른 벽뚫x 가 사용한자리 다시사용할 필요 없다.
                            }
                            else if(graph[x][y] == 2){
                                q.offer(new Node(x, y, node.state, disn));
                                graph[x][y] = 3; // 가장 빠른 벽뚫x 가 벽뚫 o 가 지나간자리를 다시 밟은 자리 다시볼필요 x
                            }
                            else if(graph[x][y] == 1){ // 벽을 뚫는다.
                                q.offer(new Node(x, y, true, disn));
                                graph[x][y] = 3; // 가장 빠른 벽뚫x가 한번 뚫은자리 다시볼필요 없다.

                            }



                        }
                    }
                }
            }
        }
        return -1;
    }
}

class Node{
    int x;
    int y;
    boolean state; // 벽
    int dis;
    Node(int x, int y, boolean state, int dis){
        this.x = x;
        this.y = y;
        this.state = state;
        this.dis = dis;
    }

    public String toString(){
        return x + " " + y;
    }
}