import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long result = fac(n);
        System.out.println(result);
    }
    public static long fac(long l){
        if(l == 1 || l == 0)
            return 1;
        long b = l * fac(l-1);
        return b;
    }
}