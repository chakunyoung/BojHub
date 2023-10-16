import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int dist[];
    static int[] times;
    static int[] buildTimes;

    static List<Integer> lastTimes = new ArrayList<>();

    //StringTokenizer
    //br.readLine()
    public static void main(String[] args) throws IOException {
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int set = Integer.parseInt(br.readLine());
        while(set --> 0) {
            int[] buildingAndlines = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildingAndlines[0] = Integer.parseInt(st.nextToken()) + 1;
            buildingAndlines[1] = Integer.parseInt(st.nextToken());
            List<List<Integer>> list = new ArrayList<>();
            dist = new int[buildingAndlines[0]];

            String timesStr = br.readLine();
            StringTokenizer timeST = new StringTokenizer(timesStr, " ");
            int timesCount = 1;
            times = new int[buildingAndlines[0]];
            buildTimes = new int[buildingAndlines[0]];
            while(timeST.hasMoreTokens()){
                times[timesCount++] = Integer.parseInt(timeST.nextToken());
            }

            while(buildingAndlines[0]--> 0) { // 건물개수
                list.add(new ArrayList<>());
            }

            while(buildingAndlines[1]--> 0){ // lines
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st1.nextToken());
                int e = Integer.parseInt(st1.nextToken());
                list.get(s).add(e);
                dist[e]++;
            }
            int target = Integer.parseInt(br.readLine());

            TS(list, target);
            lastTimes.add(buildTimes[target]);
        }
        for(int e : lastTimes){
            sb.append(e).append("\n");
        }
        System.out.println(sb);
    }
    public static void TS(List<List<Integer>> list, int target){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i< dist.length; i++){
            if(dist[i] == 0) {
                q.offer(i); // starts
                buildTimes[i] = times[i];
            }
        }

        while(!q.isEmpty()){
            int s = q.poll(); // s가 가르키는
            for(int t : list.get(s)){ // 목적지 t
                dist[t]--;
                if(dist[t] == 0)
                    q.offer(t);
                buildTimes[t] = Math.max(buildTimes[t], buildTimes[s] + times[t]);
            }
        }

    }
}
class Nodes{
    int s;
    int e;

    Nodes(int s,int e){
        this.s = s;
        this.e = e;
    }

}