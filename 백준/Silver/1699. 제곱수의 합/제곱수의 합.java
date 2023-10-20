import java.io.*;
import java.math.BigInteger; // subtract , multiply, add, mod
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();




    public static void main(String[] args) throws IOException {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];
        Arrays.fill(dp, 1000_000);

        dp[0] = 0;
        // dp 초기화
        for(int i = 1 ; i<dp.length; i++){
            if(i * i > 100000)
                break;
            int powNumber = i * i;
            dp[powNumber] = 1;
        }

        // 1부터 100_000 까지 min을 채워나가기
        for(int i = 1 ; i<dp.length; i++){
            for(int j = 325; j >= 1; j--){
                if(j * j > i) // 기준숫자보다 제곱이 커지면 의미가 없으니 넘김
                    continue;
                int jNumber = (int)Math.pow(j, 2);
                int divide = i / jNumber;
                int rest = i % jNumber;
                if(i == 5 && j * jNumber == 4){
                    System.out.println(divide + " " +rest);
                }


                dp[i] = Math.min(dp[i], dp[rest] + divide);
            }
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(dp[number]);


    }
}