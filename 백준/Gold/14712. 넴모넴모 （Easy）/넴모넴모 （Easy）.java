import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 0,0부터 오른쪽, 아래로 뻗어나가기
 */
public class Main {
    static int N, M, answer;
    static int[][] arr;
    static int[][] dir = {{-1,0}, {0,-1}, {-1,-1}, {0,0}}; //왼쪽, 왼쪽 위, 위, 본인 체크
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][M];
        answer = 0;
        DFS(0,0);
        System.out.println(answer);
    }

    public static void DFS(int r, int c){
        if(r == N-1 && c == M-1){
            arr[r][c] = 1;
            if(!check(r,c)){
                answer++;
            }
            arr[r][c] = 0;
            answer++;
            return;
        }
        if(check(r,c)){
            if(c == M-1) {
                DFS(r+1, 0);
            } else{
                DFS(r, c+1);
            }
        } else{
            arr[r][c] = 1;
            if(c == M-1) {
                DFS(r+1, 0);
            } else{
                DFS(r, c+1);
            }
            arr[r][c] = 0;
            if(c == M-1) {
                DFS(r+1, 0);
            } else{
                DFS(r, c+1);
            }
        }
    }
    public static boolean check(int r, int c){
        int cnt = 0;
        for(int i = 0; i < 3; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if(nr >= 0 && nr < N && nc >=0 && nc < M){
                if(arr[nr][nc] == 1) cnt++;
            }
        }
        if(cnt == 3){
            return true;
        }
        return false;
    }
}
