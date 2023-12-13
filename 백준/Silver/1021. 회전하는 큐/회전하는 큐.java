import java.util.*;
import java.io.*;

public class Main {

    static Deque<Integer> d = new LinkedList<>();
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        for(int i=1; i<=size; i++)
            d.add(i);

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int ans = 0;

        for(int i = 0; i<list.size(); i++){

            int selected = list.get(i);

            int lCount = leftPollCalc(selected);
            int rCount = rightPollCalc(selected);

            if(lCount < rCount){
                ans += lCount;
                leftPoll(selected);
            }else{
                ans += rCount;
                rightPoll(selected);
            }
        }
        System.out.println(ans);
    }

    public static int leftPollCalc(int number){
        int count = 0;

        while(true){
            Integer poll = d.pollFirst();
            s.push(poll);
            if(poll == number)
                break;
            ++count;
        }

        while(!s.empty())
            d.addFirst(s.pop());

        return count;
    }

    public static int rightPollCalc(int number){
        int count = 0;
        while(true){
            Integer poll = d.pollLast();
            s.push(poll);
            if(poll == number)
                break;
            ++count;
        }

        while(!s.empty())
            d.addLast(s.pop());

        return count + 1;
    }

    public static void leftPoll(int number){
        while(true){
            Integer poll = d.pollFirst();
            if(poll == number){
                break;
            }
            d.addLast(poll);
        }
    }

    public static void rightPoll(int number){
        while(true){
            Integer poll = d.pollLast();
            if(poll == number)
                break;
            d.addFirst(poll);
        }
    }
}