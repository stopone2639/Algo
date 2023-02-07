import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * dfs 이용
 * boolean 배열 visit
 * for문으로 배열에서 1이고 visit false면 cnt++
 * 인접한 배추를 dfs로 visit true로 변경 시켜주기
 */
public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int N, M;
    public static class BaeChu{
        int x, y;
        BaeChu(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < Tc; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            visit = new boolean[N][M];
            int cnt = 0;
            for(int i =0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                arr[c][r] = 1;
            }
            for(int i =0; i < N; i++){
                for(int j = 0; j<M; j++){
                    if(arr[i][j] == 1 && visit[i][j] == false){
                        cnt++;
                        dfs(i,j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
    public static void dfs(int x, int y){
        Stack<BaeChu> stack = new Stack<>();
        stack.push(new BaeChu(x, y));
        while(!stack.isEmpty()){
            BaeChu baeChu = stack.pop();
            visit[baeChu.x][baeChu.y] = true;
            for(int d = 0; d < 4; d++){
                int dx = baeChu.x + dir[d][0];
                int dy = baeChu.y + dir[d][1];
                if(dx < N && dx >=0 && dy < M && dy >=0){
                    if(arr[dx][dy] == 1 && visit[dx][dy] == false){
                        stack.push(new BaeChu(dx, dy));
                    }
                }
            }
        }
    }
}
