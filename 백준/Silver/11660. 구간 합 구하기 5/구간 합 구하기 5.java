import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2차원 배열 구간합 구하기
 * 1행과 1열의 구간합을 먼저 구하고 나머지 구간합은 D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + arr[i][j]
 * X1 Y1부터 X2 Y2까지 구간합은 D[X2][Y2] - D[X1- 1][Y2] - D[X2][Y1-1] + D[X1-1][Y1-1]
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[][] arr = new int[N+1][N+1];
        int[][] hap = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <=N; j++){
                arr[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        for(int i = 1; i <=N; i++){ //1행 구간합 구하기
            hap[1][i] = hap[1][i-1] + arr[1][i];
        }
        for(int i = 1; i <=N; i++){ //1열 구간합 구하기
            hap[i][1] = hap[i-1][1] + arr[i][1];
        }
        for(int i = 2; i <= N; i++){ //구간합 구하기
            for(int j = 2; j <=N; j++){
                hap[i][j] = hap[i-1][j] + hap[i][j-1] - hap[i-1][j-1] + arr[i][j];
            }
        }
        for(int i = 0; i < M; i++){
            String[] XY = br.readLine().split(" ");
            int X1 = Integer.parseInt(XY[0]);
            int Y1 = Integer.parseInt(XY[1]);
            int X2 = Integer.parseInt(XY[2]);
            int Y2 = Integer.parseInt(XY[3]);
            int res = hap[X2][Y2] - hap[X1 - 1][Y2] - hap[X2][Y1 - 1] + hap[X1-1][Y1-1];
            System.out.println(res);
        }
    }
}
