import java.io.*;
import java.util.*;

public class Main {

    static int[] list = new int[1_000_004];
    static int[] digitCount = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int number = 1;
        int len = 0;
        while (len <= 1000002) {
            if (f(number)) {
            	list[len++] = number;
            }
            number++;
        }
        
        int inputNumber = 0;
        while (true) {
            inputNumber = Integer.parseInt(br.readLine());
            if (inputNumber == 0) break;
            sb.append(list[inputNumber-1]).append("\n");
        }

        System.out.println(sb);
    }

    public static boolean f(int number) {
        Arrays.fill(digitCount, 0);
        while (number > 0) {
            int digit = number % 10;
            digitCount[digit]++;
            if (digitCount[digit] > 1) {
                return false;
            }
            number /= 10;
        }

        return true;
    }
}
