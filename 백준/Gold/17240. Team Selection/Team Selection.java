import java.io.*;
import java.util.*;

public class Main {

    static List<List<Person>> skillsOrder;
    static int[] temp = new int[5];
    static boolean[] v = new boolean[5];
    static int max = 0;
    static int size = 0;
    static boolean[] iv;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        size = n;
        iv = new boolean[size];
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            int[] skills = new int[5];
            while (st.hasMoreTokens()) {
                skills[idx++] = Integer.parseInt(st.nextToken());
            }
            list.add(new Person(i, skills));
        }

        skillsOrder = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Person> innerList = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                innerList.add(list.get(j));
            }
            final int skillsOrderIdx = i;
            Collections.sort(innerList, (o1, o2) -> {
                return o2.skills[skillsOrderIdx] - o1.skills[skillsOrderIdx];
            });
            skillsOrder.add(innerList);
        }
        //debug();
        recur(0);
        System.out.println(max);
    }

    static void innerRecur(int n, int sum) {
        if (n == 5) {
            max = Math.max(sum, max);
            return;
        }

        int order = temp[n]; // skill
        List<Person> iList = skillsOrder.get(order);

        for (int j = 0; j < iList.size(); j++) {
            if (!iv[iList.get(j).id]) {
                iv[iList.get(j).id] = true;
                innerRecur(n + 1, sum + iList.get(j).skills[order]);
                iv[iList.get(j).id] = false;
                break;
            }
        }
    }

    static void recur(int n) {
        if (n == 5) {
            // temp 순서로 우선 순위 설정,
            // 5! 번 수헹
            innerRecur(0, 0);
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (v[i]) continue;
            v[i] = true;
            temp[n] = i;
            recur(n + 1);
            v[i] = false;
        }
    }

    static class Person {
        int id;
        int[] skills = new int[5];

        public Person(int id, int[] skills) {
            this.id = id;
            this.skills = skills;
        }
    }
}