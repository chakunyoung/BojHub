import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int f1 = Integer.parseInt(st.nextToken());
		int f2 = Integer.parseInt(st.nextToken());
		int f3 = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());

		for(int i = 0; i<=300; i++){
			for (int j = 0; j <= 300; j++) {
				for (int k = 0; k <= 300; k++) {
					if(f1 * i + f2 * j + f3 * k > count){
						break;
					}

					if(f1 * i + f2 * j + f3 * k == count){
						System.out.println(1);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
}