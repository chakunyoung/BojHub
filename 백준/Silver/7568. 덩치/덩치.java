import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        //int N = Integer.parseInt(br.readLine()); // 정수로 입력받을 때
        N = Integer.parseInt(br.readLine()); // 정수로 입력받을 때
        int[] weight = new int[N];
        int[] height = new int[N];
        int[] rank = new int[N];
        Arrays.fill(rank, N);
        for(int k = 0; k<N; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            weight[k] = Integer.parseInt(st.nextToken());
            height[k] = Integer.parseInt(st.nextToken());
        }
        int w = 0;
        int h = 0;
        for(int i=0; i<N; i++){
            w = weight[i];
            h = height[i];
            for(int j = 0; j<N; j++){
                if(i == j)
                    continue;
                if(w >= weight[j] || h >= height[j]) // 둘중하나 걸리면 뺌. 둘다 못이겼을 때가 안빠짐. // 같으면? 공동1등ㅇ 되야하니까 빼는게 맞음.
                    rank[i]--;
            }
        }

        int idx = 0;
        for(int a : rank)
            System.out.print(rank[idx++] + " ");


    }
}// end class

