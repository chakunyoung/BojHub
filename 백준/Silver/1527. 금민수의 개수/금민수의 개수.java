import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        recur(1, 0);
        Collections.sort(list);

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (s <= num && num <= e)
                ++count;
        }
        System.out.println(count);
    }

    static void recur(int n, int value) {
        if (n >= 1_000_000_001) {
            return;
        }

        int n1 = n * 4 + value;
        int n2 = n * 7 + value;

        if (n2 < 0)
            return;

        list.add(n1);
        list.add(n2);

        recur(n * 10, n1);
        recur(n * 10, n2);
    }
}