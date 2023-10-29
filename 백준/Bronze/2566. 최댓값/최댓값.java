
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[9][9];
		
		for(int i = 0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		int row = 1;
		int col = 1;
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				if(max < arr[i][j]) {
					max = arr[i][j];
					row = i + 1;
					col = j + 1;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(row + " " + col);
		
	}
}
