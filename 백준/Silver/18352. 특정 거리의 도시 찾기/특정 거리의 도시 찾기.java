import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M, K, X;
    static int[] dis;
    static boolean[] visit;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        X = Integer.parseInt(input[3]);
        list = new ArrayList[N+1];
        dis = new int[N+1];
        visit = new boolean[N+1];
        for(int i = 0; i<=N;i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            list[A].add(B);
        }
        bfs(X);
        boolean check = false;
        for(int i = 1; i <= N; i++){
            if(dis[i] == K){
                sb.append(i + "\n");
                check = true;
            }
        }
        if(!check){
            sb.append(-1);
        }
        System.out.println(sb.toString());
     }
    public static void bfs(int start){
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(start);
        visit[start] = true;
        while(!qu.isEmpty()){
            int cur = qu.poll();
            for(int num : list[cur]){
                if(!visit[num]){
                    qu.add(num);
                    visit[num] = true;
                    dis[num] = dis[cur] + 1;
                }
            }
        }
    }
}
