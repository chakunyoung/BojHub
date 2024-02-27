import java.io.*;
import java.util.*;

public class Main {

    static int size;
    static boolean[] v;
    static int arr[];
    static int temp[];
    static int k;
    static Set<String> s = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        size = Integer.parseInt(br.readLine());
        v = new boolean[size];
        temp = new int[size];
        k = Integer.parseInt(br.readLine());
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        recur(0);

        System.out.println(s.size());
    }

    static void recur(int n) {
        if (n == k) {
            for (int m : temp)
                sb.append(m);

            s.add(sb.toString());
            sb.setLength(0);
            return;
        }

        for (int i = 0; i < size; i++) {
            if (v[i]) continue;

            v[i] = true;
            temp[n] = arr[i];
            recur(n + 1);
            v[i] = false;
        }

    }
}
