import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int number = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i = 1; i<=500; i++){
			for(int j = 1; j<=500; j++){
				int n1 = i*i;
				int n2 = j*j;

				if(n1 - n2 == number)
					count++;
			}
		}
		System.out.println(count);
	}
}