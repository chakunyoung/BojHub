import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

// 문제 풀이 용도
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int nn = Integer.parseInt(br.readLine());

        int[] fibo = new int[100];
        fibo[0] = 0;
        fibo[1] = 1;

        for(int i=2; i<fibo.length; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        System.out.println(fibo[nn]);



    }
}