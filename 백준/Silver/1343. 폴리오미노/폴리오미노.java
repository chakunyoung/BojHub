import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{

        String str = br.readLine();

        // 2의 배수이면 채울 수 있다.
        // 4이상이면 AAAA 를 먼저 채우고 나머지를 BB로 채운다.
        int count = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == 'X') {
                count++;

                if(count == 4){
                    sb.append("AAAA");
                    count = 0;
                }
            }else{  // .등장
                if(count == 2) {
                    sb.append("BB");
                    count = 0;
                }
                sb.append(".");

                if(count % 2 != 0){
                    System.out.println(-1);
                    return;
                }

            }
        }

        if(count == 2){
            sb.append("BB");
        }else if(count == 0) {
            
        }else{
            System.out.println(-1);
            return;
        }
        System.out.println(sb);


    }
}

