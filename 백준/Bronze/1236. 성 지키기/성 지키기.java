import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        long[] rowLayer = new long[row];
        long[] colLayer = new long[col];

        for (int i = 0; i < row; i++) {
            String s = br.readLine();
            for (int j = 0; j < col; j++) {
                if (s.charAt(j) == 'X') {
                    rowLayer[i] |= 1L << j; 
                    colLayer[j] |= 1L << i; 
                }
            }
        }

        int emptyRows = 0;
        int emptyCols = 0;
        for (int i = 0; i < row; i++) 
            if (rowLayer[i] == 0) emptyRows++;
        for (int j = 0; j < col; j++) 
            if (colLayer[j] == 0) emptyCols++;
        System.out.println(Math.max(emptyRows, emptyCols));
    }
}
