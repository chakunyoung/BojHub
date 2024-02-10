import javax.swing.plaf.IconUIResource;
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String aaa = br.readLine();
//        StringTokenizer st = new StringTokenizer(aaa);
//        int A = Integer.parseInt(st.nextToken());
//        int B = Integer.parseInt(st.nextToken());

        String A = br.readLine();
        //int A = Integer.parseInt(br.readLine());
        A = A.toUpperCase();
        int[] al = new int[26];
        Arrays.fill(al, 0);
        for(int i =0; i<A.length(); i++){
            al[A.charAt(i) - 'A'] += 1;

        }
        int max = -1;
        int maxidx = 0;
        int i =0;
        for(int a: al) {
            if (max < a){
                max = a;
                maxidx = i;
            }
            i++;
        }
        int j =0;
        for(int b: al){
            if(max == b && maxidx != j)
                maxidx = '?' - 'A';
            j++;
        }
        char c = (char) (maxidx + 'A');
        bw.write(c+" ");
        bw.flush();
        bw.close();
    }
}

