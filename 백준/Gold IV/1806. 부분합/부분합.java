import java.io.*;
import java.math.BigInteger;
import java.util.*;
/*
iv에 먼저 전역으로 생성해두고 입력받은 후 iv에 입력하면 모든함수에서 사용가능.
main, func 에서도 쓰일 때, 함수의 인자로 넘겨주기 싫을 때
 */

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        //int input = Integer.parseInt(br.readLine());
        N = Integer.parseInt(st.nextToken()); // arr 개수
        M = Integer.parseInt(st.nextToken()); // 찾고자 하는 sum
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i =0; i<arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int pluspoint = 0;
        int minuspoint = 0;
        int total = 0;

        int minidx = Integer.MAX_VALUE;

        int minidxs = 0;
        int minidxe = 0;
        total = arr[0];
        if(total >= M)
            minidx = 1;

        while(true){

            //idx 감소
            if(total >= M && minuspoint < pluspoint  || pluspoint == arr.length - 1 ) { // total 이상 // minuspoint < pluspoint
                total -= arr[minuspoint]; // 현재위치 point 값을 뺌
                minuspoint++; //mp 증가
            }

            //idx 증가
            else if(pluspoint < arr.length - 1) {
                pluspoint++; // 작을시 pp 증가
                total += arr[pluspoint]; // 증가한위치값 total에 더함.
            }

            //min 갱신 부분
            if(total >= M && minidx > pluspoint - minuspoint){
                minidx = pluspoint - minuspoint + 1;
                minidxs = minuspoint;
                minidxe = pluspoint;
            }

            //System.out.println(minuspoint + " "+ pluspoint + " "+minidx + " " + total);
            if(minuspoint == arr.length - 1) // minusPoint 가 끝까지 오면 종료.
                break;
            else if(pluspoint == arr.length - 1 && minuspoint == 0 && minidx == Integer.MAX_VALUE)
                break;


        }
        if(minidx == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(minidx);
    }
}
