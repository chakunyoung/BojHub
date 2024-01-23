import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] arr = new int[26];
        int k = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int s = 0;
        int e = 0;
        int ans = 0;
        int len = 0;

        while (e != str.length()) {
            int cs = str.charAt(s) - 'a';
            int ce = str.charAt(e) - 'a';

            if (k > 0) {
                if (arr[ce] == 0) {
                    k--;
                }
                arr[ce]++;
                len++;
                e++;
            } else {
                if (arr[ce] > 0) {
                    arr[ce]++;
                    len++;
                    e++;
                } else {
                    arr[cs]--;
                    if (arr[cs] == 0) {
                        k++;
                    }
                    len--;
                    s++;
                }
            }
            ans = Math.max(ans, len);
        }
        System.out.println(ans);
    }
}