import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백트래킹
 * 이 인덱스를 고르거나 안고르는 가지로 뻗어나가기
 * depth가 N이 되면 return
 * 합이 S면 cnt++
 * S == 0이면 아무것도 선택하지 않는 경우가 추가되서 cnt--
 */
public class Main {
    static int N, S;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        arr = new int[N];
        cnt = 0;
        String[] input2 = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input2[i]);
        }
        DFS(0, 0);
        if(S == 0) cnt--;
        System.out.println(cnt);
    }
    public static void DFS(int sum, int depth){
        if(depth == N){
            if(sum == S){
                cnt++;
            }
            return;
        }
        DFS(sum + arr[depth], depth + 1);
        DFS(sum, depth + 1);
    }
}
