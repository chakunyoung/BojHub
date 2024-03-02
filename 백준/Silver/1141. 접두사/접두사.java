import java.io.*;
import java.math.BigInteger; // subtract , multiply, add, mod
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[][] arr;
    static int[][] rgb;
    static int arrN, rgbN;
    static int size;

    public static void main(String[] args) throws IOException {
        // 입력부
        // 자신으로 시작하는지 보고 자신을 버림 true면 자신을 버림 해당 인덱스를 버림

        int count = Integer.parseInt(br.readLine());

        String[] strs = new String[count];
        for(int i =0; i<count; i++){
            strs[i] = br.readLine();
        }

        Arrays.sort(strs);
        List<String> list = new ArrayList<>();

        for(int i = 0 ; i <strs.length;i++){
            String firstStr = strs[i];
            boolean b = false;
            for(int j = i + 1; j<strs.length; j++){
                String secStr = strs[j];
                if(secStr.startsWith(firstStr)){
                    b = true;
                    break;
                }
            }
            if(!b)
                list.add(firstStr);
        }
        System.out.println(list.size());
    }
}