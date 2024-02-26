import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Map<String, String> m = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            m.put(st.nextToken(), st.nextToken());
        }
        for (int i = 0; i < q; i++) {
            sb.append(m.get(br.readLine())).append("\n");
        }
        System.out.println(sb);


    }
}