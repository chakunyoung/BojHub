import java.util.*;
import java.io.*;

class Main {

    static int count;
    static int[] arr;
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        arr = new int[n];
        v = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        v[0] = true;
        recur(0, sum);
        System.out.println(count);
    }

    public static void recur(int n, int target) {
        if (n == arr.length){
            int sum = 0;
            int c = 0;
            for(int i = 0; i<arr.length; i++){
                if(v[i]) {
                    sum += arr[i];
                    c++;
                }
            }
            if(target == sum && c >= 1)
                count++;

            return;
        }

        v[n] = true;
        recur(n + 1, target);
        v[n] = false;
        recur(n + 1, target);
    }
}