import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //String input = br.readLine();
//        StringTokenizer st = new StringTokenizer(input);
//        String A = st.nextToken();
//        String B = st.nextToken();
//        int C = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(br.readLine());
        while(input> 0 ){
            //여기서부터 한라인
            String distance = br.readLine();
            StringTokenizer st = new StringTokenizer(distance);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int dis = B - A ;
            long tmp = 0;
            int i = 0; //시작 step
            int count = 0; // 작동횟수
            while(dis > 0) { // 남은거리확인
                long sum = 0;
                tmp = i + 1;

                sum = tmp*(tmp+1) / 2;

//                while(tmp > 0){ // step 올릴수 있나 확인
//                    sum += tmp;
//                    tmp--;
//                }

                if(dis - sum >= 0){ // step 을 올릴 수 있다.
                    i += 1;
                }else if(dis - (sum - (i+1)) >= 0){ // i 그대로 사용
                }
                else{ // step 을 못올림 -> 여기서 끝내도되.
                    if(i != 1)
                        i -= 1;
                    //count += i;
                    //break;
                }

                dis -= i;
                count++;
            }
            bw.write(count+"\n");
            input--;
        }
        bw.flush();
        bw.close();
    }
}

