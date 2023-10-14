import java.util.*;
import java.io.*;

class Main {

    static int[] temp;
    static String[] str;
    static boolean[] v;

    static long maxNum = Long.MIN_VALUE;
    static long minNum = Long.MAX_VALUE;

    static List<String> list = new ArrayList<>();

    static StringBuilder sb1 = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        str = new String[size];
        temp = new int[size + 1];
        v = new boolean[10];

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while(st.hasMoreTokens()){
            str[idx++] = st.nextToken();
        }

        for(int i = 0; i<=9; i++) {
            temp[0] = i;
            v[i] = true;
            recur(size + 1, 1, i);
            v[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    public static void recur(int limit, int n, int prev){
        if(limit == n){
            for(int ele : temp)
                sb1.append(ele);
            list.add(sb1.toString());
            sb1.setLength(0);
            return;
        }

        for(int i = 0; i<=9; i++){
            if(v[i]) continue;

            v[i] = true;
            if(str[n - 1].equals("<") && i > prev){
                temp[n] = i;
                recur(limit, n + 1, i);
            }else if (str[n - 1].equals(">") && i < prev){
                temp[n] = i;
                recur(limit, n + 1, i);
            }
            v[i] = false;
        }
    }
}