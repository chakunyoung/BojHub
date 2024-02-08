import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if(num <= 2){
                sb.append(2).append("\n");
                continue;
            }
            
            while (!isPrime(num)) {
                num++;
            }
            sb.append(num).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean isPrime(long number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}