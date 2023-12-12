import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        // int N = Integer.parseInt(br.readLine()); // 정수로 입력받을 때
        int N = Integer.parseInt(br.readLine());
        //StringTokenizer st = new StringTokenizer(br.readLine());;
        int[] s = new int[10_001];
        Arrays.fill(s, 0);

        short sss = 0;
        while (N-- > 0) {
            sss = Short.parseShort(br.readLine());
            s[sss]++;
        }

        for(int i = 0; i<10001; i++){
            while(s[i] > 0){
                sb.append(i).append("\n");
                s[i]--;
            }


        }
        System.out.println(sb);
    }
}

