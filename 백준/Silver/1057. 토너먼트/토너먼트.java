import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String brs = br.readLine();
        StringTokenizer st = new StringTokenizer(brs);

        int players = Integer.parseInt(st.nextToken());
        int yellow = Integer.parseInt(st.nextToken());
        int slayer = Integer.parseInt(st.nextToken());
        int tmp =0;
        
        if(slayer < yellow){ // yellow 가 더클 때
            tmp = slayer;
            slayer = yellow;
            yellow = tmp;
        }

        int lim = 0;
        for(int i =1; i<=17; i++){
            lim = (int)Math.pow(2, i);
            if(players <= lim){
                lim = i;
                break;
            }
        }
        int ggak = 0;
        int count = 0;
        // 경기진행
        for( int j = 1; j<=lim; j++){
            if(players % 2 == 1) // 홀수
                ggak = 1;
            if(ggak == 1 && (players % 2) == 1){
                players += 1;
                ggak = 0;
            }

            count++;
            // 매칭됨
            if(yellow % 2 == 1 && yellow + 1 == slayer)
                break;

            //번호 다시매기기
            if( slayer % 2 == 1)
                slayer = slayer / 2 + 1;
            else
                slayer /=2;

            if( yellow % 2 == 1)
                yellow = yellow / 2 + 1;
            else
                yellow /=2;

            //반으로 나눔
            players /= 2;
        }
        System.out.println(count);

    }
}


