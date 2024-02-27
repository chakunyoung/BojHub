import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int ss = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Star> list = new ArrayList<>();
        for (int i = 0; i < ss; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Star(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        /*
            ------*--
            --------*
            *--------
            ---*-----
            인 경우 때문에 4분면 count 방식이 불가능, 교점을 이용해야함
         */

        List<Star> points = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                Star s1 = list.get(i);
                Star s2 = list.get(j);
                points.add(new Star(s1.x, s1.y));
                points.add(new Star(s1.x, s2.y));
                points.add(new Star(s2.x, s1.y));
                points.add(new Star(s2.x, s2.y));
            }
        }

        int max = 0;
        for (int i = 0; i < points.size(); i++) {
            int x = points.get(i).x;
            int y = points.get(i).y;
            long mx = points.get(i).x + r;
            long my = points.get(i).y + c;

            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                Star s = list.get(j);
                if (x <= s.x && s.x <= mx && y <= s.y && s.y <= my)
                    ++count;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    static class Star {
        int x, y;

        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
