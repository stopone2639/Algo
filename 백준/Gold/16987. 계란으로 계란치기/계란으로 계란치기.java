import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] dura, weight;
    static int N, max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dura = new int[N];
        weight = new int[N];
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            dura[i] = Integer.parseInt(input[0]);
            weight[i] = Integer.parseInt(input[1]);
        }
        max = Integer.MIN_VALUE;
        DFS(0, 0);
        System.out.println(max);
    }
    public static void DFS(int r, int cnt){
        if(r == N){
            max = Math.max(max, cnt);
            return;
        }

        if(dura[r] <= 0 || cnt == N-1){
            DFS(r+1, cnt);
            return;
        }
        int nCnt = cnt;
        for(int i = 0; i < N; i++){
            if(i==r) continue;
            if(dura[i] <= 0) continue;
            breakEgg(r, i);
            if(dura[r] <= 0) cnt++;
            if(dura[i] <= 0) cnt++;
            DFS(r + 1, cnt);
            resetEgg(r, i);
            cnt = nCnt;
        }
    }
    public static void resetEgg(int index1, int index2){
        dura[index1] += weight[index2];
        dura[index2] += weight[index1];
    }
    public static void breakEgg(int index1, int index2){
        dura[index1] -= weight[index2];
        dura[index2] -= weight[index1];
    }
}
