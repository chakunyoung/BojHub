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

        int n = Integer.parseInt(br.readLine());

        for(int i =0; i<n; i++){
            for(int j = 0; j < n-i-1 ; j++){
                sb.append(" ");
            }
            for(int k = 0; k < (i+1)*2-1; k++){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}