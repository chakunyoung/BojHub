import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int removeCount = Integer.parseInt(st.nextToken());

        int[] arr = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int s = 0, e = 0;
        int tempCount = 0;
        int result = 0;

        // 다음 e를 확인, 짝수일 경우 count++
        // 홀수일 경우 remove 를 사용,
        // remove가 없으면,
        // s 위치가 짝수일 경우 (temp count를 줄이고 s++)
        // s 위치가 짝수가 아닐 경우 (remove ++ , s++)
        
        while (e < size) {
            if (arr[e] % 2 == 0) {
                tempCount++;
                e++;
            } else {
                if (removeCount > 0) {
                    removeCount--;
                    e++;
                    // remove도 없고, 다음은 홀수
                    // 그럼 s를 당긴다.
                } else {
                    if (s < e) {
                        if(arr[s] % 2 != 0)
                        	removeCount++;
                        else
                        	tempCount--;
                        s++;
                    }else {
                    	break;
                    }
                }
            }
            result = Math.max(result, tempCount);
        }

        System.out.println(result);
    }
}
