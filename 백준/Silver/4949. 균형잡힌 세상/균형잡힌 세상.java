import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> s = new Stack<>();
        StringBuffer sb = new StringBuffer();
        String answer = "";

        while(true) {
            while(!s.empty())
                s.pop();
            //하나의 문장 처리
            String text = br.readLine();
            if(text.equals("."))
                break;

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (c == '(' || c == '[') {
                    s.push(c);
                }
                if (c == ')' || c == ']') {
                    char gc = ' ';
                    if(!s.empty())
                         gc= s.pop(); // gc가 여는 괄호
                    else{sb.append("no "); break;}

                    if(gc == '[')
                        gc += 1;
                    if(gc + 1 != c) {
                        sb.append("no ");
                        break;
                    }
                }
                if (i == text.length() - 1) {
                    if (s.empty() == true)
                        sb.append("yes ");
                    else
                        sb.append("no ");
                }
            }//for
        }//while
        String[] sss = new String(sb).split(" ");
        for (String s11 : sss){
            System.out.println(s11);
        }
    }
}



