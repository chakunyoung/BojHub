import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[size];

            for (int j = 0; j < size; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(bs(arr)).append("\n");
        }
        System.out.println(sb);
    }

    public static int bs(int[] arr) {
        int ans = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            loop:
            for (int j = i + 1; j < arr.length; j++) {
                int gap = arr[j] - arr[i];

                int s = j;
                int e = arr.length - 1;

                while (s <= e) {
                    int mid = (s + e) / 2;

                    int ele = arr[mid] - arr[j];

                    if (ele == gap) {
                        ans++;
                        continue loop;
                    } else if (ele < gap) {
                        s = mid + 1;
                    } else {
                        e = mid - 1;
                    }
                }
            }
        }
        return ans;
    }
}
