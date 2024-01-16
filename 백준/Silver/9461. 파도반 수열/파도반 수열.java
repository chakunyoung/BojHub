import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int[][] house;
    static int[] numbers;
    static long[] memo = new long[101];

    public static void main(String[] args) throws IOException {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //int house = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(br.readLine());

        numbers = new int[count];
        int idx = 0;
        while(count-- >0){
            numbers[idx] = Integer.parseInt(br.readLine());
            idx++;
        }

        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 1;
        int j = 0;
        for(int k= 0; k< memo.length; k++) {
            for (int i = 3; i < 101; i++)
                memo[i] = memo[i - 3] + memo[i - 2];
        }


        for(int k = 0; k<numbers.length; k++){
            System.out.println(memo[numbers[k] -1]);
        }





        //d = d-2 + d-3
        //i=3 부터

    }
}


