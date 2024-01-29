import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] prefixP1 = new int[size / 2 + 2];
        int[] prefixP2 = new int[size / 2 + 2];

        for (int i = 1, j = 1; i < size + 1; i += 2, j++) {
            prefixP1[j] = prefixP1[j - 1] + arr[i - 1];
            prefixP2[j] = prefixP2[j - 1] + arr[i];
        }

        int max = 0;
        for (int i = 1; i < prefixP1.length - 1; i++) {
            max = Math.max(max, prefixP1[i - 1] + prefixP2[prefixP2.length - 2] - prefixP2[i - 1]);
            max = Math.max(max, prefixP1[i] + prefixP2[prefixP2.length - 2] - prefixP2[i - 1] - arr[arr.length - 1]);
        }
        System.out.println(max);
    }
}