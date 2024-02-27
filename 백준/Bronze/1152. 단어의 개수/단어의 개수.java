

import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String aaa = br.readLine();
//        StringTokenizer st = new StringTokenizer(aaa);
//        int A = Integer.parseInt(st.nextToken());
//        int B = Integer.parseInt(st.nextToken());

        String A = br.readLine().toLowerCase();
        //int A = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(A);

        while (st.hasMoreTokens()){
            list.add(st.nextToken());

        }
        bw.write(list.size()+" ");
        bw.flush();
        bw.close();
    }
}

