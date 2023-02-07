import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * visit 배열 N+1 크기로 생성, 인접 행렬[N+1][N+1] 생성
 * visit false이면 cnt++ 하고 dfs로 인접한 노드들 visit true 처리
 */
public class Main {
    static boolean[] visit;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        arr = new int[N+1][N+1];
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            arr[num][num2] = arr[num2][num] = 1;
        }
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            if(visit[i] == false){
                cnt++;
                Stack<Integer> stack = new Stack<>();
                stack.add(i);
                while(!stack.isEmpty()){
                    Integer cur = stack.pop();
                    visit[cur] = true;
                    for(int j =1; j <= N; j++){
                        if(visit[j] == false && arr[cur][j] == 1){
                            stack.push(j);
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
