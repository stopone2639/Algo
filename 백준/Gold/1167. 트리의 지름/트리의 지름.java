import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS 이용
 * 트리의 모든 정점을 BFS 실행하면 시간이 많이 들어감
 * 임의의 한 정점을 통해 가장 먼 정점을 구하면 그 정점은 트리의 지름을 구성하는 정점 2개중 하나
 * 그 정점에서 BFS를 수행 후 가장 먼 정점과의 거리가 정답
 */
public class Main {
    static int[] dis;
    static ArrayList<Node>[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N + 1];
        dis = new int[N+1];
        visit = new boolean[N+1];
        for(int i = 0; i <=N; i++){
            arr[i] = new ArrayList<Node>();
        }
        for(int i = 1; i <=N; i++){
            String[] str = br.readLine().split(" ");
            int index = Integer.parseInt(str[0]);
            int cnt = 1;
            while(true){
                int E = Integer.parseInt(str[cnt]);
                if(E == -1) break;
                cnt++;
                int V = Integer.parseInt(str[cnt]);
                arr[index].add(new Node(E, V));
                arr[E].add(new Node(index, V));
                cnt++;
            }
        }
        bfs(1);
        int max = 0;
        for(int i = 1; i <= N; i++){
            if(dis[max] < dis[i]){
                max = i;
            }
        }
        dis = new int[N+1];
        visit = new boolean[N+1];
        bfs(max);
        Arrays.sort(dis);
        System.out.println(dis[N]);
    }
    static void bfs(int num){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        dis[num] = 0;
        visit[num] = true;
        while(!queue.isEmpty()){
            Integer cur = queue.poll();
            for(Node n : arr[cur]){
                int e = n.edge;
                int v = n.value;
                if(!visit[e]){
                    dis[e] = dis[cur] + v;
                    visit[e] = true;
                    queue.add(e);
                }
            }
        }
    }
    static class Node{
        int edge;
        int value;
        public Node(int edge, int value){
            this.edge = edge;
            this.value = value;
        }
    }
}
