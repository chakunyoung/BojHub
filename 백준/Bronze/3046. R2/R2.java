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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int avg = Integer.parseInt(st.nextToken());

        int n2 = avg * 2 - n1;

        System.out.println(n2);





    }
}