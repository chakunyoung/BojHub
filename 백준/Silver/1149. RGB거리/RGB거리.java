import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int[][] house;

    public static void main(String[] args) throws IOException {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //int house = Integer.parseInt(st.nextToken());
        int houseCount = Integer.parseInt(br.readLine());
        house = new int[houseCount][3];

        for(int i = 0; i<houseCount; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());

        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i<houseCount; i++){ // 행의 수 // 0번까지는 현재까지 최소값이 저장되어 있음
            for(int j =0; j<3; j++){ // 열의 수 // 최소값을 계속 저장하면서 감 // 자신을 제외한 각 열마다. // i 가 다음집
            min = Integer.MAX_VALUE;
                for(int k =0; k<3; k++){ // k 가 이전집.
                    if(j == k)
                        continue;

                    if(house[i-1][k] + house[i][j] < min)
                        min = house[i-1][k] + house[i][j];

                }
                house[i][j] = min;
            }

        }


        min = Integer.MAX_VALUE;
        for(int k = 0; k<3; k++){
            if(house[houseCount - 1][k] < min)
                min = house[houseCount - 1][k];
        }
        System.out.println(min);

    }
}


