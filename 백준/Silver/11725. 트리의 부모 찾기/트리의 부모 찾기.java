import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * answer 배열, visit 배열
 * arrList<ArrList>를 이용한 그래프
 * 1부터 bfs 하며 부모에서 자식 찾아서 자식 answer 배열에 부모 넣어주기
 */
public class Main {
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static boolean[] visit;
    public static int[] answer;
    public static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        answer = new int[N+1];
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        bfs();
        for(int i = 2; i <=N; i++){
            sb.append(answer[i] + "\n");
        }
        System.out.println(sb);
    }
    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;
        while (!queue.isEmpty()){
            int num = queue.poll();
            for(int i =0; i < graph.get(num).size(); i++){
                int child = graph.get(num).get(i);
                if(visit[child]) continue;
                visit[child] = true;
                answer[child] = num;
                queue.add(child);
            }
        }
    }
}
