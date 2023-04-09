import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 외판원 문제
 * 어느 곳에도 시작해도 경로만 같으면 비용이 같다.
 * 그래서 시작점을 하나일 때만 DFS 돌린 것과 시작점을 모든 점을 DFS 돌린 결과가 최솟값이 같다.
 * 중지 조건 N-1일 때 다 돌고 시작점으로 가는 상황, 시작점으로 갈 수 있으면 sum에 더하고 min과 비교 후 값 바꿔주기
 */
public class Main {
    static int N, min;
    static int[][] arr;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        min = Integer.MAX_VALUE;
        visit = new boolean[N];
        visit[0] = true;
        DFS(0, 0, 0, 0);
//        for(int i = 0; i < N; i++){
//            visit = new boolean[N];
//            visit[i] = true;
//            DFS(0, i, 0, i);
//        }
        System.out.println(min);
    }
    public static void DFS(int r, int now, int sum, int start){
        if(r == N-1){
            if(arr[now][start] != 0){
                min = Math.min(min, sum + arr[now][start]);
            }
            return;
        }
        for(int i = 0; i < N; i++){
            if(!visit[i] && now != i && arr[now][i] != 0){
                visit[i] = true;
                DFS(r+1, i, sum + arr[now][i], start);
                visit[i] = false;
            }
        }
    }
}
