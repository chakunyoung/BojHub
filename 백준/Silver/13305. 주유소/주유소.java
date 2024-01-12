import java.io.*;
import java.math.BigInteger; // subtract , multiply, add, mod
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] temp;
    static int globalMin = Integer.MAX_VALUE;
    static int globalMax = Integer.MIN_VALUE;
    static int[] su;

    public static void main(String[] args) throws IOException {

        // 입력부
        int town = Integer.parseInt(br.readLine());
        int[] towns = new int[town];
        int[] dist = new int[town-1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<dist.length; i++)
            dist[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i <towns.length; i++)
            towns[i] = Integer.parseInt(st.nextToken());

        // 후불로 사면되잖아
        long total = 0;
        int nowMove = dist[0];
        int nowLiter = towns[0];
        for(int i = 1; i<towns.length;i ++){
            if(towns[i] < nowLiter){
                //오 싸다 바꿔. // 여기온 비용은 내야지
                total += (long)dist[i-1] * nowLiter;
                nowLiter = towns[i];
                nowMove = towns[i];
            }else{ // 타운이 비싸 이전에서 더사
                total += (long)dist[i-1] * nowLiter;
            }



        }
        System.out.println(total);


    }
}