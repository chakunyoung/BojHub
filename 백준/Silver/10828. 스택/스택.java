import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack= new Stack<>();
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(s.readLine());
        Integer i = 0;

        while(num > 0){
            String[] o = s.readLine().split(" ");

            if(o.length >= 2) {
                i = Integer.valueOf(o[1]);
            }
            if(o[0].equals("push")) {
                stack.push(i);
            }else if(o[0].equals("top")) {
                if(stack.empty()){
                    bw.write(-1+ "\n");
                }
                else{
                    bw.write(stack.peek()+ "\n");
                }
                bw.flush();
            }else if(o[0].equals("size")) {
                bw.write(stack.size()+ "\n");
                bw.flush(); // write로 담은 내용 출력 후, 버퍼를 비움.
            }else if(o[0].equals("empty")) {
                if(stack.empty()){
                    bw.write(1+ "\n");
                }
                else {
                    bw.write(0+ "\n");
                }
                bw.flush(); // write로 담은 내용 출력 후, 버퍼를 비움.
            }else if(o[0].equals("pop")) {
                if(stack.empty()) {
                    bw.write(-1+ "\n");
                }
                else {
                    bw.write(stack.pop()+ "\n");
                }
                bw.flush();

            }
            num--;
        }
            bw.close();
    }
}


