import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            queue.add(i);
        }
        int res = 0;
        while (queue.size() > 0){
            res = queue.poll();
            if(queue.size() > 0){
                int num = queue.poll();
                queue.add(num);
            }
        }
        System.out.println(res);
    }
}
