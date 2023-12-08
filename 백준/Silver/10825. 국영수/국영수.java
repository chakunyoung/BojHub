import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //int numberCount = Integer.parseInt(st.nextToken());

        int students = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();

        while( students -- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Student(st.nextToken(),
                    Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                                    Integer.parseInt(st.nextToken())
            ));
        }

        list.sort((s1, s2)->
        {
            if(s1.k == s2.k){
                if(s1.e == s2.e){
                    if(s1.m == s2.m){
                        return s1.name.compareTo(s2.name);
                    }
                    else
                        return s2.m - s1.m;
                }else
                    return s1.e-s2.e;
            }else
                return s2.k - s1.k;
        });

        StringBuilder sb = new StringBuilder();

        for(Student s : list){
            sb.append(s.name).append("\n");
        }
        System.out.println(sb);

    }
}

class Student{
    String name;
    int k;
    int e;
    int m;
    public Student(String name, int k, int e, int m){
        this.name = name;
        this.k = k;
        this.e = e;
        this.m = m;
    }
}