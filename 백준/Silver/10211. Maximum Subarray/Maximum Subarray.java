import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[size];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j];
                if (sum < arr[j]) {
                    sum = arr[j];
                }
                max = Math.max(max, sum);
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);


    }
}
