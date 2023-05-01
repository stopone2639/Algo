import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백트래킹 조합
 */
public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[M];
        visit = new boolean[N+1];
        DFS(0, 0);
    }
    public static void DFS(int r, int start){
        if(r == M){
            for(int i = 0; i < M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start + 1; i <= N; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[r] = i;
                DFS(r + 1, i);
                visit[i] = false;
            }
        }
    }
}
