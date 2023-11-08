import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int[][] Sarr;
    static int low;
    static int col;
    static int maxSafe = 0;
    static List<Node3> viruses = new ArrayList<>();

    //StringTokenizer
    //br.readLine()
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        low = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        Sarr = new int[low][col];


        int low2 = low;
        int arrC = 0;
        while(low2 -- > 0){
            StringTokenizer strs = new StringTokenizer(br.readLine(), " ");
            int colC= 0 ;
            while(strs.hasMoreTokens()){
                int n = Integer.parseInt(strs.nextToken());
                if(n == 2)
                    viruses.add(new Node3(arrC, colC));
                Sarr[arrC][colC++] = n;
            }
            arrC++;
        }

        // 3중 포문으로 바이러스 벽 세우고
        for(int i = 0; i < low * col -1; i++){
            for(int j = i + 1; j < low*col; j++ ){
                for(int k = j + 1; k<low*col; k++){
                    int[][] newArr = wall(i, j, k);
                    // 지정위치만 bfs
                    if(newArr[0][0] != 99)
                        bfs(newArr); // 새로 제공받아서 전체적용이 안댄다.
                }
            }
        }
        System.out.println(maxSafe);
        // 바이러스의 시작위치만 q를 돌린다.
    }
    public static void bfs(int[][] arr){
        Queue<Node3> q = new LinkedList<>();
        for(Node3 n3: viruses){
            q.offer(n3);
        }
        // bfs 로 감염시키기
        int[] xrange = {1, -1 ,0 ,0};
        int[] yrange = {0, 0, 1, -1};

        while(!q.isEmpty()){
            Node3 n = q.poll();
            for(int i = 0; i<4; i++){
                int x = n.x + xrange[i];
                int y = n.y + yrange[i];
                if(x >= 0 && x <low && y>=0 && y<col){
                    if(arr[x][y] == 0){
                        arr[x][y] = 2; //감염
                        q.offer(new Node3(x,y));
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0 ;i<low; i++){
            for(int j = 0; j<col; j++) {
                if(arr[i][j] == 0)
                    count++;
            }
        }

        if(count > maxSafe){
            maxSafe = count;
        }
    }

    // 벽세우기
    // 벽을 무조건 다 세워야함
    public static int[][] wall(int wall1, int wall2, int wall3){
        int used = 0;

        Node3 n1 = wallPoint(wall1);
        Node3 n2 = wallPoint(wall2);
        Node3 n3 = wallPoint(wall3);

        int[][] newArr = new int[low][col];
        for(int i = 0; i<low; i++){
            for(int j=0; j<col; j++){
                if(n1.x == i && n1.y == j && Sarr[i][j] == 0) {
                    newArr[i][j] = 1;
                    used++;
                }
                else if(n2.x == i && n2.y == j && Sarr[i][j] == 0) {
                    newArr[i][j] = 1;
                    used++;
                }
                else if(n3.x == i && n3.y == j && Sarr[i][j] == 0) {
                    newArr[i][j] = 1;
                    used++;
                }
                else
                    newArr[i][j] = Sarr[i][j];
            }
        }
        if(used == 3)
            return newArr;
        else {
            newArr[0][0] = 99; // false
            return newArr;
        }
    }

    public static Node3 wallPoint(int wall){
        int wx = wall / col;
        int wy = wall % col;
        return new Node3(wx, wy);
    }
}

class Node3{
    int x;
    int y;

    public Node3(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        return x + " " + y;
    }
}