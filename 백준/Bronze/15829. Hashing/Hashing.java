import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        String str = br.readLine();

        BigInteger bi = new BigInteger("0");
        for(int i = 0; i<str.length(); i++){
            int num = str.charAt(i) - 'a' + 1;
            BigInteger temp = new BigInteger("31").pow(i).mod(new BigInteger("1234567891"));
            bi = bi.add(new BigInteger(String.valueOf(num)).multiply(temp)).mod(new BigInteger("1234567891"));
        }
        System.out.println(bi.mod(new BigInteger("1234567891")));
    }
}