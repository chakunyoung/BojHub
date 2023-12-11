import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String s = br.readLine();
		int i = Integer.parseInt(br.readLine());
		System.out.println(s.substring(i - 1, i));
		
		
	}
}
