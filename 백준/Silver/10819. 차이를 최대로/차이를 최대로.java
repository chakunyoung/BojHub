import java.util.*;
import java.io.*;

class Main {

    static int[] temp;
    static int[] arr;
    static boolean[] v;
    static int max = Integer.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[size];
        temp = new int[size];
        v = new boolean[size];
        for(int i = 0; i<size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recur(size, 0);
        System.out.println(max);
    }

    public static void recur(int limit, int n){
        if(limit == n){
            int sum = 0;
            for(int i = 1; i<arr.length; i++){
                sum += Math.abs(temp[i - 1] - temp[i]);
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i<temp.length; i++){
            if(v[i])
                continue;
            v[i] = true;
            temp[n] = arr[i];
            recur(limit, n + 1);
            v[i] = false;
        }
    }
}