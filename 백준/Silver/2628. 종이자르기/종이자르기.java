import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());

        int size = Integer.parseInt(br.readLine());

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        xList.add(0);
        yList.add(0);

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            if (o == 0) {
                xList.add(Integer.parseInt(st.nextToken()));
            } else {
                yList.add(Integer.parseInt(st.nextToken()));
            }
        }
        xList.add(sx);
        yList.add(sy);
        Collections.sort(xList);
        Collections.sort(yList);

        int ans = 0;
        for (int i = 0; i < xList.size() - 1; i++) {
            for (int j = 0; j < yList.size() - 1; j++) {
                int xgap = xList.get(i) - xList.get(i + 1);
                int ygap = yList.get(j) - yList.get(j + 1);

                ans = Math.max(ans, Math.abs(xgap) * Math.abs(ygap));
            }
        }
        System.out.println(ans);
    }
}