import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

// 문제 풀이 용도
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[][] arr;
    static int arrSize;

    public static void main(String[] args) throws IOException {

        int count = Integer.parseInt(br.readLine());

        while(count-->0){
            arrSize = Integer.parseInt(br.readLine());
            arr = new int[arrSize][arrSize];
            StringTokenizer st = new StringTokenizer(br.readLine());
            Night startNight = new Night(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            Night targetNight = new Night(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            sb.append(nightControl(startNight, targetNight)).append("\n");
        }

        System.out.println(sb.toString());

    }

    public static int nightControl(Night startNight, Night targetNight){
        Queue<Night> q = new LinkedList<>();
        q.offer(startNight);

        while(!q.isEmpty()){
            Night nightPoll = q.poll();

            if(nightPoll.x == targetNight.x && nightPoll.y == targetNight.y){
                return nightPoll.moveCount;
            }

            int[] xRange = {-2, -1, 1, 2, 2, 1, -1, -2};  // 1시부터 시계방향
            int[] yRange = {1, 2, 2, 1, -1, -2, -2, -1};

            for(int i = 0; i<8; i++){
                int x = nightPoll.x + xRange[i];
                int y = nightPoll.y + yRange[i];

                if(x>=0 && arrSize > x && y>=0 && arrSize> y && arr[x][y] != 5){
                    arr[x][y] = 5;
                    Night n1 = new Night(x, y);
                    n1.moveCount = nightPoll.moveCount + 1;
                    q.offer(n1);
                }

            }




        }




        return 0;

    }
}

class Night{
    int x;
    int y;
    int moveCount;
    public Night(int x, int y){
        this.x = x;
        this.y = y;
        this.moveCount = 0;
    }

    @Override
    public String toString() {
        return "Night{" +
                "x=" + x +
                ", y=" + y +
                ", moveCount=" + moveCount +
                '}';
    }
}