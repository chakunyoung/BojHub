import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        //int numberCount = Integer.parseInt(st.nextToken());

        int edgeCount = Integer.parseInt(st.nextToken());
        int lines = Integer.parseInt(st.nextToken());

        arr = new int[edgeCount +1];
        int idx = 1;
        for(int i = 1; i<arr.length; i++){
            arr[i] = i; // 자기자신을 갖고있다.
        }



        // 합집합은 어케 만들까. 둘이 같은 소속으로 만든다.
        // 배열로.

        while(lines -- > 0){
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int w1 = Integer.parseInt(st.nextToken());
            int w2 = Integer.parseInt(st.nextToken());

            if( o == 1){
                if(find(w1) != find(w2)){ // 같은 집합이 아님.
                    sb.append("NO").append("\n");
                }else // 같은 집합임
                    sb.append("YES").append("\n");

            }else if(o == 0){ // 합집합으로 만든다.
                union(w1, w2);
            }
        }
        System.out.println(sb);
    }
    public static int find(int n){
        if(arr[n] == n)
            return n;
        return arr[n] = find(arr[n]);
    }
    public static void union(int w1, int w2){
        w1 = find(w1);
        w2 = find(w2);

        if(w1 > w2){
            arr[w1] = w2;
        }else
            arr[w2] = w1;
    }
}


