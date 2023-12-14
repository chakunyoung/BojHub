import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<size; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort((o1, o2) -> o1 - o2);

        int t = (int) Math.round((double)list.size() * 15/100);

        int total = 0;
        int count = 0;
        for(int i = t; i < list.size() - t ; i++){
            total += list.get(i);
            ++count;
        }

        System.out.println((int) Math.round((double) total/count));

    }
}