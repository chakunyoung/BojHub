import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		BigInteger t = new BigInteger(br.readLine(), 2);
		String e = t.toString(8);
		System.out.println(e);

	}
}
