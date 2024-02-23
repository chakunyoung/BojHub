import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[size];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int ele : arr) {
            int s = lower_bound(ele);

            if (list.size() <= s) {
                list.add(ele);
            } else {
                list.set(s, ele);
            }
            //System.out.println(list);
        }
        System.out.println(list.size());

    }

    static int lower_bound(int n) {
        int s = 0;
        int e = list.size() - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            int num = list.get(mid);

            if (num < n) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return s;
    }
}