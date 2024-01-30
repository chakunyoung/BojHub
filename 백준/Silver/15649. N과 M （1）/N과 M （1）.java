import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// 문제 풀이 용도
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] arr;
    static int[] tmp;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numberLimit = Integer.parseInt(st.nextToken());
        int jari = Integer.parseInt(st.nextToken());
        v = new boolean[numberLimit];
        arr = new int[numberLimit];
        for(int i = 0; i<numberLimit; i++)
            arr[i] = i+1;

        tmp = new int[jari];

        su(jari, 0);
        System.out.println(sb);
    }

    public static void su(int limit, int idx){
        if (limit == idx){
            for(int n : tmp){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }


        for(int i = 0; i<arr.length; i++){
            if(!v[i]) {
                v[i] = true;
                tmp[idx] = arr[i];
                su(limit, idx + 1);
                v[i] = false;
            }
        }
    }
}