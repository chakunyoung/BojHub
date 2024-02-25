import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int count;
    static int minCount = Integer.MAX_VALUE;
    static ArrayList<Integer> list4 = new ArrayList<>(); // 방향

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
   
        int x = Integer.parseInt(st.nextToken()); // 행
        int y = Integer.parseInt(st.nextToken()); // 열

        // 공간
        int[][] xy = new int[x][y];

        // 공간을 입력받음, 동시에 list 에 카메라 객체 저장, 카메라없을 때 count
        ArrayList<CCTV> list = new ArrayList<>();
        for(int i =0; i<xy.length; i++){
            input = br.readLine();
            st = new StringTokenizer(input);
            for(int j = 0; j<xy[i].length; j++){
                int a = Integer.parseInt(st.nextToken());
                xy[i][j] = a;
                if(xy[i][j] <= 5 && xy[i][j] >= 1)
                    list.add(new CCTV(i, j, xy[i][j]));

                if(xy[i][j] == 0){
                    count++;
                }
            }
        }
        if(count < minCount)
            minCount = count;

        //5번카메라. 공간에 설정한 후 제거
        for(int i= list.size() - 1; i>= 0; i--){
            CCTV cctv = list.get(i);
            if(cctv.getNumber() == 5){
                make9(1, xy, cctv);
                make9(2, xy, cctv);
                make9(3, xy, cctv);
                make9(4, xy, cctv);
                list.remove(cctv);
            }
        }

        int[][] map = new int[x][y];
        int a= -1;
        while(a++ < 10)
            list4.add(0);

        BT(list.size(), 0, map, list, xy);
        System.out.println(minCount);
    }//main 끝

    // 백트래킹
    public static void BT(int size, int k, int map[][], ArrayList list, int xy[][]) { // cctv 갯수, 현재 자리수, 전달받은 map
        if(size == k){ // 다왔으니 count
            // 맵을 먼저 초기화.
            for(int kkk =0; kkk<xy.length; kkk++){
                for( int jj =0; jj<xy[kkk].length; jj++) {
                    map[kkk][jj] = xy[kkk][jj];
                }
            }

            // 1. 카메라 type list
            // 2. 회전 방향 list 
            while(k-- > 0) {
                CCTV cctv = (CCTV) list.get(k); //cctv 인스턴스 하나

                int cctvtype = cctv.getNumber(); // 카메라 종류
                int i = list4.get(k); // 카메라 방향 // 1 상, 2 우, 3 하, 4 좌

                if (cctvtype == 1) {
                    make9(i, map, cctv);
                }
                if (cctvtype == 3) { // 2방향 
                    int ii3 = i + 1;
                    if (ii3 >= 5) {
                        ii3 -= 4;
                    }
                    make9(i, map, cctv);
                    make9(ii3, map, cctv);

                }
                if (cctvtype == 4) { // 3방향
                    int ii4 = i + 1;
                    if (ii4 >= 5)
                        ii4 -= 4;
                    int iii4 = i + 2;
                    if (iii4 >= 5)
                        iii4 -= 4;
                    make9(i, map, cctv);
                    make9(ii4, map, cctv);
                    make9(iii4, map, cctv);

                }
                if (cctvtype == 2) { // 양쪽
                    int iii2 = i + 2;
                    if (iii2 >= 5)
                        iii2 -= 4;
                    make9(i, map, cctv);
                    make9(iii2, map, cctv);
                }
            }
            count = 0;
            for(int j =0; j<map.length; j++){
                for(int kk = 0; kk<map[j].length; kk++){
                    if(map[j][kk] == 0){
                        count++;
                    }
                }
            }
            if(count < minCount)
                minCount = count;
            return; // 함수종료.
        }

        // 방향 list
        for(int i = 1; i<=4; i++){
            list4.set(k, i);
            BT(size, k+1, map, list, xy); // 다음 자리수로
        }
    }

    // 상하좌우 다 확인하고, 0을 9로 만드는 함수
    public static int[][] make9(int n, int[][] xy, CCTV cctv){ // 1 상, 2 우, 3 하, 4 좌
        if(n == 1){ // 상
            for(int i = cctv.getX(); i >= 0; i--){
                if(xy[i][cctv.getY()] == 6)
                    break;
                if(xy[i][cctv.getY()] == 0) {
                    xy[i][cctv.getY()] = 9;
                }
            }
        }
        if(n == 3){ // 하
            for(int i = cctv.getX(); i < xy.length; i++){
                if(xy[i][cctv.getY()] == 6)
                    break;
                if(xy[i][cctv.getY()] == 0) {
                    xy[i][cctv.getY()] = 9;
                }
            }
        }
        if(n == 4){ // 좌
            for(int i = cctv.getY(); i >= 0 ; i--){
                if(xy[cctv.getX()][i] == 6)
                    break;
                if(xy[cctv.getX()][i] == 0) {
                    xy[cctv.getX()][i] = 9;
                }
            }

        }
        if(n == 2){ // 우
            for(int i = cctv.getY(); i <xy[cctv.getX()].length ; i++){
                if(xy[cctv.getX()][i] == 6)
                    break;
                if(xy[cctv.getX()][i] == 0) {
                    xy[cctv.getX()][i] = 9;
                }
            }
        }
        return xy;
    }
}


class CCTV{ // CCTV 위치, type 객체
    private int x;
    private int y;
    private int number;

    CCTV(int x, int y, int number){
        this.x = x;
        this.y = y;
        this.number = number;
    }

    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }
    public int getNumber(){
        return number;
    }

    @Override
    public String toString() {
        return "CCTV{" +
                "x=" + x +
                ", y=" + y +
                ", number=" + number +
                '}';
    }
}
