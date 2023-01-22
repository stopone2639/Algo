import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int[] arr = new int[N];
        for(int i =1; i <= N; i++){
            queue.offer(i);
        }
        int sum = 1;
        sb.append("<");
        while (true){
            if(queue.isEmpty()){
                break;
            }
            if(sum%K == 0){
                sb.append(queue.poll()).append(", ");
            } else{
                queue.offer(queue.poll());
            }
            sum++;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(">");
        System.out.println(sb);
    }
}
