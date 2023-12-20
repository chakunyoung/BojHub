import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //int numberCount = Integer.parseInt(st.nextToken());

        int number = Integer.parseInt(br.readLine());

        int[] arr = new int[10_000_001];
        for(int i = 0; i<arr.length; i++){
            arr[i] = i+1;
        }


        int s = -1;
        int e = -1;
        int sum = 0;
        int count = 0;

        while (s < 10_000_000){
            if(sum < number) { // sum이 현재 작다.
                e++;
                sum += arr[e];
            }

            else if(sum > number) { // sum이 현재 크다.
                s++;
                sum -= arr[s];

            }else { // 같을 경우 다음으로 e를 증가시킴
                count++;
                e++;
                sum += arr[e];
            }

            if(s > -1 && number < arr[s])
                break;

        }
        System.out.println(count);

    }
}


