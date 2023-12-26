import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Sol> w = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            w.add(new Sol(Integer.parseInt(st.nextToken()), 
                                  Integer.parseInt(st.nextToken()), 
                                  Integer.parseInt(st.nextToken())));
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int s = w.get(i).s;
                    int d = w.get(j).d;
                    int intel = w.get(k).i;
                    int count = 0;

                    for (Sol q : w) {
                        if (q.s <= s && q.d <= d && q.i <= intel) {
                            count++;
                        }
                    }

                    if (count >= K) {
                        ans = Math.min(ans, s + d + intel);
                    }
                }
            }
        }

        System.out.println(ans);
    }
    
    static class Sol {
        int s, d, i;

        Sol(int s, int d, int i) {
            this.s = s;
            this.d = d;
            this.i = i;
        }
    }
    
}
