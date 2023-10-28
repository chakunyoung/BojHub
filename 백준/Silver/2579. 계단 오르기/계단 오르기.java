import java.io.*;
import java.util.Arrays;
/*
iv에 먼저 전역으로 생성해두고 입력받은 후 iv에 입력하면 모든함수에서 사용가능.
main, 구현 함수에서도 쓰일 때, 함수의 인자로 넘겨주기 싫을 때
 */

// 중복조합.
// 경우의수 count
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] dp = new int[301];
    static boolean[] check = new boolean[301];

    public static void main(String[] args) throws IOException {
        //String input = br.readLine();
        //StringTokenizer st = new StringTokenizer(input);
        int input = Integer.parseInt(br.readLine());
        //int money = Integer.parseInt(st.nextToken());
        int aa = input;
       

        //계단은 한번에 1개 or 2개

        // max(이전계단 -1 , 이전계단 -2)
        // 연속된 계단 3개는 밟는게 불가능.
        // 마지막 계단은 반드시 밟아야함.
        int [] stairs = new int[input];
        int k=0;
        while(input-- > 0){
            stairs[k++] = Integer.parseInt(br.readLine());
        }
        //System.out.println(Arrays.toString(stairs));

//        dp[0] = stairs[0];
//        dp[1] = stairs[1] + stairs[0];
//        if(stairs[1] > stairs[0]) {
//            dp[2] = stairs[2] + stairs[1];
//            check[1] = true;
//        }else
//            dp[2] = stairs[2] + stairs[0];
//
//        for(int j = 3; j<stairs.length; j++) {
//            if(check[j-2] == true){ // 사용했으므로 무조건 i-2 // 이전 반복 j-1일때 j-1이 j-2를 사용했다는 뜻.
//                dp[j] = stairs[j] + dp[j-2];
//            }
//            else{ // 선택해야 하는 상황.
//                dp[j] = stairs[j] + Math.max(dp[j-1], dp[j-2]);
//                if(dp[j-1] > dp[j-2]) {
//                    check[j - 1] = true;
//                }
//            }
//        }

        // (5)가 도착이라고 할 때, idx (3), (4)를 같이 사용하지 못함. 둘중 하나를 선택해야함.
        // 지금 짠 코드는 (5)도착을 고려하지않고 최대값,check 에 해당되서 (3), (4)를 같이 써버림.
        // 해당 층에서 두가지 경우(한칸뛰기, 두칸뛰기)중 최적의 선택을 해야되는데, j-2 가 true 이면 사용하지 못한다는 조건때문에 어거지로 j-1을 사용하게 됨

        // 그래서 dp -3 까지 사용하는걸로하고, 5는 dp[2] + stairs[4] + stairs[5] 로 간격을주고 사용하면 위 조건을 통과할 수 잇음.
        if(aa >= 3) {

            dp[0] = stairs[0];
            dp[1] = stairs[1] + stairs[0];
            if (stairs[0] > stairs[1])
                dp[2] = stairs[2] + stairs[0];
            else
                dp[2] = stairs[2] + stairs[1];

            for (int i = 3; i < stairs.length; i++) {
                dp[i] = Math.max(stairs[i - 1] + dp[i - 3], dp[i - 2]) + stairs[i];
            }

            //System.out.println(Arrays.toString(dp));
            System.out.println(dp[stairs.length - 1]);
        }else if(aa == 2){
            dp[0] = stairs[0];
            dp[1] = stairs[1] + stairs[0];
            System.out.println(dp[stairs.length - 1]);
        }else{
            dp[0] = stairs[0];
            System.out.println(dp[0]);
        }


    }
}
