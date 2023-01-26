import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 우선순위 큐 사용
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(st.nextToken());
                pq.add(num);
            }
        }
        for(int i = 0; i < N; i++){
            if(i == N-1){
                System.out.println(pq.peek());
            } else{
                pq.poll();
            }
        }
    }
}
