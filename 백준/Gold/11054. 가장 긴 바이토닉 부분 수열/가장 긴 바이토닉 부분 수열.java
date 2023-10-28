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

        int[] arr = new int[n];
        int[] Rdp = new int[n];
        int[] Ldp = new int[n];

        Arrays.fill(Rdp, 1);
        Arrays.fill(Ldp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(arr[i] > arr[j])
                    Rdp[i] = Math.max(Rdp[i] , Rdp[j] + 1);
            }
        }

        for(int i = n-1; i>=0; i--){
            for(int j = n-1; j > i; j--){
                if(arr[i] > arr[j])
                    Ldp[i] = Math.max(Ldp[i] , Ldp[j] + 1);
            }
        }

        int[] dp = new int[n];
        for(int i = 0; i<n; i++){
            dp[i] = Rdp[i] + Ldp[i] - 1;
        }

        int max = 0;
        for(int i = 0; i< dp.length; i++){
            if(max < dp[i])
                max = dp[i];
        }
        System.out.println(max);

    }
}

