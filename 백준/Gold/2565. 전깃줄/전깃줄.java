import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();


    //StringTokenizer
    //br.readLine()
    public static void main(String[] args) throws IOException {
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int[] lines = new int[501];
        int[] dp = new int[501]; // 걸리적거리는거 count 제일큰걸 없애줄거임 // 이게 전부 0이면 종료

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            lines[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<lines.length; i++){
            for(int j = 0; j<i; j++){

                if(lines[i] > lines[j])
                    dp[i] = Math.max(dp[i],  dp[j] + 1);

            }
        }



        int max = 0;
        for(int i = 0; i<dp.length; i++){
            if(max < dp[i])
                max = dp[i];
        }
        System.out.println(n - max);
    }
}

